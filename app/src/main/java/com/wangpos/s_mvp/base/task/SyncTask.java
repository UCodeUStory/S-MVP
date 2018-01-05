package com.wangpos.s_mvp.base.task;

import android.os.Looper;

import android.os.Handler;
import android.os.Message;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qiyue on 2018/1/5.
 */

public class SyncTask {

    Handler mHandler;

    List<SyncRunnable> tasks = new ArrayList<>();

    int currentIndex = -1;


    public SyncTask(){
        mHandler = new Handler(Looper.getMainLooper()){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);

                currentIndex ++;

                SyncRunnable runnable = tasks.get(currentIndex);
                runnable.run(msg.obj);
            }
        };
    }

    /**
     * 按顺序执行
     * @param runnable
     */
    public SyncTask onNext(SyncRunnable runnable){
        tasks.add(runnable);
        return this;
    }

    public void onFinish(Object obj){
        Message msg = new Message();
        msg.obj = obj;
        mHandler.sendMessage(msg);
    }

    public void start(){
        mHandler.sendEmptyMessage(0);
    }

    public void stop(){
        mHandler.removeCallbacksAndMessages(null);
        mHandler = null;
    }


}
