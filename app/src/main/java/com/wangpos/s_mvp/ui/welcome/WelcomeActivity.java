package com.wangpos.s_mvp.ui.welcome;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.bindview.$;
import com.wangpos.s_mvp.R;
import com.wangpos.s_mvp.base.BaseActivity;
import com.wangpos.s_mvp.base.task.SmartTaskManager;
import com.wangpos.s_mvp.base.widget.LifeLinearLayout;
import com.wangpos.s_mvp.ui.login.LoginActivity;

/**
 * Created by qiyue on 2018/2/28.
 *
 * 设计一个广告头布局
 * 中间菜单RecyclerView
 * 下面ListView一个布局
 *
 * 3块可以是验证同时加载完成，和异步加载完成
 *
 */

public class WelcomeActivity extends BaseActivity {

    @$(R.id.life_linearlayout)
    public HeaderView lifeLinearLayout;

    @$(R.id.menu_layout)
    public MenuView menuView;

    @$(R.id.body_view)
    public BodyView bodyView;
    @Override
    public int getLayoutId() {
        return R.layout.activity_welcome;
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
        smartTaskManager = SmartTaskManager.as();
        smartTaskManager.put("initPage",2);
        Log.i("info",""+smartTaskManager.toString());
    }

    @Override
    public void initView() {
        getLifecycle().addObserver(lifeLinearLayout);
        getLifecycle().addObserver(menuView);
        getLifecycle().addObserver(bodyView);

    }


    @Override
    public void onClick(View view) {
        super.onClick(view);

    }

    @Override
    protected void onDestroy() {
        SmartTaskManager.as().remove("initPage");
        super.onDestroy();

    }


}
