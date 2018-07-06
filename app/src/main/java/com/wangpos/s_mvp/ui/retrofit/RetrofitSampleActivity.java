package com.wangpos.s_mvp.ui.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.bindview.$;
import com.wangpos.s_mvp.R;
import com.wangpos.s_mvp.base.BaseActivity;
import com.wangpos.s_mvp.ui.welcome.BodyView;
import com.wangpos.s_mvp.ui.welcome.HeaderView;
import com.wangpos.s_mvp.ui.welcome.MenuView;

public class RetrofitSampleActivity extends BaseActivity {

    @$(R.id.weather_view)
    public  WeatherView weatherView;
    @Override
    public int getLayoutId() {
        return R.layout.activity_retrofit_sample;
    }

    @Override
    public void initView() {
        getLifecycle().addObserver(weatherView);
    }
}
