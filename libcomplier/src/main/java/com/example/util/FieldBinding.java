package com.example.util;

import javax.lang.model.type.TypeMirror;


/**
 * Created by qiyue on 2017/10/13.
 * FieldBinding
 */

public class FieldBinding {
    // 名字
    private String name;
    //类型
    private TypeMirror type;
    //Id
    private int resId;

    public FieldBinding(String name, TypeMirror type, int resId) {
        this.name = name;
        this.type = type;
        this.resId = resId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TypeMirror getType() {
        return type;
    }

    public void setType(TypeMirror type) {
        this.type = type;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }
}
