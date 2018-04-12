package com.shenhesoft.lehealth.ui.fragment.personal;


import android.app.Fragment;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shenhesoft.lehealth.R;
import com.shenhesoft.lehealth.present.ModifyPersonalMsgPresent;
import com.shenhesoft.lehealth.view.ModifyPersonalMsgView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import cn.droidlover.xdroidmvp.mvp.XFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class PersonalMessageFragment extends XFragment<ModifyPersonalMsgPresent> implements ModifyPersonalMsgView{

    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.cl_name)
    ConstraintLayout clName;
    @BindView(R.id.tv_sex)
    TextView tvSex;
    @BindView(R.id.cl_sex)
    ConstraintLayout clSex;
    @BindView(R.id.tv_hight)
    TextView tvHight;
    @BindView(R.id.cl_hight)
    ConstraintLayout clHight;
    @BindView(R.id.tv_weight)
    TextView tvWeight;
    @BindView(R.id.cl_weight)
    ConstraintLayout clWeight;

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_personal_message;
    }

    @Override
    public ModifyPersonalMsgPresent newP() {
        return new ModifyPersonalMsgPresent();
    }


    @OnClick({R.id.cl_name, R.id.cl_sex, R.id.cl_hight, R.id.cl_weight})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.cl_name:
                getP().modifyName();
                break;
            case R.id.cl_sex:
                getP().modifySex();
                break;
            case R.id.cl_hight:
                getP().modifyHight();
                break;
            case R.id.cl_weight:
                getP().modifyWeight();
                break;
            default:
                break;
        }
    }

    @Override
    public void updateName(String name) {
        tvName.setText(name);
    }

    @Override
    public void updateSex(String sex) {
        tvSex.setText(sex);
    }

    @Override
    public void updatehight(String hight) {
        tvHight.setText(hight);
    }

    @Override
    public void updateWeight(String weight) {
        tvWeight.setText(weight);
    }
}
