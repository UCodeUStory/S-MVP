package com.wangpos.s_mvp.base.task;

import android.util.Log;

import java.lang.ref.SoftReference;
import java.util.HashMap;

/**
 * Created by qiyue on 2017/12/22.
 *
 */

public class SmartTaskManager {


    HashMap<String, Asynctask> stmap;

    HashMap<String, SyncTask> syncTaskMap;

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
            stmap.put(key,smartTask);
            return smartTask;
        }

    }

    public SyncTask put(String tag){
        synchronized(syncTaskMap){
            SyncTask syncTask = new SyncTask();
            syncTaskMap.put(tag,syncTask);
            return syncTask;
        }


    }

    public Asynctask getAsyncTask(String key){
        synchronized (stmap) {
//            for (String s : stmap.keySet()) {
//
//                Log.i("info","key="+s);
//
//            }
            Asynctask smartTask = stmap.get(key);
            return smartTask;
        }
    }


    public SyncTask getSyncTask(String tag){
        synchronized (syncTaskMap){
            SyncTask syncTask = null;
            if(syncTaskMap.containsKey(tag)) {
                syncTask = syncTaskMap.get(tag);
            }else{
                syncTask = put(tag);
            }

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
            Log.i("info",""+toString());
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


    public int getSize(){
        return stmap.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String s : stmap.keySet()) {
            sb.append("\n");
            sb.append(s);
        }
        return sb.toString();
    }
}
