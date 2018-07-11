package com.wangpos.s_mvp.ui.asynctask;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.ImageView;

import com.wangpos.s_mvp.R;
import com.wangpos.s_mvp.base.task.Asynctask;
import com.wangpos.s_mvp.base.task.SmartTaskManager;
import com.wangpos.s_mvp.base.task.SyncTask;
import com.wangpos.s_mvp.ui.synctask.SyncTaskContract;
import com.wangpos.s_mvp.utils.GlideUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qiyue on 2018/6/29.
 */

public class AsyncImagePresenter extends AsyncTaskContract.Presenter{

    private Handler mHandler;

    private List<Integer> datas;

    private Asynctask astk;
    public AsyncImagePresenter(){
        datas = new ArrayList<>();
        mHandler = new Handler(Looper.getMainLooper());

        SmartTaskManager smartTaskManager = SmartTaskManager.as();
        astk = smartTaskManager.getAsyncTask("asloadImage");

        Log.i("info","astk="+astk);

    }

    /**
     * 模拟加载图片耗时1500秒
     */
    public void loadImage1(ImageView imageView){
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                   GlideUtils.displayNative(imageView, R.drawable.meizi1);
                   astk.onFinish();
                }
            },500);

    }
    /**
     * 模拟加载图片耗时1000秒
     */
    public void loadImage2(ImageView imageView){
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    GlideUtils.displayNative(imageView, R.drawable.meizi2);
                    astk.onFinish();
                }
            },1000);
    }

    /**
     * 模拟加载图片耗时1000秒
     * @param imageView
     */
    public void loadImage3(ImageView imageView){
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    GlideUtils.displayNative(imageView, R.drawable.meizi3);
                    astk.onFinish();

                }
            },900);

    }

    /**
     * 模拟加载图片耗500秒
     * @param imageView
     */
    public void loadImage4(ImageView imageView){
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    GlideUtils.displayNative(imageView, R.drawable.meizi4);
                    astk.onFinish();
                }
            },500);

    }

    /**
     * 模拟加载图片耗800秒
     * @param imageView
     */
    public void loadImage5(ImageView imageView){
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    GlideUtils.displayNative(imageView, R.drawable.meizi5);
                    astk.onFinish();
                }
            },800);

    }

    /**
     * 模拟加载图片耗1000秒
     * @param imageView
     */
    public void loadImage6(ImageView imageView){
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    GlideUtils.displayNative(imageView, R.drawable.meizi6);
                    astk.onFinish();
                }
            },1600);

    }

    /**
     * 模拟加载图片耗200秒
     * @param imageView
     */
    public void loadImage7(ImageView imageView){
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    GlideUtils.displayNative(imageView, R.drawable.meizi7);
                    astk.onFinish();
                }
            },200);

    }

    /**
     * 模拟加载图片耗300秒
     * @param imageView
     */
    public void loadImage8(ImageView imageView){
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    GlideUtils.displayNative(imageView, R.drawable.meizi8);
                    astk.onFinish();
                }
            },2000);

    }
    /**
     * 模拟加载图片耗700秒
     * @param imageView
     */
    public void loadImage9(ImageView imageView){
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    GlideUtils.displayNative(imageView, R.drawable.meizi9);
                    astk.onFinish();
                }
            },700);

    }


    @Override
    public void onDetached() {
        super.onDetached();
        // 避免内存泄露
        SmartTaskManager smartTaskManager = SmartTaskManager.as();
        smartTaskManager.remove("asloadImage");
        mHandler.removeCallbacksAndMessages(null);
    }
}
