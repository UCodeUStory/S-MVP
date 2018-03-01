package com.wangpos.s_mvp.ui.welcome;

import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;

import com.wangpos.s_mvp.base.BaseModel;
import com.wangpos.s_mvp.base.BasePresenter;
import com.wangpos.s_mvp.base.BaseView;

/**
 * Created by qiyue on 2018/2/28.
 */


public interface WelcomeContract {
    interface View extends BaseView {
        void onLoadSuccess(@DrawableRes int id);

        void onLoadMenuSuccess(@DrawableRes int id);
    }

    abstract class Model extends BaseModel {

        abstract void findHeader(OnLoadHeaderListener onLoadHeaderListener);

        abstract void findMenu(OnLoadMenuListener onLoadMenuListener);

        public interface OnLoadHeaderListener{
            void onLoadSuccess(@DrawableRes int id);
        }

        public interface OnLoadMenuListener{
            void onLoadMenuSuccess(@DrawableRes int id);
        }
    }

    abstract class Presenter extends BasePresenter<View,Model> {

        abstract void loadHeader();

        abstract void loadMenu();

        @Override
        public void onAttached() {
        }
    }
}