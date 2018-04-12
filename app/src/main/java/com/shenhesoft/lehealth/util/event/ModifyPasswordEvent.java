package com.shenhesoft.lehealth.util.event;

import cn.droidlover.xdroidmvp.event.IBus;

public class ModifyPasswordEvent implements IBus.IEvent {
    @Override
    public int getTag() {
        return 11;
    }
}
