package com.shenhesoft.lehealth.view;

import com.shenhesoft.lehealth.present.ModifyPersonalPswPresent;

import cn.droidlover.xdroidmvp.mvp.IView;

public interface ModifyPersonalPswView extends IView<ModifyPersonalPswPresent> {
    String getOldPsw();

    String getNewPsw();

    void closePage();
}
