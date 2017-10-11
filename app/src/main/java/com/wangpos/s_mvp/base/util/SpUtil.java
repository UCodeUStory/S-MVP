package com.wangpos.s_mvp.base.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.wangpos.s_mvp.base.BaseActivity;


/**
 * Created by Administrator on 2016/4/5.
 */
public class SpUtil {
    static SharedPreferences prefs;

    public static String getDataByKey(String key) {
        return prefs.getString(key, "");
    }

    public static void init(Context context) {
        prefs = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static boolean isNight() {
        return prefs.getBoolean("isNight", false);
    }

    public static void setNight(Context context, boolean isNight) {
        prefs.edit().putBoolean("isNight", isNight).apply();
        if (context instanceof BaseActivity)
            ((BaseActivity) context).reload();
    }

    public static String getData(String key) {
        return prefs.getString(key, "");
    }

    public static void setData(String key, String data) {
        prefs.edit().putString(key, data).apply();
    }
}
