package com.wangpos.s_mvp.ui.retrofit;

import android.support.annotation.DrawableRes;

import com.wangpos.s_mvp.base.BaseModel;
import com.wangpos.s_mvp.base.BasePresenter;
import com.wangpos.s_mvp.base.BaseView;
import com.wangpos.s_mvp.bean.JHWeatherResult;
import com.wangpos.s_mvp.bean.WeatherResult;
import com.wangpos.s_mvp.ui.welcome.WelcomeContract;

/**
 * Created by qiyue on 2018/7/3.
 */

public interface WeatherContract {

    interface View extends BaseView {

        void OnSearchWeatherResult(WeatherResult result);

        void onSearchWeatherSuccess(JHWeatherResult result);
    }

    abstract class Model extends BaseModel {

        abstract void getWeatherByCity(String city,OnSearchListener onSearchListener);

        abstract void getWeatherByCityName(String cityName,OnSearchWeatherListener onSearchWeatherListener);

        public interface OnSearchListener{
            void onSearchSuccess(WeatherResult result);
        }

        public interface OnSearchWeatherListener{
            void onSearchWeatherSuccess(JHWeatherResult result);
        }
    }

    abstract class Presenter extends BasePresenter<View,Model> {

        abstract void getWeatherByCity(String cityid);


        abstract void getWeatherByCityName(String cityName);
        @Override
        public void onAttached() {
        }
    }
}
