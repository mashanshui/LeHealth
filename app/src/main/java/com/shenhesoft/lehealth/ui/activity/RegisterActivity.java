package com.shenhesoft.lehealth.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.qmuiteam.qmui.widget.dialog.QMUITipDialog;
import com.shenhesoft.lehealth.R;
import com.shenhesoft.lehealth.present.RegisterPresent;
import com.shenhesoft.lehealth.view.RegisterView;

import butterknife.BindView;
import cn.droidlover.xdroidmvp.mvp.XTitleActivity;
import cn.droidlover.xdroidmvp.router.Router;


public class RegisterActivity extends XTitleActivity<RegisterPresent> implements RegisterView ,View.OnClickListener{

    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.et_pw)
    EditText etPw;
    @BindView(R.id.et_confirm_pw)
    EditText etConfirmPw;
    @BindView(R.id.btn_register)
    Button btnRegister;
    QMUITipDialog tipDialog;

    @Override
    protected void initTitle() {
        setTitle("注册");
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        btnRegister.setOnClickListener(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    public RegisterPresent newP() {
        return new RegisterPresent();
    }

    @Override
    public String getUsername() {
        return etName.getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return etPw.getText().toString().trim();
    }

    @Override
    public String getConfirmPassword() {
        return etConfirmPw.getText().toString().trim();
    }

    @Override
    public void showFailedError() {
        tipDialog = new QMUITipDialog.Builder(context)
                .setIconType(QMUITipDialog.Builder.ICON_TYPE_FAIL)
                .setTipWord("注册失败")
                .create();
        tipDialog.show();
    }

    @Override
    public void showLoadingDialog() {
        tipDialog = new QMUITipDialog.Builder(context)
                .setIconType(QMUITipDialog.Builder.ICON_TYPE_LOADING)
                .setTipWord("正在加载")
                .create();
        tipDialog.show();
    }

    @Override
    public void dismissLoadingDialog() {
        tipDialog.cancel();
    }

    @Override
    public void toLoginActivity() {
        Router.newIntent(context).to(LoginActivity.class).launch();
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_register:
                getP().register();
                break;
            default:
                break;
        }
    }
}
