package com.wangpos.s_mvp.ui.wxnews;

import android.util.Log;

import com.wangpos.s_mvp.base.http.ApiCallback;
import com.wangpos.s_mvp.base.http.ServiceFactory;
import com.wangpos.s_mvp.bean.WXNewsResult;
import com.wangpos.s_mvp.ui.wxnews.WXNewsContract.Presenter;

/**
 * Created by qiyue on 2018/7/5.
 */

public class WXNewsPresenter extends Presenter {

    public static final String TAG = WXNewsPresenter.class.getSimpleName();

    public WXNewsPresenter(){
        mModel = new WXNewsModel();
    }

    @Override
    public void onFindWXNews() {

        mModel.findWXNews(mView.getPage(), mView.getPageSize(), new WXNewsContract.Model.OnFindListener() {
            @Override
            public void onError(Throwable t) {
                Log.i(TAG,"exception="+t.getMessage());
                mView.OnError(t.getMessage());
            }

            @Override
            public void onFindWXNewsSuccess(WXNewsResult wxNewsResult) {
                mView.OnFindNewsResults(wxNewsResult);
            }
        });
    }

    @Override
    public void findWXNewsByRXJava() {
        mModel.findWXNewsByRXJava(mView.getPage(), mView.getPageSize(), new ApiCallback<WXNewsResult>() {
            @Override
            public void onSuccess(WXNewsResult model) {
                mView.OnFindNewsResults(model);
            }

            @Override
            public void onFailure(String msg) {
                mView.OnError(msg);
            }

            @Override
            public void onFinish() {

            }
        });
    }


}
