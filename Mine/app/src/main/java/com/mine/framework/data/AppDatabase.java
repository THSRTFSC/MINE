package com.mine.framework.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import com.mine.data.converter.DateConverter;
import com.mine.data.dao.TodoDao;
import com.mine.data.dao.UserDao;
import com.mine.data.entity.Todo;
import com.mine.data.entity.User;

/**
 * Copyright(c) 2017. LiBing Inc. All rights reserved.
 * <p>
 * Created by Alan on 17/9/14.
 */

@Database(entities = {User.class, Todo.class}, version = 1, exportSchema = false)
@TypeConverters({DateConverter.class})
public abstract class AppDatabase extends RoomDatabase {

    public static final String DATABASE_NAME = "mine_db";

    public abstract UserDao getUserDao();

    public abstract TodoDao getTodoDao();
}
