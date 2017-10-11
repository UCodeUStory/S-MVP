package com.wangpos.s_mvp.ui.login;

import com.example.InstanceFactory;
import com.wangpos.s_mvp.base.BasePresenter;

/**
 * Created by qiyue on 2017/10/11.
 */

@InstanceFactory
public class LoginPresenter extends LoginContract.Presenter {

    public LoginPresenter(){
        this.mModel = new LoginModel();
    }

    @Override
    public void login(String name, String pass) {
        mModel.login(name, pass, new LoginContract.Model.OnLoginListener() {
            @Override
            public void onLoginSuccess() {
                mView.loginSuccess();
            }

            @Override
            public void onLoginFailed() {
            }
        });

    }

    @Override
    public void sign(String name, String pass) {

    }
}
