package com.shenhesoft.lehealth;

import android.app.Application;

import org.litepal.LitePal;

/**
 * @author mashanshui
 * @date 2018/4/10
 * @desc TODO
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        LitePal.initialize(this);
    }
}
