package com.mine.utils;

import android.app.Activity;

import com.mine.data.entity.TodoList;
import com.mine.data.entity.Todo;

import java.util.ArrayList;
import java.util.Date;

/**
 * Copyright(c) 2017. LiBing Inc. All rights reserved.
 * <p>
 * Created by Alan on 17/10/8.
 */

public class TestUtils {

    private static TestUtils sInstance = null;

    public static TestUtils getInstance() {
        if (sInstance == null) {
            sInstance = new TestUtils();
        }
        return sInstance;
    }

    private Activity mActivity;

    public void setActivity(Activity activity) {
        mActivity = activity;
    }

    private TestUtils() {}



    public static TodoList createTodo() {
        TodoList todo = new TodoList();
        todo.setStatus(0);
//        todo.setContent("Test-Test");
        todo.setCreateTime(new Date());
        todo.setUpdateTime(new Date());
        todo.setTodoItems(new ArrayList<Todo>());
        todo.setDate("20171008");
        return todo;
    }
}
