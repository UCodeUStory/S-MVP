package com.wangpos.s_mvp.ui.wxnews;

import android.support.annotation.DrawableRes;

import com.wangpos.s_mvp.base.BaseModel;
import com.wangpos.s_mvp.base.BasePresenter;
import com.wangpos.s_mvp.base.BaseView;
import com.wangpos.s_mvp.base.http.ApiCallback;
import com.wangpos.s_mvp.bean.WXNewsResult;
import com.wangpos.s_mvp.ui.SampleContract;
import com.wangpos.s_mvp.ui.welcome.WelcomeContract;

import retrofit2.Call;

/**
 * Created by qiyue on 2018/7/5.
 */

public interface WXNewsContract {


    interface View extends BaseView {

        int getPage();

        int getPageSize();

        void OnFindNewsResults(WXNewsResult wxNewsResult);

        void OnError(String msg);

    }

    abstract class Model extends BaseModel {

       abstract Call findWXNews(int page, int pageSize, OnFindListener onFindListener);

       abstract void findWXNewsByRXJava(int page, int pageSize, ApiCallback<WXNewsResult> callback);

       public interface OnFindListener{
           void onError(Throwable t);

           void onFindWXNewsSuccess(WXNewsResult wxNewsResult);
       }
    }

    abstract class Presenter extends BasePresenter<View,Model> {

        @Override
        public void onAttached() {

        }

        @Override
        public void onDetached() {
            //先取消注册
            mModel.onUnSubscribe();
            super.onDetached();
        }

        public abstract void onFindWXNews();

        public abstract void findWXNewsByRXJava();

    }
}
