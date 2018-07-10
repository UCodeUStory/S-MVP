package com.wangpos.s_mvp.ui.meizi;

import com.wangpos.s_mvp.bean.JHWeatherResult;
import com.wangpos.s_mvp.bean.MeiziResult;
import com.wangpos.s_mvp.bean.WXNewsResult;
import com.wangpos.s_mvp.bean.WeatherResult;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

//import io.reactivex.Observable;


public interface MeiziApiService {

    String API_GET_MEIZI = "http://route.showapi.com/";


    public static final String APP_ID = "69364";

    public static final String scret = "48cc72be079a4438a60a5e6687dc014b";

    @GET("852-2")
    Observable<MeiziResult> searchMeiziPicture(@Query("page") String page, @Query("type")String type,
                                               @Query("showapi_appid")String showapi_appid, @Query("showapi_sign") String showapi_sign);



}
