package com.wangpos.s_mvp.widget;

/**
 * Created by Administrator on 2016/9/19 0019.
 */
public class TimeModel {
    public String time;

    public int id;

    public TimeModel(int id,String time, String content) {
        this.time = time;
        this.id = id;
        this.content = content;
    }

    public String content;
}
