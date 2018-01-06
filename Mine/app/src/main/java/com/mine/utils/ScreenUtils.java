package com.mine.utils;

import android.graphics.Point;
import android.util.DisplayMetrics;

import com.mine.framework.MINEApplication;

/**
 * Copyright(c) 2017. LiBing Inc. All rights reserved.
 * <p>
 * Created by Alan on 18/1/6.
 */

public final class ScreenUtils {

    private ScreenUtils() {}

    /**
     * 获取屏幕的宽高。
     *
     * @return {@link Point}
     */
    public static Point getScreenSize() {
        Point          screenSize = new Point();
        DisplayMetrics displayMetrics = MINEApplication.getInstance().getResources().getDisplayMetrics();
        screenSize.set(displayMetrics.widthPixels, displayMetrics.heightPixels);
        return screenSize;
    }

}
