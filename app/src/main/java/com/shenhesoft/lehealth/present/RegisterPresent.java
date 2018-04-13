package com.shenhesoft.lehealth.present;

import com.shenhesoft.lehealth.data.RegisterDataSource;
import com.shenhesoft.lehealth.data.RegisterLocalDataSource;
import com.shenhesoft.lehealth.ui.activity.RegisterActivity;

import cn.droidlover.xdroidmvp.kit.IToast;
import cn.droidlover.xdroidmvp.mvp.XPresent;

/**
 * @author mashanshui
 * @date 2018/4/11
 * @desc TODO
 */
public class RegisterPresent extends XPresent<RegisterActivity> {

    private RegisterDataSource registerDataSource;

    public RegisterPresent() {
        registerDataSource = new RegisterLocalDataSource();
    }

    public void register(){
        if (!getV().getPassword().equals(getV().getConfirmPassword())) {
            IToast.showShort("两次密码不一致");
            return;
        }
        getV().showLoadingDialog();
        registerDataSource.register(getV().getUsername(), getV().getPassword(), getV().getConfirmPassword(), new RegisterDataSource.RegisterCallBack() {
            @Override
            public void onSuccess() {
                getV().dismissLoadingDialog();
                getV().toLoginActivity();
            }

            @Override
            public void onError() {
                getV().dismissLoadingDialog();
            }
        });
    }
}
