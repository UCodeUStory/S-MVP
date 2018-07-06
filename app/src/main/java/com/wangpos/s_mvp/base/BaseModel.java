package com.wangpos.s_mvp.base;

import android.os.Handler;
import android.os.Looper;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by qiyue on 2017/10/11.
 */

public abstract class BaseModel {
   protected Handler mHandler = new Handler(Looper.getMainLooper());
   protected CompositeDisposable mCompositeDisposable;

   //RxJava取消注册，以避免内存泄露
   public void onUnSubscribe() {
      if (mCompositeDisposable != null) {
         mCompositeDisposable.dispose();
      }
   }


   public void addSubscription(Observable observable, DisposableObserver observer) {
      if (mCompositeDisposable == null) {
         mCompositeDisposable = new CompositeDisposable();
      }

      mCompositeDisposable.add(observer);

      observable.subscribeOn(Schedulers.io())
              .observeOn(AndroidSchedulers.mainThread())
              .subscribeWith(observer);
   }
}
