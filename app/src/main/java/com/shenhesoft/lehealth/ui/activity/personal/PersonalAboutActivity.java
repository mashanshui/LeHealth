package com.shenhesoft.lehealth.ui.activity.personal;

import android.os.Bundle;
import android.widget.TextView;

import com.shenhesoft.lehealth.R;

import butterknife.BindView;
import cn.droidlover.xdroidmvp.mvp.XTitleActivity;

public class PersonalAboutActivity extends XTitleActivity {


    @BindView(R.id.tv_introduction)
    TextView tvIntroduction;

    @Override
    protected void initTitle() {
        setTitle("关于我们");
        setBackAction();
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        tvIntroduction.setText("    "+"个人健康管理系统结合了个人对软件的期望，" +
                "将个人健康管理与移动端的软件很好的结合在了一起，" +
                "让此软件更加的贴近生活达到了让用户足不出户便可便捷的管理个人健康的目的。");
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_personal_about;
    }

    @Override
    public Object newP() {
        return null;
    }

}
