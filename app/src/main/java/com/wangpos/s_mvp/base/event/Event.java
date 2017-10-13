package com.wangpos.s_mvp.base.event;

import android.os.Message;

/**
 * Created by qiyue on 16/11/15.
 */

public interface Event {
    void call(Message msg);
}
