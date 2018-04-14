package com.shenhesoft.lehealth.ui.fragment.personal;


import android.app.Fragment;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.shenhesoft.lehealth.R;
import com.shenhesoft.lehealth.present.HealthConditionPresent;
import com.shenhesoft.lehealth.view.HealthConditionView;

import butterknife.BindView;
import cn.droidlover.xdroidmvp.mvp.XFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class MedicalReportsFragment extends XFragment<HealthConditionPresent> implements HealthConditionView{


    @BindView(R.id.tv_blood)
    TextView tvBlood;
    @BindView(R.id.tv_heat)
    TextView tvHeat;
    @BindView(R.id.tv_plues)
    TextView tvPlues;
    @BindView(R.id.btn_message)
    Button btnMessage;

    public MedicalReportsFragment() {
        // Required empty public constructor
    }


    @Override
    public void initData(Bundle savedInstanceState) {
        getP().initData();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_medical_reports;
    }

    @Override
    public HealthConditionPresent newP() {
        return new HealthConditionPresent();
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

    @Override
    public void updateMessage(String message) {
        btnMessage.setText(message);
    }

    @Override
    public String getBlood() {
        return tvBlood.getText().toString().trim();
    }

    @Override
    public String getHeat() {
        return tvHeat.getText().toString().trim();
    }

    @Override
    public String getPlues() {
       return tvPlues.getText().toString().trim();
    }
}
