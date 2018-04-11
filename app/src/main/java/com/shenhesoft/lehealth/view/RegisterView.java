package com.shenhesoft.lehealth.view;

import com.shenhesoft.lehealth.present.RegisterPresent;

import cn.droidlover.xdroidmvp.mvp.IView;

/**
 * @author mashanshui
 * @date 2018/4/11
 * @desc TODO
 */
public interface RegisterView extends IView<RegisterPresent> {
    String getUsername();

    String getPassword();

    String getConfirmPassword();

    void showFailedError();

    void showLoadingDialog();

    void dismissLoadingDialog();

    void toLoginActivity();
}
