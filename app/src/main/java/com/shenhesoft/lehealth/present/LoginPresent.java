package com.shenhesoft.lehealth.present;

import com.shenhesoft.lehealth.data.LoginDataSource;
import com.shenhesoft.lehealth.ui.LoginActivity;

import cn.droidlover.xdroidmvp.mvp.XPresent;

/**
 * @author 马山水
 * @date 2018/3/30
 * @desc TODO
 */
public class LoginPresent extends XPresent<LoginActivity> {
    private LoginDataSource mLoginDataSource;

//    public LoginPresent() {
//        mLoginDataSource = new LoginNetDataSource();
//    }

    public void login() {
//        mLoginDataSource.login(getV().getUserName(), getV().getPassword(), new LoginDataSource.LoginCallBack() {
//            @Override
//            public void onSuccess(String userName, String passWord) {
//                getV().toMainActivity(userName,passWord);
//            }
//
//            @Override
//            public void onError() {
//                getV().showFailedError();
//            }
//        });
    }
}
