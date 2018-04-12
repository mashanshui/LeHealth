package com.shenhesoft.lehealth.ui.activity.personal;

import android.os.Bundle;

import com.shenhesoft.lehealth.R;
import com.shenhesoft.lehealth.ui.fragment.personal.PersonalHelpFragment;
import com.shenhesoft.lehealth.ui.fragment.personal.QuestionFragment1;
import com.shenhesoft.lehealth.ui.fragment.personal.QuestionFragment2;
import com.shenhesoft.lehealth.ui.fragment.personal.QuestionFragment3;
import com.shenhesoft.lehealth.ui.fragment.personal.QuestionFragment4;
import com.shenhesoft.lehealth.util.ActivityUtil;
import com.shenhesoft.lehealth.util.event.HealthDataEvent;
import com.shenhesoft.lehealth.util.event.QuestionEvent1;
import com.shenhesoft.lehealth.util.event.QuestionEvent2;
import com.shenhesoft.lehealth.util.event.QuestionEvent3;
import com.shenhesoft.lehealth.util.event.QuestionEvent4;

import cn.droidlover.xdroidmvp.event.BusProvider;
import cn.droidlover.xdroidmvp.mvp.XTitleActivity;
import io.reactivex.functions.Consumer;

public class PersonalHelpActivity extends XTitleActivity {

    @Override
    protected void initTitle() {
        setTitle("帮助反馈");
        setBackAction();
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        ActivityUtil.addFragmentToActivity(getSupportFragmentManager(), new PersonalHelpFragment(), R.id.frameLayout);
    }

    @Override
    public boolean useEventBus() {
        return true;
    }

    @Override
    public void bindEvent() {
        super.bindEvent();
        BusProvider.getBus().toFlowable(QuestionEvent1.class)
                .subscribe(new Consumer<QuestionEvent1>() {
                    @Override
                    public void accept(QuestionEvent1 questionEvent1) throws Exception {
                        ActivityUtil.addFragmentToActivityToBackStack(getSupportFragmentManager(), new QuestionFragment1(), R.id.frameLayout);
                        setTitle("常见问题");
                    }
                });
        BusProvider.getBus().toFlowable(QuestionEvent2.class)
                .subscribe(new Consumer<QuestionEvent2>() {
                    @Override
                    public void accept(QuestionEvent2 questionEvent2) throws Exception {
                        ActivityUtil.addFragmentToActivityToBackStack(getSupportFragmentManager(), new QuestionFragment2(), R.id.frameLayout);
                        setTitle("常见问题");
                    }
                });
        BusProvider.getBus().toFlowable(QuestionEvent3.class)
                .subscribe(new Consumer<QuestionEvent3>() {
                    @Override
                    public void accept(QuestionEvent3 questionEvent3) throws Exception {
                        ActivityUtil.addFragmentToActivityToBackStack(getSupportFragmentManager(), new QuestionFragment3(), R.id.frameLayout);
                        setTitle("常见问题");
                    }
                });
        BusProvider.getBus().toFlowable(QuestionEvent4.class)
                .subscribe(new Consumer<QuestionEvent4>() {
                    @Override
                    public void accept(QuestionEvent4 questionEvent4) throws Exception {
                        ActivityUtil.addFragmentToActivityToBackStack(getSupportFragmentManager(), new QuestionFragment4(), R.id.frameLayout);
                        setTitle("常见问题");
                    }
                });
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_personal_help;
    }

    @Override
    public Object newP() {
        return null;
    }
}
