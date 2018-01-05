package com.wangpos.s_mvp.base.util;

import java.lang.ref.SoftReference;
import java.util.HashMap;

/**
 * Created by qiyue on 2018/1/5.
 */

public class SyncTaskManager {
    static SyncTaskManager instance;

    HashMap<String, SyncTask> map;

    private SyncTaskManager() {
        map = new HashMap<>();
    }


    public static SyncTaskManager as() {
        if (instance == null) {
            synchronized (SyncTaskManager.class) {
                if (instance == null) {
                    instance = new SyncTaskManager();
                    return instance;
                }
            }
        }
        return instance;
    }

    public SyncTask put(String tag){
        SyncTask syncTask = new SyncTask();
        map.put(tag,syncTask);
        return syncTask;

    }

    public SyncTask get(String tag){
        return map.get(tag);
    }





}
