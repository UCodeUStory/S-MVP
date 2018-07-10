package com.wangpos.s_mvp.ui.meizi;

import com.wangpos.s_mvp.base.BaseModel;
import com.wangpos.s_mvp.base.BasePresenter;
import com.wangpos.s_mvp.base.BaseView;
import com.wangpos.s_mvp.base.http.ApiCallback;
import com.wangpos.s_mvp.bean.MeiziResult;
import com.wangpos.s_mvp.bean.WXNewsResult;

/**
 * Created by qiyue on 2018/7/5.
 */

public interface MeiziContract {


    interface View extends BaseView {

        int getPage();

        String getType();

        void onFindPictureSuccess(MeiziResult meiziResult);

        void OnError(String msg);

    }

    abstract class Model extends BaseModel {

        abstract void findPicture(int page,String type, ApiCallback<MeiziResult> callback);

        public interface OnFindListener{
            void onError(Throwable t);

            void onFindSuccess(WXNewsResult wxNewsResult);
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

        public abstract void findPicture();

        public abstract void findMeiziPicture();

    }

}
