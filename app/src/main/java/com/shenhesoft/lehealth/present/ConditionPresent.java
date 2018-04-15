package com.shenhesoft.lehealth.present;

import com.shenhesoft.lehealth.data.ConditionLocalDataSource;
import com.shenhesoft.lehealth.data.db.Blood;
import com.shenhesoft.lehealth.data.db.Heat;
import com.shenhesoft.lehealth.data.db.Plues;
import com.shenhesoft.lehealth.ui.activity.ConditionActivity;

import java.util.ArrayList;
import java.util.List;

import cn.droidlover.xdroidmvp.mvp.XPresent;

/**
 * @author mashanshui
 * @date 2018/4/14
 * @desc TODO
 */
public class ConditionPresent extends XPresent<ConditionActivity> {
    private ConditionLocalDataSource localDataSource;

    public ConditionPresent() {
        localDataSource = new ConditionLocalDataSource();
    }

    public void addBloodData(String trim) {
        localDataSource.saveBlood(trim);
        getV().addData(trim);
    }

    public void addHeatData(String trim) {
        localDataSource.saveHeat(trim);
        getV().addData(trim);
    }

    public void addPluesData(String trim) {
        localDataSource.savePlues(trim);
        getV().addData(trim);
    }

    public void initBloodData() {
        List<Blood> bloodList = localDataSource.getAllBlood();
        List<String> list = new ArrayList<>();
        for (Blood blood : bloodList) {
            list.add(blood.getBlood());
        }
        getV().addDatas(list);
    }

    public void initHeatData() {
        List<Heat> heatList = localDataSource.getAllHeat();
        List<String> list = new ArrayList<>();
        for (Heat heat : heatList) {
            list.add(heat.getHeat());
        }
        getV().addDatas(list);
    }

    public void initPluesData() {
        List<Plues> pluesList = localDataSource.getAllPlues();
        List<String> list = new ArrayList<>();
        for (Plues plues : pluesList) {
            list.add(plues.getPlues());
        }
        getV().addDatas(list);
    }

}
