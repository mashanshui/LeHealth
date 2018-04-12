package com.shenhesoft.lehealth.ui.fragment.personal;


import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.shenhesoft.lehealth.R;
import com.shenhesoft.lehealth.adapter.MessageAdapter;
import com.shenhesoft.lehealth.adapter.bean.MessageItem;
import com.shenhesoft.lehealth.util.event.HealthDataEvent;
import com.shenhesoft.lehealth.util.event.MedicalReportsEvent;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import cn.droidlover.xdroidmvp.event.BusProvider;
import cn.droidlover.xdroidmvp.mvp.XFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class PersonalHealthFragment extends XFragment {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private MessageAdapter adapter;

    private List<MessageItem> messageList = Arrays.asList(
            new MessageItem(R.drawable.ic_portrait_black_24dp, "健康数据"),
            new MessageItem(R.drawable.ic_comment_black_24dp, "体检报告")
    );

    public PersonalHealthFragment() {
        // Required empty public constructor
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        adapter = new MessageAdapter(R.layout.adapter_item_message, messageList);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(context,DividerItemDecoration.VERTICAL));
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                String message = messageList.get(position).getMessage();
                switch (message) {
                    case "健康数据":
                        BusProvider.getBus().post(new HealthDataEvent());
                        break;
                    case "体检报告":
                        BusProvider.getBus().post(new MedicalReportsEvent());
                        break;
                    default:
                        break;
                }
            }
        });
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_personal_health;
    }

    @Override
    public Object newP() {
        return null;
    }
}
