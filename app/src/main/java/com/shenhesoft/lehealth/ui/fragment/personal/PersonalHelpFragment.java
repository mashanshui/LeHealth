package com.shenhesoft.lehealth.ui.fragment.personal;


import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.shenhesoft.lehealth.R;
import com.shenhesoft.lehealth.adapter.MessageAdapter;
import com.shenhesoft.lehealth.adapter.bean.MessageItem;
import com.shenhesoft.lehealth.util.event.QuestionEvent1;
import com.shenhesoft.lehealth.util.event.QuestionEvent2;
import com.shenhesoft.lehealth.util.event.QuestionEvent3;
import com.shenhesoft.lehealth.util.event.QuestionEvent4;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import cn.droidlover.xdroidmvp.event.BusProvider;
import cn.droidlover.xdroidmvp.mvp.XFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class PersonalHelpFragment extends XFragment {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private MessageAdapter adapter;
    private List<MessageItem> messageList = Arrays.asList(
            new MessageItem(null, "如何注册账户"),
            new MessageItem(null, "如何登录账户"),
            new MessageItem(null, "如何修改个人资料"),
            new MessageItem(null, "如何修改密码")
    );

    public PersonalHelpFragment() {
        // Required empty public constructor
    }


    @Override
    public void initData(Bundle savedInstanceState) {
        adapter = new MessageAdapter(R.layout.adapter_item_message, messageList);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(context,DividerItemDecoration.VERTICAL));
        TextView textView = new TextView(context);
        textView.setText("常见问题");
        textView.setTextSize(20);
        adapter.setHeaderView(textView);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                String message = messageList.get(position).getMessage();
                switch (message) {
                    case "如何注册账户":
                        BusProvider.getBus().post(new QuestionEvent1());
                        break;
                    case "如何登录账户":
                        BusProvider.getBus().post(new QuestionEvent2());
                        break;
                    case "如何修改个人资料":
                        BusProvider.getBus().post(new QuestionEvent3());
                        break;
                    case "如何修改密码":
                        BusProvider.getBus().post(new QuestionEvent4());
                        break;
                    default:
                        break;
                }
            }
        });
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_personal_help;
    }

    @Override
    public Object newP() {
        return null;
    }
}
