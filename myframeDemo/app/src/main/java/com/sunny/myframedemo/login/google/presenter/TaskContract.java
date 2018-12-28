package com.sunny.myframedemo.login.google.presenter;

import android.support.annotation.NonNull;

import com.google.common.base.Strings;
import com.sunny.myframedemo.login.google.task.Task;
import com.sunny.myframedemo.login.google.task.TasksFilterType;
import com.sunny.myframedemo.login.google.view.BaseView;

import java.util.List;

/**
 * Created by Sunny on 18-12-24.
 */

//view和presenter接口的契约接口
public class TaskContract {

    interface View extends BaseView<Presenter>{
        void setLoadingIndicator(boolean active);

        void showTasks(List<Task> tasks);

        void showAddTask();

        void showTaskDetailsUi(String taskId);

        void showTaskMarkedComplete();

        void showTaskMarkedActive();

        void showCompletedTasksCleared();

        void showLoadingTasksError();

        void showNoTasks();

        void showActiveFilterLabel();

        void showCompletedFilterLabel();

        void showAllFilterLabel();

        void showNoActiveTasks();

        void showNoCompletedTasks();

        void showSuccessfullySavedMessage();

        boolean isActive();

        void showFilteringPopUpMenu();
    }

    interface Presenter extends  BasePresenter{

        void result(int requestCode,int resultCode);

        void loadTasks(boolean forceUpdate);

        void addNewTask();

        void openTaskDetails(@NonNull Task requestedTask);

        void completeTask(@NonNull Task completedTask);

        void activateTask(@NonNull Task activeTask);

        void clearCompletedTasks();

        void setFiltering(TasksFilterType tasksFilterType);

        TasksFilterType getFiltering();


    }

}
