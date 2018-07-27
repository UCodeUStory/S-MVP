package com.wangpos.s_mvp.base.widget;

import com.wangpos.s_mvp.base.BasePresenter;

/**
 * Created by qiyue on 2018/7/10.
 */

public interface IBase {

    void toast(String msg);

    <P extends BasePresenter> P initPresenter(Object that);

}
