package com.mine.view.tabbar;

import android.content.Context;
import android.util.AttributeSet;

/**
 * Copyright(c) 2017. LiBing Inc. All rights reserved.
 * <p>
 * Created by Alan on 17/12/31.
 */

public interface TabBar {

    void initTabBar(Context context, AttributeSet attrs);

    void onTabClick(int clickedTabIndex);

}
