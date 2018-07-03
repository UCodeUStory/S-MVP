package com.wangpos.s_mvp.ui.retrofit;

import android.util.Log;

import com.wangpos.s_mvp.bean.JHWeatherResult;
import com.wangpos.s_mvp.bean.WeatherResult;

/**
 * Created by qiyue on 2018/7/3.
 *
 * Presenter 和Model中都可以添加泛型型来时实现WeatherModel创建
 * 但是就增加了耦合度
 */

public class WeatherPresenter extends WeatherContract.Presenter {


    public WeatherPresenter(){
        mModel = new WeatherModel();
    }

    /**
     * 免费简单接口
     * @param city
     */
    @Override
    void getWeatherByCity(String city) {

        Log.i("info","city="+city);

        mModel.getWeatherByCity(city, new WeatherContract.Model.OnSearchListener() {
            @Override
            public void onSearchSuccess(WeatherResult result) {
                mView.OnSearchWeatherResult(result);
            }
        });

    }

    /**
     * 聚合收费接口
     * @param cityName
     */
    @Override
    void getWeatherByCityName(String cityName) {
        Log.i("info","city="+cityName);
        mModel.getWeatherByCityName(cityName, new WeatherContract.Model.OnSearchWeatherListener() {
            @Override
            public void onSearchWeatherSuccess(JHWeatherResult result) {
                mView.onSearchWeatherSuccess(result);
            }
        });
    }
}
