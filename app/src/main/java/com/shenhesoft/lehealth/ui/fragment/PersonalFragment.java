package com.shenhesoft.lehealth.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
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
import com.shenhesoft.lehealth.ui.activity.personal.PersonalAboutActivity;
import com.shenhesoft.lehealth.ui.activity.personal.PersonalHealthActivity;
import com.shenhesoft.lehealth.ui.activity.personal.PersonalHelpActivity;
import com.shenhesoft.lehealth.ui.activity.personal.PersonalSetActivity;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.droidlover.xdroidmvp.cache.SharedPref;
import cn.droidlover.xdroidmvp.mvp.XFragment;
import cn.droidlover.xdroidmvp.router.Router;

/**
 * A simple {@link Fragment} subclass.
 */
public class PersonalFragment extends XFragment {


    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.username)
    TextView username;
    private MessageAdapter adapter;

    private List<MessageItem> messageList = Arrays.asList(
            new MessageItem(R.drawable.ic_portrait_black_24dp, "健康档案"),
            new MessageItem(R.drawable.ic_comment_black_24dp, "帮助反馈"),
            new MessageItem(R.drawable.ic_error_outline_black_24dp, "关于我们"),
            new MessageItem(R.drawable.ic_settings_black_24dp, "系统设置")
    );

    public PersonalFragment() {
        // Required empty public constructor
    }


    @Override
    public void initData(Bundle savedInstanceState) {
        String userName = SharedPref.getInstance(context).getString("username","");
        username.setText(userName);
        adapter = new MessageAdapter(R.layout.adapter_item_message, messageList);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.VERTICAL));
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                String message = messageList.get(position).getMessage();
                switch (message) {
                    case "健康档案":
                        Router.newIntent(context).to(PersonalHealthActivity.class).launch();
                        break;
                    case "帮助反馈":
                        Router.newIntent(context).to(PersonalHelpActivity.class).launch();
                        break;
                    case "关于我们":
                        Router.newIntent(context).to(PersonalAboutActivity.class).launch();
                        break;
                    case "系统设置":
                        Router.newIntent(context).to(PersonalSetActivity.class).launch();
                        break;
                    default:
                        break;
                }
            }
        });
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_personal;
    }

    @Override
    public Object newP() {
        return null;
    }

}
