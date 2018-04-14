package com.shenhesoft.lehealth.view;

import com.shenhesoft.lehealth.present.ModifyHelathDataPresent;

import cn.droidlover.xdroidmvp.mvp.IView;

/**
 * @author mashanshui
 * @date 2018/4/14
 * @desc TODO
 */
public interface ModifyHealthDataView extends IView<ModifyHelathDataPresent> {
    void updateBlood(String blood);

    void updateHeat(String heat);

    void updatePlues(String plues);
}
