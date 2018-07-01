package com.wangpos.s_mvp.ui.welcome;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bindview.$;
import com.wangpos.s_mvp.R;
import com.wangpos.s_mvp.base.task.SmartTaskManager;
import com.wangpos.s_mvp.base.util.InjectView;
import com.wangpos.s_mvp.base.widget.LifeFrameLayout;

/**
 * Created by qiyue on 2018/2/28.
 */

public class MenuView extends LifeFrameLayout implements WelcomeContract.View{


    private WelcomeContract.Presenter mPresenter;

    @$(R.id.iv_menu)
    public ImageView imageView;
    @$(R.id.menu_time)
    public TextView tvTime;

    private Handler mHandler;

    private SmartTaskManager smartTaskManager;

    public MenuView(Context context) {
        super(context);
    }

    public MenuView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MenuView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }



    @Override
    public void ON_CREATE() {
        super.ON_CREATE();
        //notice 初始化presenter
        InjectView.bind(this);
        smartTaskManager = SmartTaskManager.as();
        mPresenter = new WelcomePresenter();
        mPresenter.onAttachedView(this);
        mPresenter.loadMenu();
//        imageView = findViewById(R.id.iv_menu);
//        tvTime = findViewById(R.id.menu_time);
        final int[] count = {4};
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
        Log.i("info","MyObserver:ON_CREATE");
    }

    @Override
    public void onLoadSuccess(int id) {

    }

    @Override
    public void onLoadMenuSuccess(int id) {
        imageView.setImageResource(id);
        smartTaskManager.getAsyncTask("initPage").onFinish();
    }

    @Override
    public void ON_DESTROY() {
        super.ON_DESTROY();
        InjectView.unbind(this);
        mPresenter.onDetached();
    }
}
