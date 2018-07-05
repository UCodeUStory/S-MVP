package com.wangpos.s_mvp.ui;

import android.support.annotation.DrawableRes;

import com.wangpos.s_mvp.base.BaseModel;
import com.wangpos.s_mvp.base.BasePresenter;
import com.wangpos.s_mvp.base.BaseView;
import com.wangpos.s_mvp.ui.welcome.WelcomeContract;

/**
 * Created by qiyue on 2018/7/5.
 */

public interface SampleContract {


    interface View extends BaseView {

    }

    abstract class Model extends BaseModel {

    }

    abstract class Presenter extends BasePresenter<View,Model> {

    }



}
