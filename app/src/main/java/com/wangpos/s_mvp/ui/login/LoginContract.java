package com.wangpos.s_mvp.ui.login;

import com.wangpos.s_mvp.base.BaseModel;
import com.wangpos.s_mvp.base.BasePresenter;
import com.wangpos.s_mvp.base.BaseView;

/**
 * Created by qiyue on 2017/10/11.
 *
 * 家这几个接口不分开写，方便管理，减少类的生成
 */

public interface LoginContract {
    interface View extends BaseView {
        void loginSuccess();

        void signSuccess();

        void showMsg(String msg);
    }

    abstract class Model extends BaseModel{

        abstract void login(String name, String pass, OnLoginListener onLoginListener);

        abstract void sign(String name, String pass);

        public interface OnLoginListener{
            void onLoginSuccess();

            void onLoginFailed();
        }
    }

    abstract class Presenter extends BasePresenter<View,Model> {
        public abstract void login(String name, String pass);

        public abstract void sign(String name, String pass);

        @Override
        public void onAttached() {
        }
    }
}