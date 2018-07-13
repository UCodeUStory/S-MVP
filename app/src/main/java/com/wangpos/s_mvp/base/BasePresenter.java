package com.wangpos.s_mvp.base;


import com.wangpos.s_mvp.base.util.InstanceUtil;
import com.wangpos.s_mvp.base.util.LogUtils;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;

/**
 * Created by  qiyue on 16/4/22.
 */
public abstract class BasePresenter<V,M> {

    protected V mView;

    protected M mModel;

    //notice 默认用的Retrofit,如果用其他框架，这里需要修改
    protected Map<Integer, Call> mRequestMaps = new HashMap<Integer, Call>();

    public void onAttachedView(V v) {
        this.mView = v;
        this.onAttached();
    }

    public abstract void onAttached();

    public void onDetached() {

        /**
         * 避免内存泄漏
         */
        mView = null;
        mModel = null;

        /**同一个presenter 对象在一个Activity使用，所以当Activity销毁时可以全部取消掉**/
        for (Integer key : mRequestMaps.keySet()) {
            Call call = mRequestMaps.get(key);
            LogUtils.i("call is cancel");
            call.cancel();
        }
        mRequestMaps = null;
    }

    /**
     * 取消单个请求
     * @param key
     */
    public void cancelRequest(String key){
        if(mRequestMaps.containsKey(key)){
            Call call = mRequestMaps.get(key);
            call.cancel();
            mRequestMaps.remove(key);
        }
    }

}
