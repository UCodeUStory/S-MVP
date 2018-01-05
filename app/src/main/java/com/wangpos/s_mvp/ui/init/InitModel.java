package com.wangpos.s_mvp.ui.init;

import com.wangpos.s_mvp.base.task.SmartTaskManager;

/**
 * Created by qiyue on 2017/12/27.
 */

public class InitModel {

    public void init(){

        /**
         * 模拟 异步任务
         */

        Thread t = new Thread(){
            @Override
            public void run() {
                super.run();

                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                SmartTaskManager.as().getAsyncTask("initTask").onFinish();
            }
        };
        t.start();
    }

    public void otherInit() {

        Thread t = new Thread(){
            @Override
            public void run() {
                super.run();

                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                SmartTaskManager.as().getAsyncTask("initTask").onFinish();
            }
        };
        t.start();
    }
}
