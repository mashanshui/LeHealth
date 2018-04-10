package com.shenhesoft.lehealth.ui;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.shenhesoft.lehealth.R;
import com.shenhesoft.lehealth.present.LoginPresent;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.droidlover.xdroidmvp.mvp.XTitleActivity;

public class LoginActivity extends XTitleActivity<LoginPresent> {

    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.et_pw)
    EditText etPw;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.tv_register)
    TextView tvRegister;

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public LoginPresent newP() {
        return new LoginPresent();
    }


    @Override
    protected void initTitle() {
        setTitle("登录");
        setTitleBackgroundColor("#319FF0");
    }
}
