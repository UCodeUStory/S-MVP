package com.wangpos.s_mvp.base.task;

import android.util.Log;

import java.lang.ref.SoftReference;
import java.util.HashMap;

/**
 * Created by qiyue on 2017/12/22.
 */

public class SmartTaskManager {


    private HashMap<String, Asynctask> asyncTasks;

    private HashMap<String, SyncTask> syncTasks;

    private static volatile SmartTaskManager smartTaskManager;

    private SmartTaskManager() {
        this.asyncTasks = new HashMap<>();
        this.syncTasks = new HashMap<>();
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
     * @param key
     * @param count 线程数量
     */
    public Asynctask put(String key, int count) {

        synchronized (asyncTasks) {
            Asynctask smartTask = Asynctask.newInstance(count);
            asyncTasks.put(key, smartTask);
            return smartTask;
        }

    }

    public SyncTask put(String tag) {
        synchronized (syncTasks) {
            SyncTask syncTask = new SyncTask();
            syncTasks.put(tag, syncTask);
            return syncTask;
        }

    }

    public Asynctask getAsyncTask(String key) {
        synchronized (asyncTasks) {
//            for (String s : asyncTasks.keySet()) {
//                Log.i("info","key="+s);
//            }
            Asynctask smartTask = asyncTasks.get(key);
            return smartTask;
        }
    }


    public SyncTask getSyncTask(String tag) {
        synchronized (syncTasks) {
            SyncTask syncTask = null;
            if (syncTasks.containsKey(tag)) {
                syncTask = syncTasks.get(tag);
            } else {
                syncTask = put(tag);
            }

            return syncTask;
        }

    }

    /**
     * remove 调对应的task，否则导致内存泄露，（这里使用sofeRefence还是可以避免的）
     *
     * @param key
     */
    public void remove(String key) {
        synchronized (asyncTasks) {
            Asynctask asynctask = asyncTasks.remove(key);
            if (asynctask != null) asynctask.stop();
        }
        synchronized (syncTasks) {
            SyncTask synctask = syncTasks.remove(key);
            if (synctask != null) synctask.stop();
        }
    }

    public void clearAll() {
        synchronized (asyncTasks) {
            for (String key : asyncTasks.keySet()) {
                Asynctask asynctask = asyncTasks.remove(key);
                if (asynctask != null) asynctask.stop();
            }
            asyncTasks.clear();
        }
        synchronized (syncTasks) {
            for (String key : syncTasks.keySet()) {
                SyncTask synctask = syncTasks.remove(key);
                if (synctask != null) synctask.stop();
            }
            syncTasks.clear();
        }
    }


    public int getSyncTaskSize() {
        synchronized (syncTasks) {
            return syncTasks.size();
        }
    }

    public int getAsyncTaskSize() {
        synchronized (asyncTasks) {
            return asyncTasks.size();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String s : asyncTasks.keySet()) {
            sb.append("\n");
            sb.append(s);
        }
        return sb.toString();
    }
}
