package com.mine.framework.data;

import android.arch.persistence.room.Room;
import android.util.Log;

import com.mine.constants.LogConstants;
import com.mine.framework.MINEApplication;

/**
 * Copyright(c) 2017. LiBing Inc. All rights reserved.
 * <p>
 *     负责数据初始化工作。
 *     使用静态单例，全局使用一个数据库对象
 *
 *
 *
 *
 * Created by Alan on 17/11/23.
 */

public class DatabaseHelper {

    /**
     *
     */
    private static DatabaseHelper sInstance;

    /**
     *
     */
    private AppDatabase mDatabase;

    /**
     *
     */
    private static final Object LOCK = new Object();

    /**
     *
     * @return {@link DatabaseHelper}
     */
    public static synchronized DatabaseHelper getInstance() {
        if (sInstance == null) {
            synchronized (LOCK) {
                if (sInstance == null) {
                    sInstance = new DatabaseHelper();
                    Log.d(LogConstants.LOG_DATABASE, "DatabaseHelper create instance.");
                }
            }
        }
        return sInstance;
    }

    /**
     * must create database in thread
     */
    public void initDatabase() {
        Log.d(LogConstants.LOG_DATABASE, "initDatabase() called");

        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        mDatabase = Room.databaseBuilder(
                                MINEApplication.getInstance().getMIMEAppContext(),
                                AppDatabase.class,
                                AppDatabase.DATABASE_NAME)
                                .build();
//                        DatabaseInitUtil.initializeDb(mDatabase);
                    }
                }
        ).start();

    }


}
