package com.wangpos.s_mvp.base.widget;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.RelativeLayout;

import com.wangpos.s_mvp.base.BasePresenter;
import com.wangpos.s_mvp.base.BaseView;
import com.wangpos.s_mvp.base.util.InjectView;
import com.wangpos.s_mvp.base.util.InstanceUtil;

import java.lang.reflect.ParameterizedType;

/**
 * Created by qiyue on 2018/7/3.
 */

public class LifeRelativeLayout<P extends BasePresenter> extends RelativeLayout implements LifecycleObserver {

    protected P mPresenter;

    protected IBase iBase;
    public LifeRelativeLayout(Context context) {
        super(context);
    }

    public LifeRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LifeRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void ON_CREATE() {
        InjectView.bind(this);
        iBase = new BaseImpl(getContext());//初始化公共操作
        mPresenter = iBase.initPresenter(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void ON_START() {
        Log.i("info","MyObserver:ON_START");
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void ON_RESUME() {
        Log.i("info","MyObserver:ON_RESUME");
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void ON_PAUSE() {
        Log.i("info","MyObserver:ON_PAUSE");
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void ON_STOP() {
        Log.i("info","MyObserver:ON_STOP");
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void ON_DESTROY() {
        Log.i("info","MyObserver:ON_DESTROY");
        InjectView.unbind(this);
        if (mPresenter != null) mPresenter.onDetached();
    }

}
