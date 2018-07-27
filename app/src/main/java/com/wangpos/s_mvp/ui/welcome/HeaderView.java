package com.wangpos.s_mvp.ui.welcome;

import android.content.Context;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bindview.$;
import com.wangpos.s_mvp.R;
import com.wangpos.s_mvp.base.task.Asynctask;
import com.wangpos.s_mvp.base.task.SmartTaskManager;
import com.wangpos.s_mvp.base.util.InjectView;
import com.wangpos.s_mvp.base.widget.LifeFrameLayout;

import android.os.Handler;

/**
 * Created by qiyue on 2018/2/28.
 */

public class HeaderView extends LifeFrameLayout<WelcomePresenter> implements WelcomeContract.View {


    @$(R.id.iv_header)
    public ImageView imageView;
    @$(R.id.time)
    public TextView tvTime;

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
        smartTaskManager = SmartTaskManager.as();
        mPresenter.loadHeader();

        final int[] count = {3};
        mHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (count[0] > 0) {
                    tvTime.setText("HeaderView独立加载（" + count[0] + "）");
                    count[0]--;
                    mHandler.sendEmptyMessageDelayed(0, 1000);
                } else {
                    tvTime.setVisibility(GONE);
                }
            }
        };
        mHandler.sendEmptyMessage(0);

    }


    @Override
    public void onLoadSuccess(int id) {
        imageView.setImageResource(id);
        Log.i("info", "onLoadSuccess " + smartTaskManager.getAsyncTaskSize());
        Asynctask asyncTask = smartTaskManager.getAsyncTask("initPage");
        asyncTask.onFinish();

    }

    @Override
    public void onLoadMenuSuccess(int id) {

    }
}
