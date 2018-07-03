package com.wangpos.s_mvp.ui.retrofit;

import com.wangpos.s_mvp.bean.JHWeatherResult;
import com.wangpos.s_mvp.bean.WeatherResult;

//import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface WeatherApiService {
    //免费天气接口
    String API_SERVER_URL = "http://www.weather.com.cn/";

    //聚合天气接口
    String JH_API_SERVER_URL = "http://v.juhe.cn/weather/";

    String KEY = "817a46fd35061aee9512d7826dc19080";

    //加载天气
    @GET("adat/sk/{cityId}.html")
    Call<WeatherResult> loadDataByRetrofit(@Path("cityId") String cityId);

    @GET("index")
    Call<JHWeatherResult> loadJHWeather(@Query("cityname") String cityname, @Query("dtype")String dtype, @Query("format")int format, @Query("key")String key);
//
//    //加载天气
//    @GET("adat/sk/{cityId}.html")
//    Observable<WeatherResult> loadDataByRetrofitRxJava(@Path("cityId") String cityId);
}
