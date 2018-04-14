package com.shenhesoft.lehealth.ui.fragment.personal;


import android.app.Fragment;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shenhesoft.lehealth.R;
import com.shenhesoft.lehealth.present.ModifyHelathDataPresent;
import com.shenhesoft.lehealth.view.ModifyHealthDataView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import cn.droidlover.xdroidmvp.mvp.XFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class HealthDataFragment extends XFragment<ModifyHelathDataPresent> implements ModifyHealthDataView {


    @BindView(R.id.tv_blood)
    TextView tvBlood;
    @BindView(R.id.cl_name)
    ConstraintLayout clName;
    @BindView(R.id.tv_heat)
    TextView tvHeat;
    @BindView(R.id.cl_sex)
    ConstraintLayout clSex;
    @BindView(R.id.tv_plues)
    TextView tvPlues;
    @BindView(R.id.cl_hight)
    ConstraintLayout clHight;

    public HealthDataFragment() {
        // Required empty public constructor
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        getP().initData();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_health_data;
    }

    @Override
    public ModifyHelathDataPresent newP() {
        return new ModifyHelathDataPresent();
    }

    @OnClick({R.id.cl_name, R.id.cl_sex, R.id.cl_hight})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.cl_name:
                getP().modifyBlood();
                break;
            case R.id.cl_sex:
                getP().modifyHeat();
                break;
            case R.id.cl_hight:
                getP().modifyPlues();
                break;
            default:
                break;
        }
    }

    @Override
    public void updateBlood(String blood) {
        tvBlood.setText(blood);
    }

    @Override
    public void updateHeat(String heat) {
        tvHeat.setText(heat);
    }

    @Override
    public void updatePlues(String plues) {
        tvPlues.setText(plues);
    }
}
