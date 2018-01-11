package com.mine.module.mine;

import android.util.Log;

import com.mine.R;
import com.mine.framework.base.BaseActivity;
import com.mine.module.todo.TodoFragment;
import com.mine.module.todo.TodoPresenter;
import com.mine.utils.ActivityUtils;
import com.mine.view.tabbar.MenuTabBar;
import com.mine.view.tabbar.TabBar;

/**
 * Copyright(c) 2017. LiBing Inc. All rights reserved.
 * <p>
 *     1. 应用主Activity
 *     2. 主要负责控制生命周期
 *     3. 逻辑的实现由MINEPresenter实现
 * </p>
 * Created by Alan on 17/8/13.
 */

public class MINEActivity extends BaseActivity implements MINEContract.View {

    private String TAG = "MINEActivity";

    private MINEContract.Presenter mPresenter;

    @Override
    public void setFragment() {
        Log.d(TAG, "setFragment: add fragment");
//        MINEFragment mimeFragment = (MINEFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);
//        if (mimeFragment == null) {
//            mimeFragment = MINEFragment.newInstance();
//            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), mimeFragment, R.id.fragment);
//        }
//        new MINEPresenter(mimeFragment);
        TodoFragment todoFragment = (TodoFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);
        if (todoFragment == null) {
            todoFragment = TodoFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), todoFragment, R.id.fragment);
        }
        new TodoPresenter(todoFragment);
        showTabBar();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mPresenter == null) {
            mPresenter = new MINEPresenter(this);
            mPresenter.start();
        }
    }

    @Override
    public void setPresenter(MINEContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public TabBar getTabBar() {
        MenuTabBar tabBar = this.findViewById(R.id.menu_tab_bar);
        if (tabBar != null) {
            return tabBar;
        }
        return null;
    }
}
