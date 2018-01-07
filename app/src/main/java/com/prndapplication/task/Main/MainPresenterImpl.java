package com.prndapplication.task.Main;

import android.annotation.SuppressLint;

import com.prndapplication.task.Common.BaseAdapter;
import com.prndapplication.task.Main.Data.CarInfo;
import com.prndapplication.task.Main.Data.MainRepository;

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

    public MainPresenterImpl(MainRepository repository) {
        this.repository = repository;
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
    @Override
    public void start() {
        checkNotNull(activityView, "ActivityView Is Null");
        checkNotNull(adapterModel, "Adapter Model Is Null");
        checkNotNull(adapterView, "AdapterView Is Null");

        repository.getDefaultCarList(new MainRepository.DefaultCarListCallBack() {
            @Override
            public void defaultCarListLoaded(List<CarInfo> body) {
                changeAdapterList(body);
            }

            @Override
            public void dataNotAvailable() {
                activityView.showEmptyList();
            }
        });
    }

    @Override
    public void showSearchCarList(int modelId) {
        repository.getSearchCarList(modelId, new MainRepository.SearchCarListCallBack() {
            @Override
            public void searchCarListLoaded(List<CarInfo> body) {
                changeAdapterList(body);
            }

            @Override
            public void dataNotAvailable() {

            }
        });
    }

    protected void changeAdapterList(List<CarInfo> body){
        adapterModel.replaceData(body);
        adapterView.notifyAdapter();
    }

    @Override
    public void clickCarItem(int carId) {
        activityView.showCarDetailPage(carId);
    }
}
