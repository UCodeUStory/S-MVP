package com.wangpos.s_mvp.bean;

/**
 * Created by qiyue on 2018/7/10.
 */

public class OtherBean {

    public String title;

    public OtherBean(String title, String createTime, String typeName) {
        this.title = title;
        this.createTime = createTime;
        this.typeName = typeName;
    }

    public String createTime;//ct

    public String typeName;//tag
}
