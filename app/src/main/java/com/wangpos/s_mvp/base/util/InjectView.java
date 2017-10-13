package com.wangpos.s_mvp.base.util;

import android.app.Activity;


import com.example.bindview.BindViewException;
import com.example.bindview.ViewBinder;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by qiyue on 17/10/13.
 */

public class InjectView {
    private static Map<Activity, ViewBinder> map = new HashMap<>();

    /**
     * bind以后相当于才findViewById，但是代码只要有注解就已经生成好了
     * @param activity
     */
    public static void bind(Activity activity) {
        String className = activity.getClass().getName();
        try {
            //反射使用apt生成的类
            Class<?> viewClass = Class.forName(className + "$$ViewBinder");

            ViewBinder binder = map.get(activity);
            if (binder != null) {
                throw new BindViewException("InjectView bind 调用重复");
            }else{
                binder = (ViewBinder) viewClass.newInstance();
                map.put(activity,binder);
            }

            binder.bind(activity);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }


    public static void unbind(Activity activity){
        /**
         * 如果不unBind下次再次进入activity的时候会bind不成功
         */
        map.remove(activity);
    }
}
