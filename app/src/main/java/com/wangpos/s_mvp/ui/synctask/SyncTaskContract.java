package com.wangpos.s_mvp.ui.synctask;

import android.support.annotation.DrawableRes;

import com.wangpos.s_mvp.base.BaseModel;
import com.wangpos.s_mvp.base.BasePresenter;
import com.wangpos.s_mvp.base.BaseView;
import com.wangpos.s_mvp.ui.welcome.WelcomeContract;

/**
 * Created by qiyue on 2018/6/29.
 */

public interface SyncTaskContract {
    interface View extends BaseView {
        void onLoadSuccess(@DrawableRes int id);

    }

    abstract class Model extends BaseModel {


    }

    abstract class Presenter extends BasePresenter<View,Model> {

        @Override
        public void onAttached() {
        }
    }
}
