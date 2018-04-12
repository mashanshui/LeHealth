package com.shenhesoft.lehealth.view;

import com.shenhesoft.lehealth.present.ModifyPersonalMsgPresent;

import cn.droidlover.xdroidmvp.mvp.IView;

/**
 * @author mashanshui
 * @date 2018/4/12
 * @desc TODO
 */
public interface ModifyPersonalMsgView extends IView<ModifyPersonalMsgPresent> {
    void updateName(String name);

    void updateSex(String sex);

    void updatehight(String hight);

    void updateWeight(String weight);
}
