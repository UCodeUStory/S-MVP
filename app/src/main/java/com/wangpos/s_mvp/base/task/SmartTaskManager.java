package com.wangpos.s_mvp.base.task;

import java.lang.ref.SoftReference;
import java.util.HashMap;

/**
 * Created by qiyue on 2017/12/22.
 *
 */

public class SmartTaskManager {

    /**
     * 这里的SmartTask 必须要有一个强应用，引用他，否则，就会被回收
     */
    HashMap<String, SoftReference<Asynctask>> stmap;

    HashMap<String, SoftReference<SyncTask>> syncTaskMap;

    private static volatile SmartTaskManager smartTaskManager;


    private SmartTaskManager() {
        this.stmap = new HashMap<>();
        this.syncTaskMap = new HashMap<>();
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


    /**
     *
     * @param key
     * @param count 线程数量
     */
    public Asynctask put(String key,int count){

        synchronized (stmap) {
            Asynctask smartTask = Asynctask.newInstance(count);
            stmap.put(key,new SoftReference<Asynctask>(smartTask));
            return smartTask;
        }

    }

    public SyncTask put(String tag){
        synchronized(syncTaskMap){
            SyncTask syncTask = new SyncTask();
            syncTaskMap.put(tag,new SoftReference<SyncTask>(syncTask));
            return syncTask;
        }


    }

    public Asynctask getAsyncTask(String key){
        synchronized (stmap) {
            Asynctask smartTask = stmap.get(key).get();
            return smartTask;
        }
    }


    public SyncTask getSyncTask(String tag){
        synchronized (syncTaskMap){
            SyncTask syncTask = syncTaskMap.get(tag).get();
            return syncTask;
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
        synchronized (syncTaskMap){
            syncTaskMap.remove(key);
        }
    }

    public void clearAll(){
        synchronized (stmap){
            stmap.clear();
        }
        synchronized (syncTaskMap){
            syncTaskMap.clear();
        }
    }



}
