package com.wangpos.s_mvp.ui.wxnews;

import com.wangpos.s_mvp.bean.JHWeatherResult;
import com.wangpos.s_mvp.bean.WXNewsResult;
import com.wangpos.s_mvp.bean.WeatherResult;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import io.reactivex.Observable;

/**
 * Created by qiyue on 2018/7/5.
 */

public interface WXNewsApiService {


    String WX_NEWS_API = "http://v.juhe.cn/weixin/";

    String KEY = "046f0fee45e9891105fea01bb248f5e5";

    @GET("query")
    Call<WXNewsResult> findWXNews(@Query("pno") int pno, @Query("ps")int ps, @Query("dtype")String dtype, @Query("key")String key);

    @GET("query")
    Observable<WXNewsResult> findWXNewsRxJava(@Query("pno") int pno, @Query("ps")int ps, @Query("dtype")String dtype, @Query("key")String key);



}
