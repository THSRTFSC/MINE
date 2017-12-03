package com.mine.data.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.mine.framework.data.BaseEntity;

/**
 * Copyright(c) 2017. LiBing Inc. All rights reserved.
 * <p>
 * Created by Alan on 17/10/7.
 */

@Entity(tableName = "todo")
public class Todo extends BaseEntity {

    @PrimaryKey
    @ColumnInfo(name = "id")
    private long mId;

    @ColumnInfo(name = "todo_list_id")
    private long mTodoListId;

    @ColumnInfo(name = "detail")
    private String mDetail;

    @ColumnInfo(name = "priority")
    private int mPriority;

    public long getId() {
        return mId;
    }

    public void setId(long id) {
        mId = id;
    }

    public long getTodoListId() {
        return mTodoListId;
    }

    public void setTodoListId(long todoListId) {
        mTodoListId = todoListId;
    }

    public String getDetail() {
        return mDetail;
    }

    public void setDetail(String detail) {
        mDetail = detail;
    }

    public int getPriority() {
        return mPriority;
    }

    public void setPriority(int priority) {
        mPriority = priority;
    }
}
