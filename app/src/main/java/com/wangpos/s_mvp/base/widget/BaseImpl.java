package com.wangpos.s_mvp.base.widget;

import android.content.Context;
import android.support.annotation.ColorRes;
import android.widget.Toast;

import com.wangpos.s_mvp.base.BasePresenter;
import com.wangpos.s_mvp.base.BaseView;

import java.lang.reflect.ParameterizedType;

/**
 * Created by qiyue on 2018/7/10.
 */

public class BaseImpl implements IBase {

    private Context context;

    public BaseImpl(Context acontext){
        context = acontext;
    }

    @Override
    public void toast(String msg) {
        Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();
    }

    /**
     * 初始化Presenter
     * @param that
     * @param <P>
     * @return
     */
    public <P extends BasePresenter> P initPresenter(Object that) {
        P mPresenter = null;
        if (that instanceof BaseView &&
                that.getClass().getGenericSuperclass() instanceof ParameterizedType &&
                ((ParameterizedType) (that.getClass().getGenericSuperclass())).getActualTypeArguments().length > 0) {
            Class mPresenterClass = (Class) ((ParameterizedType) (that.getClass()
                    .getGenericSuperclass())).getActualTypeArguments()[0];
            try {
                mPresenter = (P)mPresenterClass.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            if (mPresenter != null) mPresenter.onAttachedView(that);
        }

        return mPresenter;
    }
}
