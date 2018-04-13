package com.shenhesoft.lehealth.data;

import cn.droidlover.xdroidmvp.base.ActivityCollector;
import cn.droidlover.xdroidmvp.cache.SharedPref;

/**
 * @author mashanshui
 * @date 2018/4/13
 * @desc TODO
 */
public class LoginLocalDataSource implements LoginDataSource {
    @Override
    public void login(String userName, String passWord, LoginCallBack callBack) {
        String username = SharedPref.getInstance(ActivityCollector.getTopActivity()).getString("username", "");
        String password = SharedPref.getInstance(ActivityCollector.getTopActivity()).getString("password", "");
        if (userName.equals(username) && passWord.equals(password)) {
            callBack.onSuccess(userName, passWord);
        } else {
            callBack.onError();
        }
    }
}
