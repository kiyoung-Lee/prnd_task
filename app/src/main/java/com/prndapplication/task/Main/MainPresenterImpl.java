package com.prndapplication.task.Main;

import android.annotation.SuppressLint;

import com.prndapplication.task.Common.BaseAdapter;
import com.prndapplication.task.Main.Data.CarInfo;
import com.prndapplication.task.Main.Data.MainRepository;

import java.util.ArrayList;
import java.util.List;

import static android.support.v4.util.Preconditions.checkNotNull;

/**
 * Created by kiyoungLee on 2018-01-02.
 */

public class MainPresenterImpl implements MainContract.Presenter{

    private MainRepository repository;
    private MainContract.ActivityView activityView;
    private BaseAdapter.Model adapterModel;
    private BaseAdapter.View adapterView;
    private List<CarInfo> cachedCarList;

    public MainPresenterImpl(MainRepository repository) {
        this.repository = repository;
        cachedCarList = new ArrayList<>();
    }

    public void setActivityView(MainContract.ActivityView activityView) {
        this.activityView = activityView;
    }

    public void setAdapterModel(BaseAdapter.Model adapterModel) {
        this.adapterModel = adapterModel;
    }

    public void setAdapterView(BaseAdapter.View adapterView) {
        this.adapterView = adapterView;
    }

    @SuppressLint("RestrictedApi")
    public void start(int page) {
        checkNotNull(activityView, "ActivityView Is Null");
        checkNotNull(adapterModel, "Adapter Model Is Null");
        checkNotNull(adapterView, "AdapterView Is Null");

        clearFirstPage(page);
        repository.getDefaultCarList(page, new MainRepository.DefaultCarListCallBack() {
            @Override
            public void defaultCarListLoaded(List<CarInfo> body) {
                changeAdapterList(body);
            }

            @Override
            public void dataNotAvailable() {
                if(page == 1)
                    activityView.showEmptyList();
            }
        });
    }

    @Override
    public void showSearchCarList(int page, int modelId) {
        clearFirstPage(page);
        repository.getSearchCarList(page, modelId, new MainRepository.SearchCarListCallBack() {
            @Override
            public void searchCarListLoaded(List<CarInfo> body) {
                changeAdapterList(body);
            }

            @Override
            public void dataNotAvailable() {
                if(page == 1)
                    activityView.showEmptyList();
            }
        });
    }

    private void clearFirstPage(int page){
        if(page == 1){
            cachedCarList.clear();
        }
    }

    private void changeAdapterList(List<CarInfo> body){
        cachedCarList.addAll(body);
        adapterModel.replaceData(cachedCarList);
        adapterView.notifyAdapter();
    }

    @Override
    public void clickCarItem(int carId) {
        activityView.showCarDetailPage(carId);
    }
}
