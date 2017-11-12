package com.mine.module.todo;

import android.arch.lifecycle.LiveData;

import com.mine.db.dao.TodoDao;
import com.mine.db.entity.Todo;

/**
 * Copyright(c) 2017. LiBing Inc. All rights reserved.
 * <p>
 * Created by Alan on 17/10/7.
 */

public class TodoRepository {

    private final TodoDao mTodoDao;

    public TodoRepository(TodoDao todoDao) {
        mTodoDao = todoDao;
    }

    public LiveData<Todo> getTodo(String todoId) {
        return mTodoDao.findById(todoId);
    }
}
