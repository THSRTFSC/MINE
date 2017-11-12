package com.mine.module.mine;

import android.util.Log;

import com.mine.R;
import com.mine.framework.base.BaseActivity;
import com.mine.module.todo.TodoFragment;
import com.mine.module.todo.TodoPresenter;
import com.mine.utils.ActivityUtils;

/**
 * Copyright(c) 2017. LiBing Inc. All rights reserved.
 * <p>
 * Created by Alan on 17/8/13.
 */

public class MINEActivity extends BaseActivity {

    private String TAG = "MINEActivity";

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
    }
}
