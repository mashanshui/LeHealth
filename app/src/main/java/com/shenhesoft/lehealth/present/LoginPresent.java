package com.shenhesoft.lehealth.present;

import com.shenhesoft.lehealth.data.LoginDataSource;
import com.shenhesoft.lehealth.ui.LoginActivity;

import java.util.concurrent.TimeUnit;

import cn.droidlover.xdroidmvp.mvp.XPresent;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * @author 马山水
 * @date 2018/3/30
 * @desc TODO
 */
public class LoginPresent extends XPresent<LoginActivity> {
    private LoginDataSource mLoginDataSource;

//    public LoginPresent() {
//        mLoginDataSource = new LoginNetDataSource();
//    }

    public void login() {
        mLoginDataSource.login(getV().getUsername(), getV().getPassword(), new LoginDataSource.LoginCallBack() {
            @Override
            public void onSuccess(String userName, String passWord) {
                getV().dismissLoadingDialog();
                getV().toMainActivity(userName,passWord);
            }

            @Override
            public void onError() {
                getV().dismissLoadingDialog();
                Observable.timer(1500, TimeUnit.MILLISECONDS)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Consumer<Long>() {
                            @Override
                            public void accept(Long aLong) throws Exception {
                                getV().dismissLoadingDialog();
                            }
                        });
                getV().showFailedError();
            }
        });
    }
}
