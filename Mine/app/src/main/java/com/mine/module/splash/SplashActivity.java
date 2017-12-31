package com.mine.module.splash;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Window;

import com.mine.R;
import com.mine.framework.base.BaseActivity;
import com.mine.utils.ActivityUtils;
import com.mine.utils.TestUtils;

/**
 * Copyright(c) 2017. LiBing Inc. All rights reserved.
 * <p>
 * Created by Alan on 17/8/9.
 */

public class SplashActivity extends BaseActivity {

    private static final String TAG = "SplashActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setFragment() {
        Log.d(TAG, "setFragment: add fragment");
        SplashFragment splashFragment = (SplashFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);
        if (splashFragment == null) {
            splashFragment = SplashFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), splashFragment, R.id.fragment);
        }
        new SplashPresenter(splashFragment);
        TestUtils.getInstance().setActivity(this);
    }
}
