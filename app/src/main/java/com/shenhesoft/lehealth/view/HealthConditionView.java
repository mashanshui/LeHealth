package com.shenhesoft.lehealth.view;

import com.shenhesoft.lehealth.present.HealthConditionPresent;

import cn.droidlover.xdroidmvp.mvp.IView;

/**
 * @author mashanshui
 * @date 2018/4/14
 * @desc TODO
 */
public interface HealthConditionView extends IView<HealthConditionPresent> {
    void updateBlood(String blood);

    void updateHeat(String heat);

    void updatePlues(String plues);

    void updateMessage(String message);

    String getBlood();

    String getHeat();

    String getPlues();
}
