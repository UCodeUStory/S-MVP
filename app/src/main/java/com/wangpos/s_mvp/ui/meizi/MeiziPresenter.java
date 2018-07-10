package com.wangpos.s_mvp.ui.meizi;

import android.util.Log;

import com.wangpos.s_mvp.base.http.ApiCallback;
import com.wangpos.s_mvp.bean.MeiziResult;

/**
 * Created by qiyue on 2018/7/10.
 */

public class MeiziPresenter extends MeiziContract.Presenter {

    public MeiziPresenter(){
        this.mModel = new MeiziModel();
    }

    @Override
    public void findPicture() {
        mModel.findPicture(mView.getPage(), mView.getType(), new ApiCallback<MeiziResult>() {
            @Override
            public void onSuccess(MeiziResult model) {
                mView.onFindPictureSuccess(model);
            }

            @Override
            public void onFailure(String msg) {
                mView.OnError(msg);
            }

            @Override
            public void onFinish() {

//                Log.i("info","onFinish");




            }
        });

    }

    @Override
    public void findMeiziPicture() {

    }
}
