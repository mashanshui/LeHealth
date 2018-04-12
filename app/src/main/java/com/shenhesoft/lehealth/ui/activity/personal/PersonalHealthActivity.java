package com.shenhesoft.lehealth.ui.activity.personal;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.shenhesoft.lehealth.R;
import com.shenhesoft.lehealth.ui.fragment.personal.HealthDataFragment;
import com.shenhesoft.lehealth.ui.fragment.personal.MedicalReportsFragment;
import com.shenhesoft.lehealth.ui.fragment.personal.PersonalHealthFragment;
import com.shenhesoft.lehealth.util.ActivityUtil;
import com.shenhesoft.lehealth.util.event.HealthDataEvent;
import com.shenhesoft.lehealth.util.event.MedicalReportsEvent;

import butterknife.BindView;
import cn.droidlover.xdroidmvp.event.BusProvider;
import cn.droidlover.xdroidmvp.kit.IToast;
import cn.droidlover.xdroidmvp.mvp.XTitleActivity;
import io.reactivex.functions.Consumer;

public class PersonalHealthActivity extends XTitleActivity {


    @BindView(R.id.frameLayout)
    FrameLayout frameLayout;

    @Override
    protected void initTitle() {
        setTitle("健康档案");
        setBackAction();
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        ActivityUtil.addFragmentToActivity(getSupportFragmentManager(), new PersonalHealthFragment(), R.id.frameLayout);
    }

    @Override
    public boolean useEventBus() {
        return true;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_personal_health;
    }

    @Override
    public Object newP() {
        return null;
    }

    @Override
    public void bindEvent() {
        super.bindEvent();
        BusProvider.getBus().toFlowable(HealthDataEvent.class)
                .subscribe(new Consumer<HealthDataEvent>() {
                    @Override
                    public void accept(HealthDataEvent healthData) throws Exception {
                        if (healthData.getTag() == 0) {
                            ActivityUtil.addFragmentToActivityToBackStack(getSupportFragmentManager(), new HealthDataFragment(), R.id.frameLayout);
                            setTitle("健康数据");
                        }
                    }
                });
        BusProvider.getBus().toFlowable(MedicalReportsEvent.class)
                .subscribe(new Consumer<MedicalReportsEvent>() {
                    @Override
                    public void accept(MedicalReportsEvent medicalReportsEvent) throws Exception {
                        if (medicalReportsEvent.getTag() == 1) {
                            ActivityUtil.addFragmentToActivityToBackStack(getSupportFragmentManager(), new MedicalReportsFragment(), R.id.frameLayout);
                            setTitle("体检报告");
                        }
                    }
                });
    }
}
