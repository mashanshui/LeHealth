package com.shenhesoft.lehealth.view;

import com.shenhesoft.lehealth.data.db.Blood;
import com.shenhesoft.lehealth.present.ConditionPresent;

import java.util.List;

import cn.droidlover.xdroidmvp.mvp.IView;

/**
 * @author mashanshui
 * @date 2018/4/14
 * @desc TODO
 */
public interface ConditionView extends IView<ConditionPresent> {

    void addData(String data);

    void addDatas(List<String> datas);
}
