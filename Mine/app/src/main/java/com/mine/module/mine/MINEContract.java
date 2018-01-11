package com.mine.module.mine;

import com.mine.framework.base.BasePresenter;
import com.mine.framework.base.BaseView;
import com.mine.view.tabbar.OnTabClickListener;
import com.mine.view.tabbar.TabBar;

/**
 * Copyright(c) 2017. LiBing Inc. All rights reserved.
 * <p>
 * Created by Alan on 17/8/27.
 */

public interface MINEContract {

    interface View extends BaseView<Presenter> {

        TabBar getTabBar();

    }

    interface Presenter extends BasePresenter, OnTabClickListener {
        String TAG = "MINEPresenter";
    }
}
