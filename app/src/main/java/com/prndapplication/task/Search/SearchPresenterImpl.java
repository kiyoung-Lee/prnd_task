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
        repsitory.getBrandList(new SearchRepsitory.BrandListCallBack() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void brandListLoaded(List<BrandData> brandList) {
                interactor.generateBrandListViewModel(brandList);
                setBrandList();
            }

            @Override
            public void dataNotAvailable() {

            }
        });
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
    public void clickSearchResult(int id) {
        if(currentType == SearchType.BRAND){
            repsitory.getCarList(id, new SearchRepsitory.CarListCallBack() {
                @RequiresApi(api = Build.VERSION_CODES.N)
                @Override
                public void carListLoaded(CarData carData) {
                    interactor.generateCarListViewModel(carData);
                    setCarList();
                    currentType = SearchType.CAR;
                }

                @Override
                public void dataNotAvailable() {

                }
            });
        }else if (currentType == SearchType.CAR){
            repsitory.getModelList(id, new SearchRepsitory.ModelListCallBack() {
                @RequiresApi(api = Build.VERSION_CODES.N)
                @Override
                public void modelListLoaded(ModelData modelData) {
                    List<SearchViewModel> modelList = interactor.generateModelListViewModel(modelData);
                    changeAdapterList(modelList);
                    currentType = SearchType.MODEL;
                }

                @Override
                public void dataNotAvailable() {

                }
            });
        }else if (currentType == SearchType.MODEL){
            activityView.selectCarModel(id);
        }
    }

    protected void setBrandList(){
        List<SearchViewModel> brandSearchModel = interactor.getBrandViewModelList();
        changeAdapterList(brandSearchModel);
        currentType = SearchType.BRAND;
    }

    protected void setCarList(){
        List<SearchViewModel> carSearchModel = interactor.getCarViewModelList();
        changeAdapterList(carSearchModel);
        currentType = SearchType.CAR;
    }

    protected void changeAdapterList(List<SearchViewModel> carSearchModel){
        adapterModel.replaceData(carSearchModel);
        adapterView.notifyAdapter();
    }
}
