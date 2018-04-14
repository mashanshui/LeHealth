package com.shenhesoft.lehealth.data.db;

import org.litepal.crud.DataSupport;

/**
 * @author mashanshui
 * @date 2018/4/14
 * @desc TODO
 */
public class Blood extends DataSupport {
    private String blood;

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }
}
