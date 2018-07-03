package com.wangpos.s_mvp.ui.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.wangpos.s_mvp.R;
import com.wangpos.s_mvp.base.BaseActivity;
import com.wangpos.s_mvp.ui.welcome.BodyView;
import com.wangpos.s_mvp.ui.welcome.HeaderView;
import com.wangpos.s_mvp.ui.welcome.MenuView;

public class RetrofitSampleActivity extends BaseActivity {

    @Override
    public int getLayoutId() {
        return R.layout.activity_retrofit_sample;
    }

    @Override
    public void initView() {

        WeatherView weatherView = (WeatherView)$(R.id.weather_view);
        getLifecycle().addObserver(weatherView);
    }
}
