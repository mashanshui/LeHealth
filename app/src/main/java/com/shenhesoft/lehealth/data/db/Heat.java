package com.shenhesoft.lehealth.data.db;

import org.litepal.crud.DataSupport;

/**
 * @author mashanshui
 * @date 2018/4/14
 * @desc TODO
 */
public class Heat extends DataSupport {
    private String heat;

    public String getHeat() {
        return heat;
    }

    public void setHeat(String heat) {
        this.heat = heat;
    }
}
