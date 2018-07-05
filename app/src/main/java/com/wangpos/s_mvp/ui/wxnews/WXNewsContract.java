package com.wangpos.s_mvp.ui.wxnews;

import android.support.annotation.DrawableRes;

import com.wangpos.s_mvp.base.BaseModel;
import com.wangpos.s_mvp.base.BasePresenter;
import com.wangpos.s_mvp.base.BaseView;
import com.wangpos.s_mvp.ui.SampleContract;
import com.wangpos.s_mvp.ui.welcome.WelcomeContract;

/**
 * Created by qiyue on 2018/7/5.
 */

public interface WXNewsContract {


    interface View extends BaseView {

    }

    abstract class Model extends BaseModel {

    }

    abstract class Presenter extends BasePresenter<SampleContract.View,SampleContract.Model> {

    }
}
