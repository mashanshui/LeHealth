package com.shenhesoft.lehealth.ui.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.shenhesoft.lehealth.R;
import com.shenhesoft.lehealth.ui.activity.ConditionActivity;

import butterknife.BindView;
import butterknife.OnClick;
import cn.droidlover.xdroidmvp.mvp.XFragment;
import cn.droidlover.xdroidmvp.router.Router;

public class HealthFragment extends XFragment {


    @BindView(R.id.btn_blood)
    Button btnBlood;
    @BindView(R.id.btn_heat)
    Button btnHeat;
    @BindView(R.id.btn_pulse)
    Button btnPulse;

    public HealthFragment() {
        // Required empty public constructor
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_health;
    }

    @Override
    public Object newP() {
        return null;
    }


    @OnClick({R.id.btn_blood, R.id.btn_heat, R.id.btn_pulse})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_blood:
                Router.newIntent(context).to(ConditionActivity.class).putInt("type", 0).launch();
                break;
            case R.id.btn_heat:
                Router.newIntent(context).to(ConditionActivity.class).putInt("type", 1).launch();
                break;
            case R.id.btn_pulse:
                Router.newIntent(context).to(ConditionActivity.class).putInt("type", 2).launch();
                break;
            default:
                break;
        }
    }
}
