package com.shenhesoft.lehealth.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.qmuiteam.qmui.widget.dialog.QMUITipDialog;
import com.shenhesoft.lehealth.R;
import com.shenhesoft.lehealth.present.LoginPresent;
import com.shenhesoft.lehealth.view.LoginView;

import butterknife.BindView;
import cn.droidlover.xdroidmvp.mvp.XTitleActivity;
import cn.droidlover.xdroidmvp.router.Router;

public class LoginActivity extends XTitleActivity<LoginPresent> implements LoginView,View.OnClickListener{

    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.et_pw)
    EditText etPw;
    @BindView(R.id.btn_register)
    Button btnLogin;
    @BindView(R.id.tv_register)
    TextView tvRegister;

    QMUITipDialog tipDialog;

    @Override
    public void initData(Bundle savedInstanceState) {
        btnLogin.setOnClickListener(this);
        tvRegister.setOnClickListener(this);
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
    }

    @Override
    public String getUsername(){
        return etName.getText().toString().trim();
    }

    @Override
    public String getPassword(){
        return etPw.getText().toString().trim();
    }


    @Override
    public void toMainActivity(String userName, String password) {
        Router.newIntent(context).to(MainActivity.class).launch();
    }

    @Override
    public void showFailedError() {
        tipDialog = new QMUITipDialog.Builder(context)
                .setIconType(QMUITipDialog.Builder.ICON_TYPE_FAIL)
                .setTipWord("密码错误")
                .create();
    }

    @Override
    public void showLoadingDialog() {
        tipDialog = new QMUITipDialog.Builder(context)
                .setIconType(QMUITipDialog.Builder.ICON_TYPE_LOADING)
                .setTipWord("正在加载")
                .create();
    }

    @Override
    public void dismissLoadingDialog() {
        tipDialog.cancel();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_register:
                getP().login();
                break;
            case R.id.tv_register:
                Router.newIntent(context).to(RegisterActivity.class).launch();
                break;
            default:
                break;
        }
    }
}
