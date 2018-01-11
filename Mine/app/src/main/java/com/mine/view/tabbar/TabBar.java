package com.mine.view.tabbar;

import android.content.Context;
import android.util.AttributeSet;

/**
 * Copyright(c) 2017. LiBing Inc. All rights reserved.
 * <p>
 * Created by Alan on 17/12/31.
 */

public interface TabBar {

    String TAG = TabBar.class.getSimpleName();

    int TAB_ORIENTATION_VERTICAL = 0;

    int TAB_ORIENTATION_HORIZONTAL = 1;

    void initTabBar(Context context, AttributeSet attrs);

    void createTabView(CharSequence[] tabNames, int orientation);

    void show();

    void hide();

    boolean isShowing();
}
