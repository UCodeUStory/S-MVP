package com.wangpos.s_mvp.ui.login;

import android.util.Log;

import com.example.bindview.OnResume;

/**
 * Created by qiyue on 2017/11/6.
 */

public class LifePresenter {


    public void onResume(){

    }



    @OnResume(1)
    public void print(){

        Log.i("info","Life Presneter");
    }
}
