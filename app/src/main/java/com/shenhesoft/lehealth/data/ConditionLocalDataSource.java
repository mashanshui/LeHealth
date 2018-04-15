package com.shenhesoft.lehealth.data;

import com.shenhesoft.lehealth.data.db.Blood;
import com.shenhesoft.lehealth.data.db.Heat;
import com.shenhesoft.lehealth.data.db.Plues;

import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * @author mashanshui
 * @date 2018/4/14
 * @desc TODO
 */
public class ConditionLocalDataSource implements ConditionDataSource {

    @Override
    public List<Blood> getAllBlood() {
        return DataSupport.findAll(Blood.class);
    }

    @Override
    public List<Heat> getAllHeat() {
        return DataSupport.findAll(Heat.class);
    }

    @Override
    public List<Plues> getAllPlues() {
        return DataSupport.findAll(Plues.class);
    }

    @Override
    public void saveBlood(String data) {
        Blood blood = new Blood();
        blood.setBlood(data);
        blood.save();
    }

    @Override
    public void saveHeat(String heat) {
        Heat heat1 = new Heat();
        heat1.setHeat(heat);
        heat1.save();
    }

    @Override
    public void savePlues(String plues) {
        Plues plues1 = new Plues();
        plues1.setPlues(plues);
        plues1.save();
    }

}
