package com.wangpos.s_mvp.base.widget;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;

import com.wangpos.s_mvp.base.BasePresenter;
import com.wangpos.s_mvp.base.BaseView;
import com.wangpos.s_mvp.base.util.InjectView;

import java.lang.reflect.ParameterizedType;

/**
 * Created by qiyue on 2018/7/6.
 */

public class LifeRecyclerView<P extends BasePresenter> extends RecyclerView implements LifecycleObserver,IBase {


    protected P mPresenter;

    protected IBase iBase;

    public LifeRecyclerView(Context context) {
        super(context);
    }

    public LifeRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public LifeRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
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

    @Override
    public void toast(String msg) {
        iBase.toast(msg);
    }

    @Override
    public <P extends BasePresenter> P initPresenter(Object that) {
        return null;
    }


}

