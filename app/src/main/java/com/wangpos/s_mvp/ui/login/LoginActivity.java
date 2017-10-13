package com.wangpos.s_mvp.ui.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.bindview.$;
import com.wangpos.s_mvp.R;
import com.wangpos.s_mvp.base.BaseActivity;
import com.wangpos.s_mvp.base.util.InjectView;
import com.wangpos.s_mvp.base.util.ToastUtil;

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.View{


    @$(R.id.etuserName)
    public EditText etName;

    @$(R.id.etpassword)
    public EditText etPassword;



    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {
        InjectView.bind(this);
        $(R.id.login).setOnClickListener(this);
//        etName = $(R.id.etuserName);
//        etPassword = $(R.id.etpassword);

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
        }
    }
}
