package com.shenhesoft.lehealth.ui.fragment.personal;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.shenhesoft.lehealth.R;
import com.shenhesoft.lehealth.adapter.MessageAdapter;
import com.shenhesoft.lehealth.adapter.bean.MessageItem;
import com.shenhesoft.lehealth.util.event.ModifyMessageEvent;
import com.shenhesoft.lehealth.util.event.ModifyPasswordEvent;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import cn.droidlover.xdroidmvp.event.BusProvider;
import cn.droidlover.xdroidmvp.mvp.XFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class PersonalSetFragment extends XFragment {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private MessageAdapter adapter;

    private List<MessageItem> messageList = Arrays.asList(
            new MessageItem(R.drawable.ic_portrait_black_24dp, "个人资料"),
            new MessageItem(R.drawable.ic_comment_black_24dp, "密码修改")
    );

    public PersonalSetFragment() {
        // Required empty public constructor
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        adapter = new MessageAdapter(R.layout.adapter_item_message, messageList);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.VERTICAL));
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                String message = messageList.get(position).getMessage();
                switch (message) {
                    case "个人资料":
                        BusProvider.getBus().post(new ModifyMessageEvent());
                        break;
                    case "密码修改":
                        BusProvider.getBus().post(new ModifyPasswordEvent());
                        break;
                    default:
                        break;
                }
            }
        });
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_personal_set;
    }

    @Override
    public Object newP() {
        return null;
    }


    @OnClick(R.id.btn_exit)
    public void onViewClicked() {
        restartApplication();
    }

    /**
     * 重启应用
     */
    private void restartApplication() {
        final Intent intent = getActivity().getPackageManager().getLaunchIntentForPackage(getActivity().getPackageName());
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
