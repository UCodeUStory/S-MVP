package com.wangpos.s_mvp.ui.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bindview.$;
import com.wangpos.s_mvp.R;
import com.wangpos.s_mvp.base.BaseActivity;
import com.wangpos.s_mvp.base.util.InjectView;
import com.wangpos.s_mvp.base.util.SmartTaskManager;
import com.wangpos.s_mvp.base.util.ToastUtil;
import com.wangpos.s_mvp.ui.init.InitModel;

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.View{


    @$(R.id.etuserName)
    public EditText etName;

    @$(R.id.etpassword)
    public EditText etPassword;

    public SmartTaskManager smartTaskManager;


    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {
        //tName = $(R.id.etuserName);
        // etPassword = $(R.id.etpassword);
        $(R.id.login).setOnClickListener(this);
        $(R.id.smartTask).setOnClickListener(this);
        smartTaskManager = SmartTaskManager.as();
        smartTaskManager.put("initTask",2);
        smartTaskManager.get("initTask").toEnd(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(),"页面全部初始化完成",Toast.LENGTH_SHORT).show();
            }
        });



    }

    @Override
    public void loginSuccess() {
        ToastUtil.show("登陆成功");
    }

    @Override
    public void signSuccess() {

    }

    @Override
    public void showMsg(String msg) {

    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()){
            case R.id.login:
                this.mPresenter.login(etName.getText().toString(),etPassword.getText().toString());
                break;
            case R.id.smartTask:
                InitModel initModel = new InitModel();
                initModel.init();
                initModel.otherInit();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        smartTaskManager.remove("initTask");
    }
}
