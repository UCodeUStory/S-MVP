package com.wangpos.s_mvp.base.util;

import java.lang.ref.SoftReference;
import java.util.HashMap;

/**
 * Created by qiyue on 2017/12/22.
 */

public class SmartTaskManager {

    /**
     * 这里的SmartTask 必须要有一个强应用，引用他，否则，就会被回收
     */
    HashMap<String, SoftReference<SmartTask>> stmap;

    private static volatile SmartTaskManager smartTaskManager;

    /**
     * 最大同步的线程流数
     */
    private SmartTaskManager() {
        this.stmap = new HashMap<>();
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
            SmartTask smartTask = stmap.get(key).get();
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
            stmap.put(key,new SoftReference<SmartTask>(smartTask));
            return smartTask;
        }

    }

    /**
     * remove 调对应的task，否则导致内存泄露，（这里使用sofeRefence还是可以避免的）
     * @param key
     */
    public void remove(String key){
        synchronized (stmap){
            stmap.remove(key);
        }
    }

    public void destory(){
        synchronized (stmap){
            stmap.clear();
        }
    }
}
