package com.sunny.myframedemo.login.google.task;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by Sunny on 18-12-24.
 */

public class TaskRepository implements TasksDataSource{
    private static TaskRepository INSTANCE=null;

    private final TasksDataSource mTaskRemoteDataSource;

    private final TasksDataSource mTasksLocalDataSource;

    Map<String ,Task> mCachedTasks;

    boolean mCacheIsDirty=false;

    public TaskRepository(@NonNull TasksDataSource mTaskRemoteDataSource, @NonNull TasksDataSource mTasksLocalDataSource) {
        this.mTaskRemoteDataSource = mTaskRemoteDataSource;
        this.mTasksLocalDataSource = mTasksLocalDataSource;
    }

    public static TaskRepository getInstance(TasksDataSource mTaskRemoteDataSource,TasksDataSource mTasksLocalDataSource){
        if (INSTANCE==null){
            INSTANCE=new TaskRepository(mTaskRemoteDataSource,mTasksLocalDataSource);
        }
        return INSTANCE;
    }

    public static void destoryInstance(){
        INSTANCE=null;
    }

    @Override
    public void getTasks(@NonNull final LoadTasksCallback loadTasksCallback) {
        if (mCachedTasks !=null && mCacheIsDirty){
            loadTasksCallback.onTasksLoaded(new ArrayList<Task>(mCachedTasks.values()));
            return;
        }

        if (mCacheIsDirty){
            getTaskFromRemoteDataSource(loadTasksCallback);
        }else {
            mTasksLocalDataSource.getTasks(new LoadTasksCallback() {
                @Override
                public void onTasksLoaded(List<Task> tasks) {
                    refreshCache(tasks);
                    loadTasksCallback.onTasksLoaded(new ArrayList<Task>(mCachedTasks.values()));
                }

                @Override
                public void onDataNotAvailable() {
                    getTaskFromRemoteDataSource(loadTasksCallback);
                }
            });
        }
    }

    private void getTaskFromRemoteDataSource(@NonNull final LoadTasksCallback callback){
        mTaskRemoteDataSource.getTasks(new LoadTasksCallback() {
            @Override
            public void onTasksLoaded(List<Task> tasks) {
                refreshCache(tasks);
                refreshLocalDataSource(tasks);
                callback.onTasksLoaded(new ArrayList<Task>(mCachedTasks.values()));
            }

            @Override
            public void onDataNotAvailable() {
                callback.onDataNotAvailable();
            }
        });
    }

    private void refreshCache(List<Task> tasks){
        if (mCachedTasks ==null){
            mCachedTasks=new LinkedHashMap<>();
        }
        mCachedTasks.clear();

        for (Task task:tasks){
            mCachedTasks.put(task.getId(),task);
        }
        mCacheIsDirty=false;
    }

    private void refreshLocalDataSource(List<Task> tasks){
        mTasksLocalDataSource.deleteAllTasks();
        for (Task task:tasks){
            mTasksLocalDataSource.saveTask(task);
        }
    }
    @Override
    public void getTask(@NonNull final String taskId, @NonNull final GetTaskCallback callback) {
        final Task cachedTask=getTaskWithId(taskId);

        if (cachedTask!=null){
            callback.onTaskLoaded(cachedTask);
            return;
        }

        mTasksLocalDataSource.getTask(taskId, new GetTaskCallback() {
            @Override
            public void onTaskLoaded(Task task) {
                if (mCachedTasks==null){
                    mCachedTasks=new LinkedHashMap<>();
                }
                mCachedTasks.put(task.getId(),task);
                callback.onTaskLoaded(task);
            }

            @Override
            public void onDataNotAvailable() {
                mTaskRemoteDataSource.getTask(taskId, new GetTaskCallback() {
                    @Override
                    public void onTaskLoaded(Task task) {
                        if (mCachedTasks==null){
                            mCachedTasks=new LinkedHashMap<>();
                        }
                        mCachedTasks.put(task.getId(),task);
                        callback.onTaskLoaded(task);
                    }

                    @Override
                    public void onDataNotAvailable() {
                        callback.onDataNotAvailable();
                    }
                });
            }
        });
    }

    @Override
    public void saveTask(@NonNull Task task) {
        mTaskRemoteDataSource.saveTask(task);
        mTasksLocalDataSource.saveTask(task);

        if (mCachedTasks ==null){
            mCachedTasks=new LinkedHashMap<>();
        }
        mCachedTasks.put(task.getId(),task);
    }

    @Override
    public void completeTask(@NonNull String taskId) {
        completeTask(getTaskWithId(taskId));
    }

    @Override
    public void completeTask(@NonNull Task task) {

        mTaskRemoteDataSource.completeTask(task);
        mTasksLocalDataSource.completeTask(task);

        Task completeTask=new Task(task.getTitle(),task.getDescription(),task.getId(),true);
        if (mCachedTasks==null){
            mCachedTasks=new LinkedHashMap<>();
        }
        mCachedTasks.put(task.getId(),completeTask);
    }

    @Override
    public void activateTask(@NonNull Task task) {
            mTaskRemoteDataSource.activateTask(task);
            mTasksLocalDataSource.activateTask(task);

            Task activeTask=new Task(task.getTitle(),task.getDescription(),task.getId());

            if (mCachedTasks==null){
                mCachedTasks=new LinkedHashMap<>();
            }
            mCachedTasks.put(task.getId(),activeTask);
    }

    @Override
    public void activateTask(@NonNull String taskId) {
        activateTask(getTaskWithId(taskId));
    }

    @Override
    public void clearCompletedTasks() {
        mTaskRemoteDataSource.clearCompletedTasks();
        mTasksLocalDataSource.clearCompletedTasks();

        if (mCachedTasks==null){
            mCachedTasks=new LinkedHashMap<>();
        }
        Iterator<Map.Entry<String ,Task>> it=mCachedTasks.entrySet().iterator();

        while (it.hasNext()){
            Map.Entry<String ,Task> entry=it.next();
            if (entry.getValue().isCompleted()){
                it.remove();
            }
        }
    }

    @Override
    public void refreshTasks() {
        mCacheIsDirty=true;
    }

    @Override
    public void deleteAllTasks() {
        mTasksLocalDataSource.deleteAllTasks();
        mTaskRemoteDataSource.deleteAllTasks();

        if (mCachedTasks==null){
            mCachedTasks=new LinkedHashMap<>();

        }
        mCachedTasks.clear();
    }

    @Override
    public void deteleTask(@NonNull String taskId) {
        mTaskRemoteDataSource.deteleTask(taskId);
        mTasksLocalDataSource.deteleTask(taskId);
        mCachedTasks.remove(taskId);
    }

    @Nullable
    private Task getTaskWithId(@Nullable String id){
        if (mCachedTasks==null || mCachedTasks.isEmpty()){
            return null;
        }else {
            return mCachedTasks.get(id);
        }
    }

}
