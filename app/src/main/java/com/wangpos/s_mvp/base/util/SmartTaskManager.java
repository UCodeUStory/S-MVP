package com.wangpos.s_mvp.base.util;

import java.util.WeakHashMap;

/**
 * Created by qiyue on 2017/12/22.
 */

public class SmartTaskManager {

    WeakHashMap<String, SmartTask> stmap;

    private static volatile SmartTaskManager smartTaskManager;

    private SmartTaskManager() {
        this.stmap = new WeakHashMap<>(50);
    }

    public static SmartTaskManager as() {

        if (smartTaskManager == null) {
            synchronized (SmartTaskManager.class) {
                if (smartTaskManager == null) {
                    smartTaskManager = new SmartTaskManager();
                    return smartTaskManager;
                }
            }
        }

        return smartTaskManager;
    }


    public SmartTask get(String key){
        synchronized (stmap) {
            SmartTask smartTask = stmap.get(key);
            return smartTask;
        }
    }

    /**
     *
     * @param key
     * @param count 线程数量
     */
    public SmartTask put(String key,int count){

        synchronized (stmap) {
            SmartTask smartTask = SmartTask.newInstance(count);
            stmap.put(key,  smartTask);
            return smartTask;
        }
    }
}
