package com.mine.data.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;


import com.mine.data.entity.TodoList;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * Copyright(c) 2017. LiBing Inc. All rights reserved.
 * <p>
 * Created by Alan on 17/10/7.
 */

@Dao
public interface TodoDao {

    @Query("SELECT * FROM todo_list WHERE id = :todoId")
    LiveData<TodoList> findById(String todoId);

    @Query("SELECT * FROM todo_list WHERE date = :date")
    LiveData<TodoList> findByDate(String date);

    @Query("SELECT * FROM todo_list")
    LiveData<List<TodoList>> getAll();

    @Insert(onConflict = REPLACE)
    void insert(TodoList todo);

}
