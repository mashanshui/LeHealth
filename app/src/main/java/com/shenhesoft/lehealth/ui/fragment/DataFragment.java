package com.shenhesoft.lehealth.ui.fragment;


import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.shenhesoft.lehealth.R;
import com.shenhesoft.lehealth.data.model.HealthData;
import com.shenhesoft.lehealth.ui.activity.ConditionActivity;
import com.shenhesoft.lehealth.ui.activity.DataAnalyzeActivity;

import org.reactivestreams.Subscriber;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import cn.droidlover.xdroidmvp.mvp.XFragment;
import cn.droidlover.xdroidmvp.router.Router;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 * A simple {@link Fragment} subclass.
 */
public class DataFragment extends XFragment {
    private static final String TAG = "DataFragment";

    private static final int FILE_SELECT_CODE = 1;
    @BindView(R.id.btn_import)
    Button btnImport;
    private Intent intent;

    public DataFragment() {
        // Required empty public constructor
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_data;
    }

    @Override
    public Object newP() {
        return null;
    }

    @OnClick(R.id.btn_import)
    public void onViewClicked() {
        showFileChooser();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK && requestCode == 1) {
            Uri uri = data.getData();
            InputStream inputStream = null;
            try {
                inputStream = getContext().getContentResolver().openInputStream(uri);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            final InputStream finalInputStream = inputStream;
            Observable.create(new ObservableOnSubscribe<List<HealthData>>() {
                @Override
                public void subscribe(ObservableEmitter<List<HealthData>> e) throws Exception {
                    e.onNext(getXlsData(finalInputStream));
                }
            }).subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<List<HealthData>>() {
                        @Override
                        public void accept(List<HealthData> healthData) throws Exception {
                            Router.newIntent(context).to(DataAnalyzeActivity.class).putSerializable("data", (Serializable) healthData).launch();
                        }
                    });
        }
    }

    /**
     * 获取 excel 表格中的数据,不能在主线程中调用
     */
    private List<HealthData> getXlsData(InputStream inputStream) {
        List<HealthData> countryList = new ArrayList<HealthData>();
        try {
            Workbook workbook = Workbook.getWorkbook(inputStream);
            //得到所有的工作表
            Sheet[] sheets = workbook.getSheets();

            for (int m = 0; m < sheets.length; m++) {
                Sheet sheet = workbook.getSheet(m);
                //得到当前工作表的行数
                int Rows = sheet.getRows();
                //得到当前工作表的列数
                int Cols = sheet.getColumns();
                for (int i = 1; i < Rows; i++) {
                    HealthData healthData = new HealthData();
                    healthData.setNumber(sheet.getCell(0, i).getContents());
                    healthData.setBlood(sheet.getCell(1, i).getContents());
                    healthData.setHeat(sheet.getCell(2, i).getContents());
                    healthData.setPulse(sheet.getCell(3, i).getContents());
                    countryList.add(healthData);
                }
            }
            workbook.close();

        } catch (Exception e) {
            Log.e(TAG, "read error=" + e, e);
        }

        return countryList;
    }

    /**
     * 调用文件选择软件来选择文件
     **/
    private void showFileChooser() {
        intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("application/vnd.ms-excel");
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        try {
            startActivityForResult(Intent.createChooser(intent, "请选择一个要上传的文件"),
                    FILE_SELECT_CODE);
        } catch (android.content.ActivityNotFoundException ex) {
            // Potentially direct the user to the Market with a Dialog
            Toast.makeText(getActivity(), "请安装文件管理器", Toast.LENGTH_SHORT)
                    .show();
        }
    }
}
