package com.mine.framework.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.mine.framework.app.MiddlewareProxy;

/**
 * 处理网络连接相关业务。
 * <p>
 *     1. 网络是否连接
 *     2. 当前的网络类型
 * </p>
 * Copyright(c) 2017. LiBing Inc. All rights reserved.
 * <p>
 * Created by Alan on 17/12/17.
 */

public class NetworkManager {

    private NetworkManager() {}

    /**
     * 判断当前网络是否处于已连接状态
     *
     * @return boolean
     */
    public static boolean isNetworkConnected() {
        Context context = MiddlewareProxy.getApplicationContext();
        ConnectivityManager connectivityManager =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
        return activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
    }


}
