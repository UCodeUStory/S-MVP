package com.wangpos.s_mvp.ui;

import android.util.Log;

import com.wangpos.s_mvp.bean.WXNewsResult;
import com.wangpos.s_mvp.ui.wxnews.WXNewsContract;
import com.wangpos.s_mvp.ui.wxnews.WXNewsPresenter;

import org.junit.Test;

/**
 * Created by qiyue on 2018/7/6.
 */

public class WeiXinNewsTest {


    @Test
    public void testFindNews(){
        Log.i("info","testFindNews");

        WXNewsPresenter presenter = new WXNewsPresenter();
        presenter.onAttachedView(new WXNewsContract.View() {
            @Override
            public int getPage() {
                return 1;
            }

            @Override
            public int getPageSize() {
                return 10;
            }

            @Override
            public void OnFindNewsResults(WXNewsResult wxNewsResult) {

                Log.i("info",""+"findSize="+wxNewsResult.getResult().getList().size());

            }

            @Override
            public void OnError(String msg) {

                Log.i("info","errors="+msg);
            }
        });
        presenter.onFindWXNews();
    }

}
