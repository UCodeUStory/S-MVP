package com.wangpos.s_mvp.ui;

import android.support.annotation.DrawableRes;

import com.wangpos.s_mvp.base.BaseModel;
import com.wangpos.s_mvp.base.BasePresenter;
import com.wangpos.s_mvp.base.BaseView;
import com.wangpos.s_mvp.ui.welcome.WelcomeContract;

/**
 * Created by qiyue on 2017/7/5.
 * 统一化定义模块接口协议
 * 1. 可以减少类的创建
 * 2. 一目了然各层的协议类型
 * 3. 即使一个复杂的模块这个类也不会太庞大，还是会很清晰
 */

public interface SampleContract {


    interface View extends BaseView {

    }

    abstract class Model extends BaseModel {

    }

    abstract class Presenter extends BasePresenter<View,Model> {

    }


}
