package com.shenhesoft.lehealth.ui;

import android.os.Bundle;

import com.shenhesoft.lehealth.R;

import cn.droidlover.xdroidmvp.mvp.XTitleActivity;

public class MainActivity extends XTitleActivity {

    @Override
    protected void initTitle() {
        setTitle("测试");
        setTitleBackgroundColor("#319FF0");
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public Object newP() {
        return null;
    }
}
