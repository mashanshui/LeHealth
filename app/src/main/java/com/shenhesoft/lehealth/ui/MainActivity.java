package com.shenhesoft.lehealth.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;

import com.shenhesoft.lehealth.R;
import com.shenhesoft.lehealth.adapter.MainViewPageFragmentAdapter;
import com.shenhesoft.lehealth.ui.fragment.DataFragment;
import com.shenhesoft.lehealth.ui.fragment.HealthFragment;
import com.shenhesoft.lehealth.ui.fragment.PersonalFragment;

import butterknife.BindView;
import cn.droidlover.xdroidmvp.mvp.XTitleActivity;

public class MainActivity extends XTitleActivity {

    @BindView(R.id.bottomNavigationView)
    BottomNavigationView bottomNavigationView;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    /**
     * ViewPage中的数据分析
     */
    private DataFragment dataFragment;
    /**
     * ViewPage中的健康管理
     */
    private HealthFragment healthFragment;
    /**
     * ViewPage中的个人中心
     */
    private PersonalFragment personalFragment;
    private MenuItem menuItem;

    //BottomNavigationView的监听事件
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    //点击菜单项时跳转ViewPage
                    viewPager.setCurrentItem(0);
                    return true;
                case R.id.navigation_dashboard:
                    viewPager.setCurrentItem(1);
                    return true;
                case R.id.navigation_notifications:
                    viewPager.setCurrentItem(2);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void initTitle() {
        setTitle(getString(R.string.health_management));
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        MainViewPageFragmentAdapter adapter = new MainViewPageFragmentAdapter(getSupportFragmentManager());
        dataFragment = new DataFragment();
        healthFragment = new HealthFragment();
        personalFragment = new PersonalFragment();
        adapter.addFragment(healthFragment);
        adapter.addFragment(dataFragment);
        adapter.addFragment(personalFragment);
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(2);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                // 将当前的页面对应的底部标签设为选中状态
                if (menuItem != null) {
                    menuItem.setChecked(false);
                } else {
                    bottomNavigationView.getMenu().getItem(0).setChecked(false);
                }
                menuItem = bottomNavigationView.getMenu().getItem(position);
                menuItem.setChecked(true);
                //设置标题
                if (position == 0) {
                    setTitle(getString(R.string.health_management));
                } else if (position == 1) {
                    setTitle(getString(R.string.data_analysis));
                } else if (position == 2) {
                    setTitle(getString(R.string.personal_center));
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public Object newP() {
        return null;
    }

}
