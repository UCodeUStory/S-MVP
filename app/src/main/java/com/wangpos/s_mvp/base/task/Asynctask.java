package com.wangpos.s_mvp.base.task;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.CountDownLatch;

/**
 * Created by qiyue on 2017/12/22.
 */

public class Asynctask {

    CountDownLatch latch;

    EndThread endThread;

    Handler mHandler;

    private Asynctask(int count) {
        mHandler = new Handler(Looper.getMainLooper());
        latch = new CountDownLatch(count);
        endThread = new EndThread();

    }

    public static Asynctask newInstance(int count) {

        Asynctask smartTask = new Asynctask(count);
        return smartTask;
    }

    public void onFinish() {
        latch.countDown();
    }

    public void toEnd(Runnable runnable) {
        endThread.setRunnable(runnable);
        endThread.start();
    }

    class EndThread extends Thread {

        Runnable runnable;

        public void setRunnable(Runnable runnable) {
            this.runnable = runnable;
        }

        @Override
        public void run() {
            super.run();
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (runnable != null) {
                //切换到UI线程
                mHandler.post(runnable);
            } else {
                try {
                    throw new EmptyRunnableException("请添加要执行的任务");
                } catch (EmptyRunnableException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void stop() {
        if (endThread != null) endThread.interrupt();
    }

    class EmptyRunnableException extends Exception {
        public EmptyRunnableException(String msg) {
            super(msg);
        }
    }
}
