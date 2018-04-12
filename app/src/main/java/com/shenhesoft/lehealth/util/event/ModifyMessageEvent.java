package com.shenhesoft.lehealth.util.event;

import cn.droidlover.xdroidmvp.event.IBus;

/**
 * @author mashanshui
 * @date 2018/4/12
 * @desc TODO
 */
public class ModifyMessageEvent implements IBus.IEvent {
    @Override
    public int getTag() {
        return 10;
    }
}
