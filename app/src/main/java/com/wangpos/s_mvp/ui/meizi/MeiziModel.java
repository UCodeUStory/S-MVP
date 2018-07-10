package com.wangpos.s_mvp.ui.meizi;

import com.wangpos.s_mvp.base.http.ApiCallback;
import com.wangpos.s_mvp.base.http.ServiceFactory;
import com.wangpos.s_mvp.bean.MeiziResult;
import com.wangpos.s_mvp.ui.wxnews.WXNewsApiService;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by qiyue on 2018/7/10.
 */

public class MeiziModel extends MeiziContract.Model{


    MeiziApiService meiziApiService;

    private CompositeDisposable mCompositeDisposable;

    public MeiziModel(){
        this.meiziApiService = ServiceFactory.getInstance().createService(MeiziApiService.class, MeiziApiService.API_GET_MEIZI);
    }


    @Override
    void findPicture(int page,String type, ApiCallback<MeiziResult> callback) {

        addSubscription(meiziApiService.searchMeiziPicture(page,type,MeiziApiService.APP_ID,MeiziApiService.scret),callback);

    }
}
