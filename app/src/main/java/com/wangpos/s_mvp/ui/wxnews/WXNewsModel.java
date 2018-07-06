package com.wangpos.s_mvp.ui.wxnews;

import com.wangpos.s_mvp.base.http.ApiCallback;
import com.wangpos.s_mvp.base.http.ServiceFactory;
import com.wangpos.s_mvp.bean.WXNewsResult;
import com.wangpos.s_mvp.ui.retrofit.WeatherApiService;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by qiyue on 2018/7/5.
 */

public class WXNewsModel extends WXNewsContract.Model {

    WXNewsApiService wxNewsApiService;

    private CompositeDisposable mCompositeDisposable;

    public WXNewsModel(){
        this.wxNewsApiService = ServiceFactory.getInstance().createService(WXNewsApiService.class, WXNewsApiService.WX_NEWS_API);
    }

    @Override
    Call findWXNews(int page, int pageSize, OnFindListener onFindListener) {

        Call<WXNewsResult> call =  wxNewsApiService.findWXNews(page,pageSize,"json",WXNewsApiService.KEY);


        call.enqueue(new Callback<WXNewsResult>() {
            @Override
            public void onResponse(Call<WXNewsResult> call, Response<WXNewsResult> response) {
                onFindListener.onFindWXNewsSuccess(response.body());
            }

            @Override
            public void onFailure(Call<WXNewsResult> call, Throwable t) {
                onFindListener.onError(t);
            }
        });


        return call;
        // return call
    }

    @Override
    public void findWXNewsByRXJava(int page, int pageSize, ApiCallback<WXNewsResult> callback){
        addSubscription(wxNewsApiService.findWXNewsRxJava(page,pageSize,"json",WXNewsApiService.KEY),callback);

    }




}
