package com.wangpos.s_mvp.base.task;

import android.os.Handler;
import android.os.Looper;

import com.wangpos.s_mvp.ui.main.MainActivity;

import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by qiyue on 2017/12/22.
 */

public class Asynctask {

    private CountDownLatch latch;

    private RunnableWrapper runnableWrapper;

    private Handler mHandler;

    public static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 3, 60, TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(100));

    private Asynctask(int count) {
        mHandler = new Handler(Looper.getMainLooper());
        latch = new CountDownLatch(count);
        runnableWrapper = new RunnableWrapper();

    }

    public static Asynctask newInstance(int count) {
        Asynctask smartTask = new Asynctask(count);
        return smartTask;
    }

    public void onFinish() {
        latch.countDown();
    }

    public void toEnd(Runnable runnable) {
        runnableWrapper.setRunnable(latch, mHandler, runnable);
        threadPoolExecutor.execute(runnableWrapper);
    }

    static class RunnableWrapper implements Runnable {

        private CountDownLatch latch;
        private Handler handler;
        private Runnable runnable;


        public void setRunnable(CountDownLatch latch, Handler handler, Runnable runnable) {
            this.latch = latch;
            this.handler = handler;
            this.runnable = runnable;
        }

        public synchronized void clear() {
            this.handler = null;
            this.runnable = null;
            long count = latch.getCount();
            for (int i = 0; i < count; i++) {
                latch.countDown();
            }
            this.latch = null;
        }

        @Override
        public void run() {
            try {
                if (latch != null) {
                    latch.await();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            synchronized (this) {
                if (runnable != null && handler != null) {
                    //切换到UI线程
                    handler.post(runnable);
                } else {
                    try {
                        throw new EmptyRunnableException("请添加要执行的任务");
                    } catch (EmptyRunnableException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void stop() {
        mHandler.removeCallbacksAndMessages(null);
        runnableWrapper.clear();
        threadPoolExecutor.remove(runnableWrapper);

    }

    static class EmptyRunnableException extends Exception {
        public EmptyRunnableException(String msg) {
            super(msg);
        }
    }
}
