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

import java.util.HashSet;
import java.util.Set;

/**
 * Copyright(c) 2017. LiBing Inc. All rights reserved.
 * <p>
 *     1. 根据配置初始化当前的TAB
 *     2. 可扩展为后台配置TAB
 *     3. 文字样式TabBarText
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

    private int mLastSelectedTabIndex = DEFAULT_SELECT_TAB_INDEX;

    private int mSelectedTabIndex = DEFAULT_SELECT_TAB_INDEX;

    private int mTabOrientation = TAB_ORIENTATION_HORIZONTAL;

    private CharSequence[] mMenuTabNames = getResources().getStringArray(R.array.menu_tab_names);

    private final Set<OnTabClickListener> mOnTabClickListeners = new HashSet<>();

    private TextView[] mViewHolders;

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
        mViewHolders = new TextView[mTabCount];
        for (CharSequence tabName : tabNames) {
            tabItem = new TextView(getContext());
            tabItem.setTag(index);
            tabItem.setText(tabName);
            tabItem.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
            tabItem.setGravity(Gravity.CENTER);
            tabItem.setOnClickListener(this);
            if (index == mSelectedTabIndex) {
                tabItem.setSelected(true);
                tabItem.setTextColor(getResources().getColor(R.color.colorTheme));
            } else {
                tabItem.setSelected(false);
                tabItem.setTextColor(getResources().getColor(R.color.colorThemeLight));
            }
            this.addView(tabItem, tabItemParams);
            mViewHolders[index] = tabItem;
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
    public boolean isShowing() {
        return this.getVisibility() == View.VISIBLE;
    }

    @Override
    public void onClick(View v) {
        mLastSelectedTabIndex = mSelectedTabIndex;
        mSelectedTabIndex = (int) v.getTag();
        Logger.d(TAG, "Current clicked tab index = " + mSelectedTabIndex);
        if (mViewHolders != null) {
            mViewHolders[mLastSelectedTabIndex].setTextColor(getResources().getColor(R.color.colorThemeLight));
            mViewHolders[mSelectedTabIndex].setTextColor(getResources().getColor(R.color.colorTheme));
        }
        for (OnTabClickListener listener : mOnTabClickListeners) {
            listener.onTabClicked(mSelectedTabIndex, mLastSelectedTabIndex);
        }
    }

    public void addTabClickListener(OnTabClickListener onTabClickListener) {
        this.mOnTabClickListeners.add(onTabClickListener);
    }

    public void removeTabClickListener(OnTabClickListener onTabClickListener) {
        this.mOnTabClickListeners.remove(onTabClickListener);
    }
}
