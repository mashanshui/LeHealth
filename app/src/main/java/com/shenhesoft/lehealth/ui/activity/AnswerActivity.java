package com.shenhesoft.lehealth.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;

import com.shenhesoft.lehealth.R;
import com.shenhesoft.lehealth.adapter.bean.AnswerAdapter;
import com.shenhesoft.lehealth.present.AnswerPresent;
import com.shenhesoft.lehealth.view.AnswerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.droidlover.xdroidmvp.mvp.XTitleActivity;

public class AnswerActivity extends XTitleActivity<AnswerPresent> implements AnswerView {

    @BindView(R.id.pagerWrap)
    FrameLayout pagerWrap;

    RecyclerView mRecyclerView;
    LinearLayoutManager mPagerLayoutManager;
    SnapHelper mSnapHelper;
    AnswerAdapter answerAdapter;

    @Override
    protected void initTitle() {
        setTitle("测试");
        setBackAction();
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        mRecyclerView = new RecyclerView(context);
        mPagerLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(mPagerLayoutManager);
        answerAdapter = new AnswerAdapter();
        answerAdapter.setItemCount(10);
        answerAdapter.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
        mRecyclerView.setAdapter(answerAdapter);
        pagerWrap.addView(mRecyclerView);
        // PagerSnapHelper每次只能滚动一个item;用LinearSnapHelper则可以一次滚动多个，并最终保证定位
        // mSnapHelper = new LinearSnapHelper();
        mSnapHelper = new PagerSnapHelper();
        mSnapHelper.attachToRecyclerView(mRecyclerView);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_answer;
    }

    @Override
    public AnswerPresent newP() {
        return new AnswerPresent();
    }

}
