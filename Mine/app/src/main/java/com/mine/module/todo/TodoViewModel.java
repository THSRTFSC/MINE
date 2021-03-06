package com.mine.module.todo;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.mine.data.entity.TodoList;

/**
 * Copyright(c) 2017. LiBing Inc. All rights reserved.
 * <p>
 * Created by Alan on 17/10/7.
 */

public class TodoViewModel extends AndroidViewModel {

    private LiveData<TodoList> mTodo;

    private TodoRepository mTodoRepository;

    public TodoViewModel(Application application) {
        super(application);
    }

    public LiveData<TodoList> getTodo() {
        return mTodo;
    }

    public void init(String todoDate) {
        if (mTodo != null) {
            return;
        }
//        mTodo = mTodoRepository.getTodo(todoDate);
    }
}
