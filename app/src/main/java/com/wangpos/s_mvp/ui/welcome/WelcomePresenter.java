package com.wangpos.s_mvp.ui.welcome;

/**
 * Created by qiyue on 2018/2/28.
 */

public class WelcomePresenter extends WelcomeContract.Presenter{

    public WelcomePresenter(){
        this.mModel = new WelcomeModel();
    }

    @Override
    void loadHeader() {
        mModel.findHeader(new WelcomeContract.Model.OnLoadHeaderListener() {
            @Override
            public void onLoadSuccess(int id) {
                mView.onLoadSuccess(id);
            }
        });
    }

    @Override
    void loadMenu() {
        mModel.findMenu(new WelcomeContract.Model.OnLoadMenuListener() {
            @Override
            public void onLoadMenuSuccess(int id) {
                mView.onLoadMenuSuccess(id);
            }
        });
    }
}
