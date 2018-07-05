package com.wangpos.s_mvp.ui;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.wangpos.s_mvp.bean.WXNewsResult;
import com.wangpos.s_mvp.ui.wxnews.WXNewsContract;
import com.wangpos.s_mvp.ui.wxnews.WXNewsPresenter;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * Created by qiyue on 2018/7/5.
 */
@RunWith(AndroidJUnit4.class)
public class WXNewsTest {

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.wangpos.s_mvp", appContext.getPackageName());
    }


    @Test
    public void findWXNews(){
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
                  System.out.println("findSize="+wxNewsResult.getResult().getList().size());
            }

            @Override
            public void OnError(String msg) {
                System.out.println("errors="+msg);
            }
        });
        presenter.onFindWXNews();
        System.out.println("start test");
    }
}
