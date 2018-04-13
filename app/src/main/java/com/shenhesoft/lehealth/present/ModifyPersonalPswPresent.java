package com.shenhesoft.lehealth.present;

import android.text.TextUtils;

import com.shenhesoft.lehealth.ui.fragment.personal.ModifyPasswordFragment;

import cn.droidlover.xdroidmvp.base.ActivityCollector;
import cn.droidlover.xdroidmvp.cache.SharedPref;
import cn.droidlover.xdroidmvp.kit.IToast;
import cn.droidlover.xdroidmvp.mvp.XPresent;

public class ModifyPersonalPswPresent extends XPresent<ModifyPasswordFragment> {
    public void modifyPassword() {
        if (!TextUtils.isEmpty(getV().getNewPsw()) && !TextUtils.isEmpty(getV().getOldPsw())) {
            SharedPref.getInstance(ActivityCollector.getTopActivity()).putString("password", getV().getNewPsw());
            IToast.showShort("修改成功");
            getV().closePage();
        } else {
            IToast.showShort("请输入完整");
        }
    }
}
