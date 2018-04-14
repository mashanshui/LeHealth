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
public class ConditionLocalDataSource implements ConditionDataSource {

    @Override
    public List<Blood> getAllBlood() {
        return null;
    }

    @Override
    public List<Heat> getAllHeat() {
        return null;
    }

    @Override
    public List<Plues> getAllPlues() {
        return null;
    }

    @Override
    public void saveBlood(Blood blood) {
        Blood blood1 = blood;
        blood1.save();
    }

    @Override
    public void saveHeat(Heat heat) {

    }

    @Override
    public void savePlues(Plues plues) {

    }
}
