package com.wangpos.s_mvp.ui.init;

import android.os.Handler;
import android.widget.Toast;

import com.wangpos.s_mvp.base.util.SyncTaskManager;

/**
 * Created by qiyue on 2018/1/5.
 */

public class InitModel2 {

    private Handler mHandler;

    public InitModel2(){
        mHandler = new Handler();
    }

    public void request_1(){
        Thread t = new Thread(){
            @Override
            public void run() {
                super.run();

                /**
                 * 模拟2秒请求
                 *
                 *
                 */

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        SyncTaskManager.as().get("init").onFinish("Hello");
                    }
                });
            }
        };
        t.start();
    }


    public void request_2(String param){
        Thread t = new Thread(){
            @Override
            public void run() {
                super.run();
                /**
                 * 模拟2秒请求
                 *
                 *
                 */

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        SyncTaskManager.as().get("init").onFinish(param+" World");
                    }
                });
            }
        };
        t.start();
    }

    public void request_3(String param,OnRequestListener listener){
        Thread t = new Thread(){
            @Override
            public void run() {
                super.run();
                /**
                 * 模拟2秒请求
                 *
                 *
                 */

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        listener.onSuccess(param+"!");
                    }
                });
            }
        };
        t.start();
    }


    public interface OnRequestListener{
        void onSuccess(String msg);
    }
}
