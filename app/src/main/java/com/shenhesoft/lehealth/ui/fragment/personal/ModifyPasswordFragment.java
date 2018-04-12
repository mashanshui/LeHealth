package com.shenhesoft.lehealth.ui.fragment.personal;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shenhesoft.lehealth.R;

import cn.droidlover.xdroidmvp.mvp.XFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class ModifyPasswordFragment extends XFragment {


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
    public Object newP() {
        return null;
    }
}
