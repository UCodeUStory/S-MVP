package com.wangpos.s_mvp.ui.meizi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.bindview.$;
import com.wangpos.s_mvp.R;
import com.wangpos.s_mvp.base.BaseActivity;
import com.wangpos.s_mvp.bean.MeiziResult;

public class FuliActivity extends BaseActivity {


    @$(R.id.meizi_list)
    public MeiziListView meiziListView;

    @Override
    public int getLayoutId() {
        return R.layout.activity_fuli;
    }

    @Override
    public void initView() {

        getLifecycle().addObserver(meiziListView);

    }
}
