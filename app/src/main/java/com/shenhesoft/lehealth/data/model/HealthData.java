package com.shenhesoft.lehealth.data.model;

import java.io.Serializable;

/**
 * @author mashanshui
 * @date 2018/4/13
 * @desc TODO
 */
public class HealthData implements Serializable{
    private String number;
    private String blood;
    private String heat;
    private String pulse;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    public String getHeat() {
        return heat;
    }

    public void setHeat(String heat) {
        this.heat = heat;
    }

    public String getPulse() {
        return pulse;
    }

    public void setPulse(String pulse) {
        this.pulse = pulse;
    }
}
