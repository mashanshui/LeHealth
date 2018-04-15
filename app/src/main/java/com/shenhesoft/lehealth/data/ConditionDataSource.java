package com.shenhesoft.lehealth.data;

import com.shenhesoft.lehealth.data.db.Blood;
import com.shenhesoft.lehealth.data.db.Heat;
import com.shenhesoft.lehealth.data.db.Plues;

import java.util.List;

/**
 * @author mashanshui
 * @date 2018/4/14
 * @desc TODO
 */
public interface ConditionDataSource {

    interface GetDataCallback {

        void onDataLoaded(List<Blood> tasks);

        void onDataNotAvailable();
    }

    List<Blood> getAllBlood();

    List<Heat> getAllHeat();

    List<Plues> getAllPlues();

    void saveBlood(String blood);

    void saveHeat(String heat);

    void savePlues(String plues);
}
