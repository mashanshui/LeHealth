package com.shenhesoft.lehealth.present;

import android.text.TextUtils;

import com.shenhesoft.lehealth.ui.fragment.personal.MedicalReportsFragment;

import cn.droidlover.xdroidmvp.base.ActivityCollector;
import cn.droidlover.xdroidmvp.cache.SharedPref;
import cn.droidlover.xdroidmvp.mvp.XPresent;

/**
 * @author mashanshui
 * @date 2018/4/14
 * @desc TODO
 */
public class HealthConditionPresent extends XPresent<MedicalReportsFragment> {

    public void initData() {
        String blood = SharedPref.getInstance(ActivityCollector.getTopActivity()).getString("blood", "");
        String heat = SharedPref.getInstance(ActivityCollector.getTopActivity()).getString("heat", "");
        String plues = SharedPref.getInstance(ActivityCollector.getTopActivity()).getString("plues", "");
        if (!TextUtils.isEmpty(blood)) {
            checkIsNormal(blood, 0);
        }
        if (!TextUtils.isEmpty(heat)) {
            checkIsNormal(heat, 1);
        }
        if (!TextUtils.isEmpty(plues)) {
            checkIsNormal(plues, 2);
        }
    }

    private void checkIsNormal(String data,int type) {
        float num = Float.valueOf(data);
        if (type == 0) {
            if (num < 90) {
                getV().updateBlood("偏低");
            } else if (90 < num && num < 140) {
                getV().updateBlood("正常");
            } else {
                getV().updateBlood("偏高");
            }
        } else if (type == 1) {
            if (num < 36.3) {
                getV().updateHeat("偏低");
            } else if (36.3 < num && num < 37.2) {
                getV().updateHeat("正常");
            } else {
                getV().updateHeat("偏高");
            }
        } else if (type == 2) {
            if (num < 60) {
                getV().updatePlues("很慢");
            } else if (60 < num && num < 100) {
                getV().updatePlues("正常");
            } else {
                getV().updatePlues("很快");
            }
        }
        if ("正常".equals(getV().getBlood()) && "正常".equals(getV().getHeat()) && "正常".equals(getV().getPlues())) {
            getV().updateMessage("您的身体很健康");
        } else {
            getV().updateMessage("您的身体不健康");
        }
    }
}
