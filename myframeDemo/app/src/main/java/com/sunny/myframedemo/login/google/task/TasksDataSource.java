package com.sunny.myframedemo.login.google.task;

import android.support.annotation.NonNull;



import java.util.List;

/**
 * Created by Sunny on 18-12-24.
 */

public interface TasksDataSource {

    interface LoadTasksCallback{

        void onTasksLoaded(List<Task> tasks);

        void onDataNotAvailable();
    }

    interface GetTaskCallback{

        void onTaskLoaded(Task task);

        void onDataNotAvailable();

    }

    void getTasks(@NonNull LoadTasksCallback  loadTasksCallback);

    void getTask(@NonNull String taskId,@NonNull GetTaskCallback callback);

    void saveTask(@NonNull Task task);

    void completeTask(@NonNull String taskId);

    void completeTask(@NonNull Task task);

    void activateTask(@NonNull Task task);

    void activateTask(@NonNull String taskId);

    void clearCompletedTasks();

    void refreshTasks();

    void deleteAllTasks();

    void deteleTask(@NonNull String  taskId);

}
