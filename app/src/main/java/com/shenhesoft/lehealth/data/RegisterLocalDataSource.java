package com.shenhesoft.lehealth.data;

import cn.droidlover.xdroidmvp.base.ActivityCollector;
import cn.droidlover.xdroidmvp.cache.SharedPref;

/**
 * @author mashanshui
 * @date 2018/4/13
 * @desc TODO
 */
public class RegisterLocalDataSource implements RegisterDataSource {
    @Override
    public void register(String userName, String passWord, String ConfirmPassword, RegisterCallBack callBack) {
        SharedPref.getInstance(ActivityCollector.getTopActivity()).putString("username", userName);
        SharedPref.getInstance(ActivityCollector.getTopActivity()).putString("password", passWord);
        callBack.onSuccess();
    }
}
