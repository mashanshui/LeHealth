package com.shenhesoft.lehealth.present;

import android.text.InputType;

import com.qmuiteam.qmui.widget.dialog.QMUIDialog;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogAction;
import com.shenhesoft.lehealth.ui.fragment.personal.HealthDataFragment;
import com.shenhesoft.lehealth.view.ModifyHealthDataView;

import cn.droidlover.xdroidmvp.base.ActivityCollector;
import cn.droidlover.xdroidmvp.cache.SharedPref;
import cn.droidlover.xdroidmvp.kit.IToast;
import cn.droidlover.xdroidmvp.mvp.XPresent;

/**
 * @author mashanshui
 * @date 2018/4/14
 * @desc TODO
 */
public class ModifyHelathDataPresent extends XPresent<HealthDataFragment>{
    public void modifyBlood() {
        showEditTextDialog("修改血压", "在此输入您的血压");
    }

    public void modifyHeat() {
        showEditTextDialog("修改体温", "在此输入您的体温");
    }

    public void modifyPlues() {
        showEditTextDialog("修改脉搏", "在此输入您的脉搏");
    }

    private void showEditTextDialog(final String title, String placeholder) {
        final QMUIDialog.EditTextDialogBuilder builder = new QMUIDialog.EditTextDialogBuilder(ActivityCollector.getTopActivity());
        builder.setTitle(title)
                .setPlaceholder(placeholder)
                .setInputType(InputType.TYPE_CLASS_TEXT)
                .addAction("取消", new QMUIDialogAction.ActionListener() {
                    @Override
                    public void onClick(QMUIDialog dialog, int index) {
                        dialog.dismiss();
                    }
                })
                .addAction("确定", new QMUIDialogAction.ActionListener() {
                    @Override
                    public void onClick(QMUIDialog dialog, int index) {
                        CharSequence text = builder.getEditText().getText();
                        if (text != null && text.length() > 0) {
                            if ("修改血压".equals(title)) {
                                SharedPref.getInstance(ActivityCollector.getTopActivity()).putString("blood", text.toString());
                                getV().updateBlood(text.toString());
                            } else if ("修改体温".equals(title)) {
                                SharedPref.getInstance(ActivityCollector.getTopActivity()).putString("heat", text.toString());
                                getV().updateHeat(text.toString());
                            } else if ("修改脉搏".equals(title)) {
                                SharedPref.getInstance(ActivityCollector.getTopActivity()).putString("plues", text.toString());
                                getV().updatePlues(text.toString());
                            }
                            dialog.dismiss();
                        } else {
                            IToast.showShort("请输入完整");
                        }
                    }
                })
                .show();
    }

    public void initData() {
        String blood = SharedPref.getInstance(ActivityCollector.getTopActivity()).getString("blood", "");
        String heat = SharedPref.getInstance(ActivityCollector.getTopActivity()).getString("heat", "");
        String plues = SharedPref.getInstance(ActivityCollector.getTopActivity()).getString("plues", "");
        getV().updateBlood(blood);
        getV().updateHeat(heat);
        getV().updatePlues(plues);
    }
}
