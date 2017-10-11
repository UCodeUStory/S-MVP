package com.wangpos.s_mvp.base;



import com.wangpos.s_mvp.base.util.InstanceUtil;

import java.lang.reflect.ParameterizedType;


/**
 * Created by qiyue on 2016/4/5.
 */
@SuppressWarnings("unchecked")
public abstract class BaseActivity<P extends BasePresenter> extends BaseAppCompatActivity {
    public P mPresenter;

    @Override
    protected void initPresenter() {
        if (this instanceof BaseView &&
                this.getClass().getGenericSuperclass() instanceof ParameterizedType &&
                ((ParameterizedType) (this.getClass().getGenericSuperclass())).getActualTypeArguments().length > 0) {
            Class mPresenterClass = (Class) ((ParameterizedType) (this.getClass()
                    .getGenericSuperclass())).getActualTypeArguments()[0];
            /**
             * 根据运行时获取父类Class,实力化，不至于每个子类Presenter都去new
             *
             * 1优点，这样子类只需要指定泛型即可使用
             *
             */
            mPresenter = InstanceUtil.getInstance(mPresenterClass);
            if (mPresenter != null) mPresenter.onAttachedView(this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) mPresenter.onDetached();
    }
}
