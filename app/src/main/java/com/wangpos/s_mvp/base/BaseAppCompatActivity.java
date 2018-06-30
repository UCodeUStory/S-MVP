package com.wangpos.s_mvp.base;

import android.content.Context;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.wangpos.s_mvp.R;
import com.wangpos.s_mvp.base.task.SmartTaskManager;
import com.wangpos.s_mvp.base.util.InjectView;
import com.wangpos.s_mvp.base.util.MPermissionUtils;
import com.wangpos.s_mvp.base.util.SpUtil;
import com.wangpos.s_mvp.ui.welcome.WelcomeActivity;


public abstract class BaseAppCompatActivity extends AppCompatActivity implements View.OnClickListener{
    public Context mContext;

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View rootView = getLayoutInflater().inflate(this.getLayoutId(), null, false);
        this.setContentView(getLayoutId(), rootView);
        InjectView.bind(this);
        mContext = this;
        initPresenter();
        initView();

    }

    protected void initPresenter() {
    }


    /**
     * 默认启动Activity,不传递任何参数
     * @param ActivityClass
     */
    protected void launch(Class<?> ActivityClass) {
        startActivity(new Intent(this,ActivityClass));
    }


    @SuppressWarnings("unchecked")
    protected <V extends View> V $(int id) {
        return (V) this.findViewById(id);
    }


    public void reload() {
        AppCompatDelegate.setDefaultNightMode(SpUtil.isNight() ? AppCompatDelegate.MODE_NIGHT_YES : AppCompatDelegate.MODE_NIGHT_NO);
//        getWindow().setWindowAnimations(R.style.WindowAnimationFadeInOut);
        recreate();
    }

    public void setContentView(int layoutResID, View rootView) {
        boolean isNotSwipeBack = layoutResID == R.layout.activity_main ;
        super.setContentView(isNotSwipeBack ? rootView : getContainer(rootView));
    }

    private View getContainer(View rootView) {
        //notice 可以做子布局，添加包装
//        View container = getLayoutInflater().inflate(R.layout.activity_base, null, false);
//        container.addView();
        return rootView;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (-1 != getMenuId()) getMenuInflater().inflate(getMenuId(), menu);
        return true;
    }

    public int getMenuId() {
        return -1;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) onBackPressed();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        MPermissionUtils.onRequestPermissionsResult(requestCode, permissions, grantResults);
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    public abstract int getLayoutId();

    public abstract void initView();

    @Override
    public void onClick(View view) {

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        InjectView.unbind(this);
    }
}
