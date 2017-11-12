package com.mine.module.user;

import android.util.Log;

import com.mine.R;
import com.mine.framework.base.BaseActivity;
import com.mine.utils.ActivityUtils;

/**
 * Created by augusting1991@163.com on 2017/8/12.
 */

public class UserProfileActivity extends BaseActivity {

    private static final String TAG = "UserProfileActivity";

    @Override
    public void setFragment() {
        Log.d(TAG, "setFragment: add fragment");
        UserProfileFragment userProfileFragment = (UserProfileFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);
        if (userProfileFragment == null) {
            userProfileFragment = UserProfileFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), userProfileFragment, R.id.fragment);
        }
        new UserProfilePresenter(userProfileFragment);
    }
}
