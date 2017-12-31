package com.mine.view.tabbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.mine.R;

/**
 * Copyright(c) 2017. LiBing Inc. All rights reserved.
 * <p>
 *     1. 根据配置初始化当前的TAB
 *     2. 可扩展为后台配置TAB
 * </p>
 * Created by Alan on 17/12/31.
 */

public class MenuTabBar extends LinearLayout implements TabBar {

    private static final String TAG = "MenuTabBar";

    /**
     * Menu tab size
     */
    private static final int DEFAULT_TAB_COUNT = 5;

    /**
     * Default selected tab index
     */
    private static final int DEFAULT_SELECT_TAB_INDEX = 2;

    private int mTabCount = DEFAULT_TAB_COUNT;

    private int mSelectedTabIndex = DEFAULT_SELECT_TAB_INDEX;

    private CharSequence[] mMenuTabNames = getResources().getStringArray(R.array.menu_tab_names);

    public MenuTabBar(Context context) {
        this(context, null);
    }

    public MenuTabBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public MenuTabBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initTabBar(context, attrs);
    }


    @Override
    public void initTabBar(Context context, AttributeSet attrs) {
        if (attrs == null) {
            throw new RuntimeException("Can not init tab bar without attrs!");
        }
        TypedArray typedArray = null;
        try {
            typedArray = context.obtainStyledAttributes(attrs, R.styleable.TabBar, 0, 0);
            if (typedArray.hasValue(R.styleable.TabBar_tab_count)) {
                mTabCount = typedArray.getInt(R.styleable.TabBar_tab_count, DEFAULT_TAB_COUNT);
            }
            if (typedArray.hasValue(R.styleable.TabBar_default_selected_index)) {
                mSelectedTabIndex = typedArray.getInt(R.styleable.TabBar_default_selected_index, DEFAULT_SELECT_TAB_INDEX);
            }
            if (typedArray.hasValue(R.styleable.TabBar_android_entries)) {
                mMenuTabNames = typedArray.getTextArray(R.styleable.TabBar_android_entries);
            }
        } finally {
            if (typedArray != null) {
                typedArray.recycle();
            }
        }


    }

    @Override
    public void onTabClick(int clickedTabIndex) {

    }
}
