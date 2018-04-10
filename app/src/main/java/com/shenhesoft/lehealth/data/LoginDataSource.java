package com.shenhesoft.lehealth.data;

/**
 * @author 马山水
 * @date 2018/3/28
 * @desc TODO
 */
public interface LoginDataSource {
    interface LoginCallBack {
        void onSuccess(String userName, String passWord);

        void onError();
    }

    void login(String userName, String passWord, LoginCallBack callBack);
}
