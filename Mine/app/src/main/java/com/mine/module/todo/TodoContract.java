package com.mine.module.todo;


import com.mine.framework.base.BasePresenter;
import com.mine.framework.base.BaseView;

/**
 * Copyright(c) 2017. LiBing Inc. All rights reserved.
 * <p>
 * Created by Alan on 17/10/7.
 */

public interface TodoContract {

    interface View extends BaseView<Presenter> {

        void initViewModel();

        void refreshUI();

    }

    interface Presenter extends BasePresenter {



    }
}
