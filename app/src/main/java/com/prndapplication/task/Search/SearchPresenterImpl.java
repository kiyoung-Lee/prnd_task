package com.prndapplication.task.Search;

import android.os.Build;
import android.support.annotation.RequiresApi;

import com.prndapplication.task.Common.BaseAdapter;
import com.prndapplication.task.Search.Data.BrandData;
import com.prndapplication.task.Search.Data.CarData;
import com.prndapplication.task.Search.Data.ModelData;
import com.prndapplication.task.Search.Data.SearchRepsitory;
import com.prndapplication.task.Search.Data.SearchViewModel;

import java.util.List;

/**
 * Created by kiyoungLee on 2018-01-02.
 */

public class SearchPresenterImpl implements SearchContract.Presenter {

    private SearchRepsitory repsitory;
    private SearchContract.ActivityView activityView;
    private BaseAdapter.Model adapterModel;
    private BaseAdapter.View adapterView;
    private SearchInteractor interactor;
    private SearchType currentType;

    public enum SearchType {
        BRAND,
        CAR,
        MODEL
    }

    public SearchPresenterImpl(SearchRepsitory repsitory) {
        this.repsitory = repsitory;
        interactor = new SearchInteractor();
    }

    public void setActivityView(SearchContract.ActivityView activityView) {
        this.activityView = activityView;
    }

    public void setAdapterModel(BaseAdapter.Model adapterModel) {
        this.adapterModel = adapterModel;
    }

    public void setAdapterView(BaseAdapter.View adapterView) {
        this.adapterView = adapterView;
    }

    public SearchType getCurrentType() {
        return currentType;
    }

    @Override
    public void start() {
        currentType = SearchType.BRAND;
        getBrandList();
    }

    private void getBrandList(){
        repsitory.getBrandList(new SearchRepsitory.BrandListCallBack() {
            @Override
            public void brandListLoaded(List<BrandData> brandList) {
                brandListLoadedSuccess(brandList);
            }

            @Override
            public void dataNotAvailable() {
                activityView.showEmptyList();
            }
        });
    }

    private void brandListLoadedSuccess(List<BrandData> brandList){
        activityView.showSearchList();
        interactor.generateBrandListViewModel(brandList);
        setBrandList();
        setTitle("브랜드 선택");
    }

    @Override
    public void clickBackButton() {
        if(currentType == SearchType.CAR){
            setBrandList();
        }else if(currentType == SearchType.MODEL){
            setCarList();
        }
    }

    @Override
    public void clickSearchResult(String name, int id) {
        if(currentType == SearchType.BRAND){
            getCarList(id);
        }else if (currentType == SearchType.CAR){
            getModelList(id);
        }else if (currentType == SearchType.MODEL){
            activityView.selectCarModel(name, id);
        }
    }

    private void getCarList(int id){
        repsitory.getCarList(id, new SearchRepsitory.CarListCallBack() {
            @Override
            public void carListLoaded(CarData carData) {
                carListLoadSuccess(carData);
            }

            @Override
            public void dataNotAvailable() {
                activityView.showEmptyList();
            }
        });
    }

    private void carListLoadSuccess(CarData carData){
        activityView.showSearchList();
        interactor.generateCarListViewModel(carData);
        setCarList();
        currentType = SearchType.CAR;
        setTitle("차종 선택");
    }

    private void getModelList(int id){
        repsitory.getModelList(id, new SearchRepsitory.ModelListCallBack() {
            @Override
            public void modelListLoaded(ModelData modelData) {
                modelListLoadSuccess(modelData);
            }

            @Override
            public void dataNotAvailable() {
                activityView.showEmptyList();
            }
        });
    }

    private void modelListLoadSuccess(ModelData modelData){
        activityView.showSearchList();
        List<SearchViewModel> modelList = interactor.generateModelListViewModel(modelData);
        changeAdapterList(modelList);
        currentType = SearchType.MODEL;
        setTitle("모델 선택");
    }

    private void setBrandList(){
        List<SearchViewModel> brandSearchModel = interactor.getBrandViewModelList();
        changeAdapterList(brandSearchModel);
        currentType = SearchType.BRAND;
    }

    private void setCarList(){
        List<SearchViewModel> carSearchModel = interactor.getCarViewModelList();
        changeAdapterList(carSearchModel);
        currentType = SearchType.CAR;
    }

    private void changeAdapterList(List<SearchViewModel> carSearchModel){
        adapterModel.replaceData(carSearchModel);
        adapterView.notifyAdapter();
    }

    private void setTitle(String title){
        activityView.setTitle(title);
    }
}
