package com.shenhesoft.lehealth.present;

import com.shenhesoft.lehealth.data.RegisterDataSource;
import com.shenhesoft.lehealth.ui.RegisterActivity;

import cn.droidlover.xdroidmvp.mvp.XPresent;

/**
 * @author mashanshui
 * @date 2018/4/11
 * @desc TODO
 */
public class RegisterPresent extends XPresent<RegisterActivity> {

    private RegisterDataSource registerDataSource;

//    public RegisterPresent() {
//        registerDataSource=new
//    }

    public void register(){
        registerDataSource.register(getV().getUsername(), getV().getPassword(), getV().getConfirmPassword(), new RegisterDataSource.RegisterCallBack() {
            @Override
            public void onSuccess() {

            }

            @Override
            public void onError() {

            }
        });
    }
}
