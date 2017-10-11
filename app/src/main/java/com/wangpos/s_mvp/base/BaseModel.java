package com.wangpos.s_mvp.base;

import android.os.Handler;
import android.os.Looper;

/**
 * Created by qiyue on 2017/10/11.
 */

public abstract class BaseModel {
   protected Handler mHandler = new Handler(Looper.getMainLooper());
}
