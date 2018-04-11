package com.shenhesoft.lehealth.data;

/**
 * @author mashanshui
 * @date 2018/4/11
 * @desc TODO
 */
public interface RegisterDataSource {
    interface RegisterCallBack {
        void onSuccess();

        void onError();
    }

    void register(String userName, String passWord,String ConfirmPassword, RegisterDataSource.RegisterCallBack callBack);
}
