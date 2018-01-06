package com.mine.framework.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.mine.R;
import com.mine.view.tabbar.MenuTabBar;

/**
 * Copyright(c) 2017. LiBing Inc. All rights reserved.
 * <p>
 * Created by Alan on 17/8/9.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_container);
        setFragment();
    }

    public void showTabBar() {
        MenuTabBar tabBar = this.findViewById(R.id.menu_tab_bar);
        if (tabBar != null) {
            tabBar.show();
        }
    }

    public void hideTabBar() {
        MenuTabBar tabBar = this.findViewById(R.id.menu_tab_bar);
        if (tabBar != null) {
            tabBar.hide();
        }
    }

    public abstract void setFragment();
}
