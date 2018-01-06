package com.mine.view.tabbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mine.R;
import com.mine.framework.log.Logger;
import com.mine.utils.ScreenUtils;

/**
 * Copyright(c) 2017. LiBing Inc. All rights reserved.
 * <p>
 *     1. 根据配置初始化当前的TAB
 *     2. 可扩展为后台配置TAB
 * </p>
 * Created by Alan on 17/12/31.
 */

public class MenuTabBar extends LinearLayout implements TabBar, View.OnClickListener {

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

    private int mLastSelectecTabIndex = DEFAULT_SELECT_TAB_INDEX;

    private int mSelectedTabIndex = DEFAULT_SELECT_TAB_INDEX;

    private int mTabOrientation = TAB_ORIENTATION_HORIZONTAL;

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
    protected void onFinishInflate() {
        super.onFinishInflate();
        createTabView(mMenuTabNames, mTabOrientation);
    }

    @Override
    public void initTabBar(Context context, AttributeSet attrs) {
        if (attrs == null) {
            throw new NullPointerException("Can not init tab bar without attrs!");
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
            if (typedArray.hasValue(R.styleable.TabBar_tab_orientation)) {
                mTabOrientation = typedArray.getInt(R.styleable.TabBar_tab_orientation, TAB_ORIENTATION_HORIZONTAL);
            }
        } finally {
            if (typedArray != null) {
                typedArray.recycle();
            }
        }
        Logger.i(TAG, "TabCount", String.valueOf(mTabCount), "Orientation", String.valueOf(mTabOrientation));
    }

    @Override
    public void createTabView(CharSequence[] tabNames, int orientation) {
        Log.d(TAG, "createTabView() called with: tabNames = [" + tabNames + "], orientation = [" + orientation + "]");
        Point screenSize = ScreenUtils.getScreenSize();
        int tabWidth = screenSize.x / mTabCount;
        int textSize = getResources().getDimensionPixelSize(R.dimen.text_size_normal);
        TextView tabItem;
        LinearLayout.LayoutParams tabItemParams = new LayoutParams(tabWidth, LayoutParams.MATCH_PARENT);
        tabItemParams.gravity = Gravity.CENTER_VERTICAL;
        int index = 0;
        for (CharSequence tabName : tabNames) {
            tabItem = new TextView(getContext());
            tabItem.setTag(index);
            tabItem.setText(tabName);
            tabItem.setTextColor(getResources().getColor(R.color.colorBlack));
            tabItem.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
            tabItem.setGravity(Gravity.CENTER);
            tabItem.setOnClickListener(this);
            this.addView(tabItem, tabItemParams);
            index++;
        }
    }

    @Override
    public void show() {
        this.setVisibility(View.VISIBLE);
    }

    @Override
    public void hide() {
        this.setVisibility(View.GONE);
    }

    @Override
    public void onTabClicked(int clickedTabIndex, int lastSelectedTabIndex) {
        Logger.d(TAG, "onTabClicked() called with: clickedTabIndex = [" + clickedTabIndex + "], lastSelectedTabIndex = [" + lastSelectedTabIndex + "]");
    }

    @Override
    public void onClick(View v) {
        mLastSelectecTabIndex = mSelectedTabIndex;
        mSelectedTabIndex = (int) v.getTag();
    }
}
