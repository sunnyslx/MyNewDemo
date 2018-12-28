package com.sunny.myframedemo.login.google;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.sunny.myframedemo.login.google.task.Task;
import com.sunny.myframedemo.login.google.task.TasksDao;

/**
 * Created by Sunny on 18-12-24.
 */

@Database(entities = {Task.class}, version = 1)
public abstract class ToDoDatabase extends RoomDatabase{

    public static ToDoDatabase INSTANCE;

    public abstract TasksDao taskDao();

    private static final Object sLock = new Object();

    public static ToDoDatabase getInstance(Context context) {
        synchronized (sLock) {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        ToDoDatabase.class, "Tasks.db")
                        .build();
            }
            return INSTANCE;
        }
    }

}
