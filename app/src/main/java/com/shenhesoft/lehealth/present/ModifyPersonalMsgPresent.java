package com.shenhesoft.lehealth.present;

import android.text.InputType;
import android.util.Log;

import com.qmuiteam.qmui.widget.dialog.QMUIDialog;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogAction;
import com.shenhesoft.lehealth.ui.fragment.personal.PersonalMessageFragment;

import cn.droidlover.xdroidmvp.base.ActivityCollector;
import cn.droidlover.xdroidmvp.kit.IToast;
import cn.droidlover.xdroidmvp.mvp.XPresent;

/**
 * @author mashanshui
 * @date 2018/4/12
 * @desc TODO
 */
public class ModifyPersonalMsgPresent extends XPresent<PersonalMessageFragment> {
    private static final String TAG = "ModifyPersonalMsgPresen";
    public void modifyName() {
        showEditTextDialog("修改昵称", "在此输入您的昵称");
    }

    public void modifySex() {
        showEditTextDialog("修改性别","在此输入您的性别");
    }

    public void modifyHight() {
        showEditTextDialog("修改身高","在此输入您的身高");
    }

    public void modifyWeight() {
        showEditTextDialog("修改体重","在此输入您的体重");
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
                            if ("修改昵称".equals(title)) {
                                getV().updateName(text.toString());
                            } else if ("修改性别".equals(title)) {
                                getV().updateSex(text.toString());
                            } else if ("修改身高".equals(title)) {
                                getV().updatehight(text.toString());
                            } else if ("修改体重".equals(title)) {
                                getV().updateWeight(text.toString());
                            }
                            dialog.dismiss();
                        } else {
                            IToast.showShort("请输入完整");
                        }
                    }
                })
                .show();
    }
}
