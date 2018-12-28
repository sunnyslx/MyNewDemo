package com.sunny.myframedemo.login.google.presenter;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.sunny.myframedemo.login.google.addedittask.AddEditTaskActivity;
import com.sunny.myframedemo.login.google.task.Task;
import com.sunny.myframedemo.login.google.task.TaskRepository;
import com.sunny.myframedemo.login.google.task.TasksDataSource;
import com.sunny.myframedemo.login.google.task.TasksFilterType;
import com.sunny.myframedemo.login.google.utils.EspressoIdlingResource;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sunny on 18-12-24.
 */

public class TaskPresenter implements TaskContract.Presenter {
    private final TaskRepository mTaskRepository;

    private final TaskContract.View mTaskView;

    private TasksFilterType mCurrentFiltering = TasksFilterType.ALL_TASKS;

    private boolean mFirstLoad = true;

    public TaskPresenter(TaskRepository mTaskRepository, TaskContract.View mTaskView) {
        this.mTaskRepository = mTaskRepository;
        this.mTaskView = mTaskView;
        mTaskView.setPresenter(this);
    }

    @Override
    public void start() {
        loadTasks(false);
    }

    @Override
    public void result(int requestCode, int resultCode) {
        if (AddEditTaskActivity.REQUEST_ADD_TASK == requestCode && Activity.RESULT_OK == resultCode) {
            mTaskView.showSuccessfullySavedMessage();
        }
    }

    @Override
    public void loadTasks(boolean forceUpdate) {
        loadTasks(forceUpdate | mFirstLoad, true);
        mFirstLoad = false;
    }

    private void loadTasks(boolean forceUpdate, final boolean showLoadingUI) {
        if (showLoadingUI) {
            mTaskView.setLoadingIndicator(true);
        }

        if (forceUpdate) {
            mTaskRepository.refreshTasks();
        }

        EspressoIdlingResource.increment();
        mTaskRepository.getTasks(new TasksDataSource.LoadTasksCallback() {
            @Override
            public void onTasksLoaded(List<Task> tasks) {
                List<Task> tasksToShow = new ArrayList<>();

                if (!EspressoIdlingResource.getIdlingResource().isIdleNow()) {
                    EspressoIdlingResource.decrement();
                }

                for (Task task : tasks) {
                    switch (mCurrentFiltering) {
                        case ALL_TASKS:
                            tasksToShow.add(task);
                            break;
                        case ACTIVE_TASKS:
                            if (task.isActive()) {
                                tasksToShow.add(task);
                            }
                            break;
                        case COMPLETED_TASKS:
                            if (task.isCompleted()) {
                                tasksToShow.add(task);
                            }
                            break;
                        default:
                            tasksToShow.add(task);
                            break;
                    }
                }
                if (!mTaskView.isActive()) {
                    return;
                }
                if (showLoadingUI) {
                    mTaskView.setLoadingIndicator(false);
                }
                processTasks(tasks);
            }

            @Override
            public void onDataNotAvailable() {
                if (!mTaskView.isActive()){
                    return;
                }
                mTaskView.showLoadingTasksError();
            }
        });
    }

    private void processTasks(List<Task> tasks) {
        if (tasks.isEmpty()) {
            processEmptyTasks();
        } else {
            mTaskView.showTasks(tasks);
            showFilterLabel();
        }
    }

    private void showFilterLabel() {
        switch (mCurrentFiltering) {
            case ACTIVE_TASKS:
                mTaskView.showActiveFilterLabel();
                break;
            case COMPLETED_TASKS:
                mTaskView.showCompletedFilterLabel();
                break;
            default:
                mTaskView.showAllFilterLabel();
                break;
        }
    }

    private void processEmptyTasks() {
        switch (mCurrentFiltering) {
            case ALL_TASKS:
                mTaskView.showNoActiveTasks();
                break;
            case COMPLETED_TASKS:
                mTaskView.showNoCompletedTasks();
                break;
            default:
                mTaskView.showNoTasks();
        }
    }

    @Override
    public void addNewTask() {
        mTaskView.showAddTask();
    }

    @Override
    public void openTaskDetails(@NonNull Task requestedTask) {
        mTaskView.showTaskDetailsUi(requestedTask.getId());
    }

    @Override
    public void completeTask(@NonNull Task completedTask) {
        mTaskRepository.completeTask(completedTask);
        mTaskView.showTaskMarkedComplete();
        loadTasks(false,false);
    }

    @Override
    public void activateTask(@NonNull Task activeTask) {
        mTaskRepository.activateTask(activeTask);
        mTaskView.showTaskMarkedActive();
        loadTasks(false,false);

    }

    @Override
    public void clearCompletedTasks() {
        mTaskRepository.clearCompletedTasks();
        mTaskView.showCompletedTasksCleared();
        loadTasks(false,false);
    }

    @Override
    public void setFiltering(TasksFilterType tasksFilterType) {
        mCurrentFiltering=tasksFilterType;
    }

    @Override
    public TasksFilterType getFiltering() {
        return mCurrentFiltering;
    }
}
