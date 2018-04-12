package com.shenhesoft.lehealth.adapter;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.shenhesoft.lehealth.R;
import com.shenhesoft.lehealth.adapter.bean.MessageItem;

import java.util.List;

/**
 * @author mashanshui
 * @date 2018/4/12
 * @desc TODO
 */
public class MessageAdapter extends BaseQuickAdapter<MessageItem, BaseViewHolder> {

    public MessageAdapter(int layoutResId, @Nullable List<MessageItem> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MessageItem item) {
        if (item.getImage() == null) {
            helper.getView(R.id.imageView).setVisibility(View.GONE);
            helper.setText(R.id.textView, item.getMessage());
        } else {
            helper.setText(R.id.textView, item.getMessage());
            helper.setImageResource(R.id.imageView, item.getImage());
        }
    }
}
