package com.mine.framework.data;

import android.arch.persistence.room.ColumnInfo;

import java.util.Date;

/**
 * Copyright(c) 2017. LiBing Inc. All rights reserved.
 * <p>
 *     数据表公共父类，声明公有字段
 *     1. 当前记录的状态，已删除，未删除，默认未删除
 *     2. 当前记录的创建时间
 *     3. 当前记录的最近一次修改时间
 * Created by Alan on 17/10/7.
 */
public class BaseEntity {

    @ColumnInfo(name = "status")
    private int mStatus;

    @ColumnInfo(name = "create_time")
    private Date mCreateTime;

    @ColumnInfo(name = "update_time")
    private Date mUpdateTime;

    public int getStatus() {
        return mStatus;
    }

    public void setStatus(int status) {
        mStatus = status;
    }

    public Date getCreateTime() {
        return mCreateTime;
    }

    public void setCreateTime(Date createTime) {
        mCreateTime = createTime;
    }

    public Date getUpdateTime() {
        return mUpdateTime;
    }

    public void setUpdateTime(Date updateTime) {
        mUpdateTime = updateTime;
    }
}
