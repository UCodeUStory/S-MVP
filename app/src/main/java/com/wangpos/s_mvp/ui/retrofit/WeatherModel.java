package com.wangpos.s_mvp.ui.retrofit;

import android.util.Log;

import com.wangpos.s_mvp.base.http.ServiceFactory;
import com.wangpos.s_mvp.base.http.StringUtil;
import com.wangpos.s_mvp.bean.JHWeatherResult;
import com.wangpos.s_mvp.bean.WeatherResult;

import java.io.InputStream;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by qiyue on 2018/7/3.
 */

public class WeatherModel extends WeatherContract.Model {

    WeatherApiService weatherApiService;
    public WeatherModel(){
        this.weatherApiService = ServiceFactory.getInstance().createService(WeatherApiService.class, WeatherApiService.JH_API_SERVER_URL);
    }
    @Override
    void getWeatherByCity(String city,OnSearchListener onSearchListener) {
        Log.i("info","getWeatherByCity city="+city);
        Call<WeatherResult> call = weatherApiService.loadDataByRetrofit(city);

        call.enqueue(new Callback<WeatherResult>() {
            @Override
            public void onResponse(Call<WeatherResult> call, Response<WeatherResult> response) {
                WeatherResult result =  response.body();
                Log.i("info","getWeatherByCity result="+result.toString());
                onSearchListener.onSearchSuccess(result);
            }

            @Override
            public void onFailure(Call<WeatherResult> call, Throwable t) {
                Log.i("info","getWeatherByCity t="+t.getMessage());
            }
        });
    }

    @Override
    void getWeatherByCityName(String cityName, OnSearchWeatherListener onSearchWeatherListener) {
        Call<JHWeatherResult>call = weatherApiService.loadJHWeather(cityName,"json",1,WeatherApiService.KEY);
        call.enqueue(new Callback<JHWeatherResult>() {
            @Override
            public void onResponse(Call<JHWeatherResult> call, Response<JHWeatherResult> response) {
                onSearchWeatherListener.onSearchWeatherSuccess(response.body());
            }

            @Override
            public void onFailure(Call<JHWeatherResult> call, Throwable t) {
                Log.i("info","getWeatherByCity t="+t.getMessage());

            }
        });
    }
}
