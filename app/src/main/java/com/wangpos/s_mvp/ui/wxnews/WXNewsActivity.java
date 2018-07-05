package com.wangpos.s_mvp.ui.wxnews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.wangpos.s_mvp.R;
import com.wangpos.s_mvp.base.BaseActivity;


/**
 * 一个模块开发本步骤其实可以很多，因为个模块都是相互解耦的，所以其实不管怎么都应该先确定数据bean
 *
 * 比如 第一种
 * 1.确定数据bean
 * 2.先写ApiService
 * 3.写Contract
 * 4.写Model
 * 5.写Presenter
 * 6.写View
 * 7.View关联Presenter
 *
 * 比如 第二种
 *
 * 1.确定数据bean
 * 2.写Contract
 * 3.写View
 * 4.View关联Presenter
 * 5.写presenter
 * 6.写model
 * 7.写ApiService
 *
 *
 */
public class WXNewsActivity extends BaseActivity {


    @Override
    public int getLayoutId() {
        return R.layout.activity_wxnews;
    }

    @Override
    public void initView() {

    }
}
