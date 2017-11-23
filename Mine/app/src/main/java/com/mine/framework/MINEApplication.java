package com.mine.framework;

import android.app.Application;
import android.content.Context;

import com.mine.framework.data.DatabaseHelper;

/**
 * Copyright(c) 2017. LiBing Inc. All rights reserved.
 * <p>
 * Created by Alan on 17/8/12.
 */

public class MINEApplication extends Application {

    private static MINEApplication sMIMEApplication = null;

    private String mLoginToken = "";

    @Override
    public void onCreate() {
        super.onCreate();
        sMIMEApplication = this;
        DatabaseHelper.getInstance().initDatabase();
    }

    public Context getMIMEAppContext() {
        return getApplicationContext();
    }

    public static MINEApplication getInstance() {
        return sMIMEApplication;
    }

    public String getLoginToken() {
        return mLoginToken;
    }

    public void setLoginToken(String loginToken) {
        mLoginToken = loginToken;
    }

}
