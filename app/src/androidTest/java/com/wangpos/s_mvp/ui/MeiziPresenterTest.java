package com.wangpos.s_mvp.ui;

import android.util.Log;

import com.wangpos.s_mvp.bean.MeiziResult;
import com.wangpos.s_mvp.ui.meizi.MeiziContract;
import com.wangpos.s_mvp.ui.meizi.MeiziPresenter;

import org.junit.Test;

/**
 * Created by qiyue on 2018/7/10.
 */

public class MeiziPresenterTest {


    @Test
    public void testFindMeizi(){
        MeiziPresenter meiziPresenter = new MeiziPresenter();

        meiziPresenter.onAttachedView(new MeiziContract.View() {
            @Override
            public int getPage() {
                return 1;
            }

            @Override
            public String getType() {
                return "4009";
            }


            @Override
            public void onFindPictureSuccess(MeiziResult meiziResult) {

                Log.i("info","info="+meiziResult);
            }

            @Override
            public void OnError(String msg) {

                Log.i("info","msg="+msg);
            }
        });

        meiziPresenter.findPicture();
    }
}
