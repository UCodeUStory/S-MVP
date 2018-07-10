package com.wangpos.s_mvp.base.widget;

import android.content.Context;
import android.support.annotation.ColorRes;
import android.widget.Toast;

/**
 * Created by qiyue on 2018/7/10.
 */

public class BaseImpl implements IBase {

    private Context context;

    public BaseImpl(Context acontext){
        context = acontext;
    }

    @Override
    public void toast(String msg) {
        Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();
    }
}
