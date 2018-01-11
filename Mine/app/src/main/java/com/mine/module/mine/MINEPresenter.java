package com.mine.module.mine;

import com.mine.framework.log.Logger;
import com.mine.view.tabbar.MenuTabBar;
import com.mine.view.tabbar.TabBar;

/**
 * Copyright(c) 2017. LiBing Inc. All rights reserved.
 * <p>
 * Created by Alan on 17/8/27.
 */

public class MINEPresenter implements MINEContract.Presenter {

    private MINEContract.View mView;

    MINEPresenter(MINEContract.View view) {
        this.mView = view;
    }

    @Override
    public void start() {
        TabBar tabBar = mView.getTabBar();
        if (tabBar instanceof MenuTabBar) {
            ((MenuTabBar) tabBar).addTabClickListener(this);
        }
    }

    @Override
    public void onTabClicked(int clickedTabIndex, int lastSelectedTabIndex) {
        Logger.d(TAG, "change fragment");
    }
}
