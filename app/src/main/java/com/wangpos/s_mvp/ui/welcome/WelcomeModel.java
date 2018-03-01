package com.wangpos.s_mvp.ui.welcome;

import com.wangpos.s_mvp.R;

/**
 * Created by qiyue on 2018/2/28.
 */

public class WelcomeModel extends WelcomeContract.Model {

    @Override
    void findHeader(OnLoadHeaderListener onLoadHeaderListener) {

        //模拟耗时任务
        //notice 注意这里正常不要引入R资源和Handler
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                onLoadHeaderListener.onLoadSuccess(R.drawable.header);
                }
        },3000);
    }

    @Override
    void findMenu(OnLoadMenuListener onLoadMenuListener) {
        //模拟耗时任务
        //notice 注意这里正常不要引入R资源和Handler
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                onLoadMenuListener.onLoadMenuSuccess(R.drawable.menu);
            }
        },4000);
    }
}
