package com.mine.framework.app;

import android.content.Context;

import com.mine.framework.MINEApplication;

/**
 * Copyright(c) 2017. LiBing Inc. All rights reserved.
 * <p>
 * Created by Alan on 17/12/27.
 */

public class MiddlewareProxy {

    private MiddlewareProxy() {}

    public static Context getApplicationContext() {
        return MINEApplication.getInstance();
    }

}
