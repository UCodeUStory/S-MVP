package com.wangpos.s_mvp.ui.login;

/**
 * Created by qiyue on 2017/10/11.
 */

public class LoginModel extends LoginContract.Model {


    @Override
    public void login(String name, String pass, OnLoginListener onLoginListener) {


        /**
         * 模拟网络请求
         */
        Thread t = new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        //UI线程
                        onLoginListener.onLoginSuccess();
                    }
                });
            }
        };
        t.start();

    }

    @Override
    public void sign(String name, String pass) {

    }
}
