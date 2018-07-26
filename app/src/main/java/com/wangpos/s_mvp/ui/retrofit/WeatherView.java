package com.wangpos.s_mvp.ui.retrofit;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bindview.$;
import com.wangpos.s_mvp.R;
import com.wangpos.s_mvp.base.util.InjectView;
import com.wangpos.s_mvp.base.widget.LifeLinearLayout;
import com.wangpos.s_mvp.base.widget.LifeRelativeLayout;
import com.wangpos.s_mvp.bean.JHWeatherResult;
import com.wangpos.s_mvp.bean.WeatherResult;

/**
 * Created by qiyue on 2018/7/3.
 */

public class WeatherView extends LifeRelativeLayout<WeatherPresenter> implements WeatherContract.View{


    @$(R.id.tv_city)
    public TextView tvCity;

    @$(R.id.tv_temperature)
    public TextView tvTemperature;

    @$(R.id.tv_weather)
    public TextView tvWeather;

    @$(R.id.tv_time)
    public TextView tvTime;
    public WeatherView(Context context) {
        super(context);
    }

    public WeatherView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public WeatherView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public void ON_CREATE() {
        super.ON_CREATE();
        mPresenter.getWeatherByCityName("北京");
    }

    @Override
    public void OnSearchWeatherResult(WeatherResult result) {
        WeatherResult.WeatherinfoBean weatherinfoBean = result.getWeatherinfo();
        tvCity.setText(weatherinfoBean.getCity());
        tvTemperature.setText(weatherinfoBean.getTemp());
        tvTime.setText(weatherinfoBean.getTime());
        Toast.makeText(getContext(),result.getWeatherinfo().toString(),Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onSearchWeatherSuccess(JHWeatherResult result) {
        JHWeatherResult.ResultBean.TodayBean todayBean = result.getResult().getToday();
        tvCity.setText(todayBean.getCity());
        tvTemperature.setText(todayBean.getTemperature());
        tvTime.setText(todayBean.getDate_y());
        tvWeather.setText(todayBean.getWeather());
        Toast.makeText(getContext(),result.getResultcode()+"",Toast.LENGTH_SHORT).show();
    }
}
