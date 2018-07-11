package com.wangpos.s_mvp.ui.synctask;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.DrawableRes;
import android.util.Log;
import android.widget.ImageView;

import com.wangpos.s_mvp.R;
import com.wangpos.s_mvp.base.task.SmartTaskManager;
import com.wangpos.s_mvp.base.task.SyncRunnable;
import com.wangpos.s_mvp.base.task.SyncTask;
import com.wangpos.s_mvp.utils.GlideUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qiyue on 2018/6/29.
 */

public class ImagePresenter extends SyncTaskContract.Presenter{

    private Handler mHandler;

    private List<Integer> datas;

    private SyncTask stk;
    public ImagePresenter(){
        datas = new ArrayList<>();
        mHandler = new Handler(Looper.getMainLooper());

        SmartTaskManager smartTaskManager = SmartTaskManager.as();
        stk = smartTaskManager.getSyncTask("loadImage");

    }

    /**
     * 模拟加载图片耗时1500秒
     */
    public void loadImage1(ImageView imageView){
        stk.onNext(obj ->
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                   GlideUtils.displayNative(imageView, R.drawable.anime1);
                   stk.onFinish(null);
                }
            },500)
        );

    }
    /**
     * 模拟加载图片耗时1000秒
     */
    public void loadImage2(ImageView imageView){
        stk.onNext(obj ->
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    GlideUtils.displayNative(imageView, R.drawable.anime2);
                    stk.onFinish(null);
                }
            },1000)
        );

    }

    /**
     * 模拟加载图片耗时1000秒
     * @param imageView
     */
    public void loadImage3(ImageView imageView){
        stk.onNext(obj ->
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    GlideUtils.displayNative(imageView, R.drawable.anime3);
                    stk.onFinish(null);

                }
            },900)
        );

    }

    /**
     * 模拟加载图片耗500秒
     * @param imageView
     */
    public void loadImage4(ImageView imageView){
        stk.onNext(obj ->
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    GlideUtils.displayNative(imageView, R.drawable.anime4);
                    stk.onFinish(null);
                }
            },500)
        );

    }

    /**
     * 模拟加载图片耗800秒
     * @param imageView
     */
    public void loadImage5(ImageView imageView){
        stk.onNext(obj ->
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    GlideUtils.displayNative(imageView, R.drawable.anime5);
                    stk.onFinish(null);
                }
            },800)
        );

    }

    /**
     * 模拟加载图片耗1000秒
     * @param imageView
     */
    public void loadImage6(ImageView imageView){
        stk.onNext(obj ->
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    GlideUtils.displayNative(imageView, R.drawable.anime6);
                    stk.onFinish(null);
                }
            },1000)
        );

    }

    /**
     * 模拟加载图片耗200秒
     * @param imageView
     */
    public void loadImage7(ImageView imageView){
        stk.onNext(obj ->
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    GlideUtils.displayNative(imageView, R.drawable.anime7);
                    stk.onFinish(null);
                }
            },200)
        );

    }

    /**
     * 模拟加载图片耗300秒
     * @param imageView
     */
    public void loadImage8(ImageView imageView){
        stk.onNext(obj ->
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    GlideUtils.displayNative(imageView, R.drawable.anime8);
                    stk.onFinish(null);
                }
            },300)
        );

    }
    /**
     * 模拟加载图片耗700秒
     * @param imageView
     */
    public void loadImage9(ImageView imageView){
        stk.onNext(obj ->
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    GlideUtils.displayNative(imageView, R.drawable.anime9);
                }
            },700)
        );
        stk.start();

    }


    @Override
    public void onDetached() {
        super.onDetached();
        SmartTaskManager smartTaskManager = SmartTaskManager.as();
        smartTaskManager.remove("loadImage");
        mHandler.removeCallbacksAndMessages(null);
    }
}
