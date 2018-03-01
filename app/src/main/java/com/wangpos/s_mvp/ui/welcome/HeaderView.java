package com.wangpos.s_mvp.ui.welcome;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.wangpos.s_mvp.R;
import com.wangpos.s_mvp.base.task.Asynctask;
import com.wangpos.s_mvp.base.task.SmartTaskManager;
import com.wangpos.s_mvp.base.widget.LifeFrameLayout;
import com.wangpos.s_mvp.base.widget.LifeLinearLayout;

import android.os.Handler;

/**
 * Created by qiyue on 2018/2/28.
 */

public class HeaderView extends LifeFrameLayout implements WelcomeContract.View {

    private WelcomeContract.Presenter mPresenter;

    private ImageView imageView;

    private TextView tvTime;

    private Handler mHandler;

    SmartTaskManager smartTaskManager;

    public HeaderView(Context context) {
        super(context);
    }

    public HeaderView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public HeaderView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void ON_CREATE() {
        super.ON_CREATE();
        //notice 初始化presenter
        Log.i("info","MyObserver:ON_CREATE");
        smartTaskManager = SmartTaskManager.as();
        mPresenter = new WelcomePresenter();
        mPresenter.onAttachedView(this);
        mPresenter.loadHeader();
        imageView = findViewById(R.id.iv_header);
        tvTime = findViewById(R.id.time);
        final int[] count = {3};
        mHandler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (count[0] >0){
                    tvTime.setText("加载中..."+count[0]);
                    count[0]--;
                    mHandler.sendEmptyMessageDelayed(0,1000);
                }else{
                    tvTime.setVisibility(GONE);
                }
            }
        };
        mHandler.sendEmptyMessage(0);

    }

    @Override
    public void onLoadSuccess(int id) {
        imageView.setImageResource(id);
        Log.i("info","onLoadSuccess "+smartTaskManager.getSize());
        Asynctask asyncTask = smartTaskManager.getAsyncTask("initPage");
        asyncTask.onFinish();

    }

    @Override
    public void onLoadMenuSuccess(int id) {

    }
}
