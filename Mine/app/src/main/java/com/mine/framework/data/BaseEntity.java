package com.mine.framework.data;

import android.arch.persistence.room.ColumnInfo;

import java.util.Date;

/**
 * Copyright(c) 2017. LiBing Inc. All rights reserved.
 * <p>
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
