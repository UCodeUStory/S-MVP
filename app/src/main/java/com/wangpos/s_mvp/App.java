package com.wangpos.s_mvp;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;

import com.squareup.leakcanary.LeakCanary;
import com.wangpos.s_mvp.base.util.SpUtil;

import java.util.Stack;


/**
 * Created by qiyue on 2017/10/11.
 */


/**
 * Created by  qiyue on 16/4/23.
 */
public class App extends Application {
    private static App mApp;
    public Stack<Activity> store;

    public void onCreate() {
        super.onCreate();
        mApp = this;
        SpUtil.init(this);
        AppCompatDelegate.setDefaultNightMode(SpUtil.isNight() ? AppCompatDelegate.MODE_NIGHT_YES : AppCompatDelegate.MODE_NIGHT_NO);
        store = new Stack<>();
        registerActivityLifecycleCallbacks(new SwitchBackgroundCallbacks());

        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
    }

    public static App getAppContext() {
        return mApp;
    }


    private class SwitchBackgroundCallbacks implements Application.ActivityLifecycleCallbacks {

        @Override
        public void onActivityCreated(Activity activity, Bundle bundle) {
            store.add(activity);
        }

        @Override
        public void onActivityStarted(Activity activity) {

        }

        @Override
        public void onActivityResumed(Activity activity) {

        }

        @Override
        public void onActivityPaused(Activity activity) {

        }

        @Override
        public void onActivityStopped(Activity activity) {

        }

        @Override
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {

        }

        @Override
        public void onActivityDestroyed(Activity activity) {
            store.remove(activity);
        }
    }

    /**
     * 获取当前的Activity
     *
     * @return
     */
    public Activity getCurActivity() {
        return store.lastElement();
    }
}
