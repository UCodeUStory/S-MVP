package com.wangpos.s_mvp.ui.welcome;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;
import android.widget.Toast;

import com.wangpos.s_mvp.R;
import com.wangpos.s_mvp.base.task.SmartTaskManager;
import com.wangpos.s_mvp.base.widget.LifeFrameLayout;
import com.wangpos.s_mvp.base.widget.LifeLinearLayout;

/**
 * Created by qiyue on 2018/2/28.
 */

public class BodyView extends LifeLinearLayout {
    public BodyView(Context context) {
        super(context);
    }

    public BodyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BodyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void ON_CREATE() {
        super.ON_CREATE();
        TextView tvFooter = findViewById(R.id.tv_footer);
        SmartTaskManager smartTaskManager = SmartTaskManager.as();
        smartTaskManager.getAsyncTask("initPage").toEnd(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getContext(),"initfinish",Toast.LENGTH_SHORT).show();
                tvFooter.setText("页面全部初始化完成");
            }
        });
    }

    @Override
    public void ON_DESTROY() {
        super.ON_DESTROY();

    }
}
