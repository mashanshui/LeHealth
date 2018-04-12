package com.shenhesoft.lehealth.ui.activity.personal;

import android.os.Bundle;

import com.shenhesoft.lehealth.R;
import com.shenhesoft.lehealth.ui.fragment.personal.HealthDataFragment;
import com.shenhesoft.lehealth.ui.fragment.personal.ModifyPasswordFragment;
import com.shenhesoft.lehealth.ui.fragment.personal.PersonalHelpFragment;
import com.shenhesoft.lehealth.ui.fragment.personal.PersonalMessageFragment;
import com.shenhesoft.lehealth.ui.fragment.personal.PersonalSetFragment;
import com.shenhesoft.lehealth.util.ActivityUtil;
import com.shenhesoft.lehealth.util.event.HealthDataEvent;
import com.shenhesoft.lehealth.util.event.ModifyMessageEvent;
import com.shenhesoft.lehealth.util.event.ModifyPasswordEvent;

import cn.droidlover.xdroidmvp.event.BusProvider;
import cn.droidlover.xdroidmvp.mvp.XTitleActivity;
import io.reactivex.functions.Consumer;

public class PersonalSetActivity extends XTitleActivity {

    @Override
    protected void initTitle() {
        setTitle("系统设置");
        setBackAction();
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        ActivityUtil.addFragmentToActivity(getSupportFragmentManager(), new PersonalSetFragment(), R.id.frameLayout);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_personal_set;
    }

    @Override
    public boolean useEventBus() {
        return true;
    }

    @Override
    public void bindEvent() {
        super.bindEvent();
        BusProvider.getBus().toFlowable(ModifyMessageEvent.class)
                .subscribe(new Consumer<ModifyMessageEvent>() {
                    @Override
                    public void accept(ModifyMessageEvent modifyMessageEvent) throws Exception {
                        ActivityUtil.addFragmentToActivityToBackStack(getSupportFragmentManager(), new PersonalMessageFragment(), R.id.frameLayout);
                        setTitle("个人资料");
                    }
                });
        BusProvider.getBus().toFlowable(ModifyPasswordEvent.class)
                .subscribe(new Consumer<ModifyPasswordEvent>() {
                    @Override
                    public void accept(ModifyPasswordEvent modifyPasswordEvent) throws Exception {
                        ActivityUtil.addFragmentToActivityToBackStack(getSupportFragmentManager(), new ModifyPasswordFragment(), R.id.frameLayout);
                        setTitle("密码修改");
                    }
                });
    }

    @Override
    public Object newP() {
        return null;
    }
}
