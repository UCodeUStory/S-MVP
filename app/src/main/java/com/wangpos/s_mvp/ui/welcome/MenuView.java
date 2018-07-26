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

public class MenuView extends LifeFrameLayout<WelcomePresenter> implements WelcomeContract.View {


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
        smartTaskManager = SmartTaskManager.as();
        mPresenter.loadMenu();
        final int[] count = {4};
        mHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (count[0] > 0) {
                    tvTime.setText("MenuView独立加载(" + count[0] + ")");
                    count[0]--;
                    mHandler.sendEmptyMessageDelayed(0, 1000);
                } else {
                    tvTime.setVisibility(GONE);
                }
            }
        };
        mHandler.sendEmptyMessage(0);
        Log.i("info", "MyObserver:ON_CREATE");
    }

    @Override
    public void onLoadSuccess(int id) {

    }

    @Override
    public void onLoadMenuSuccess(int id) {
        imageView.setImageResource(id);
        smartTaskManager.getAsyncTask("initPage").onFinish();
    }

}
