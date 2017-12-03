package com.mine.data.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import com.mine.framework.data.BaseEntity;

import java.util.List;

/**
 * Copyright(c) 2017. LiBing Inc. All rights reserved.
 * <p>
 * Created by Alan on 17/10/7.
 */

@Entity(tableName = "todo_list", indices = {@Index(value = "date", unique = true)})
public class TodoList extends BaseEntity {

    @PrimaryKey
    @ColumnInfo(name = "id")
    private long mId;

    @ColumnInfo(name = "date")
    private String mDate;

    @ColumnInfo(name = "state")
    private int mState;

    @Ignore
    private List<Todo> mTodoItems;

    public long getId() {
        return mId;
    }

    public void setId(long id) {
        mId = id;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        mDate = date;
    }

    public int getState() {
        return mState;
    }

    public void setState(int state) {
        mState = state;
    }

    public List<Todo> getTodoItems() {
        return mTodoItems;
    }

    public void setTodoItems(List<Todo> todoItems) {
        mTodoItems = todoItems;
    }
}
