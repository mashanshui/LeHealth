package com.shenhesoft.lehealth.ui.fragment.personal;


import android.app.Fragment;
import android.os.Bundle;
import android.widget.EditText;

import com.shenhesoft.lehealth.R;
import com.shenhesoft.lehealth.present.ModifyPersonalPswPresent;
import com.shenhesoft.lehealth.view.ModifyPersonalPswView;

import butterknife.BindView;
import butterknife.OnClick;
import cn.droidlover.xdroidmvp.mvp.XFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class ModifyPasswordFragment extends XFragment<ModifyPersonalPswPresent> implements ModifyPersonalPswView{

    @BindView(R.id.et_pw)
    EditText etPw;
    @BindView(R.id.et_new_pw)
    EditText etNewPw;

    public ModifyPasswordFragment() {
        // Required empty public constructor
    }


    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_modify_password;
    }

    @Override
    public ModifyPersonalPswPresent newP() {
        return new ModifyPersonalPswPresent();
    }

    @OnClick(R.id.btn_confirm)
    public void onViewClicked() {
        getP().modifyPassword();
    }

    @Override
    public String getOldPsw() {
        return etPw.getText().toString().trim();
    }

    @Override
    public String getNewPsw() {
        return etNewPw.getText().toString().trim();
    }

    @Override
    public void closePage() {
        getFragmentManager().popBackStack();
    }
}
