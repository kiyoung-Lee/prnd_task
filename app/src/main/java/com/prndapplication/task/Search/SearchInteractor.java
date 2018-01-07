package com.prndapplication.task.Search;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.widget.SearchView;

import com.prndapplication.task.Search.Data.BrandData;
import com.prndapplication.task.Search.Data.CarData;
import com.prndapplication.task.Search.Data.ModelData;
import com.prndapplication.task.Search.Data.SearchViewModel;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by KiyoungLee on 2018-01-07.
 */

public class SearchInteractor {

    private List<SearchViewModel> brandViewModelList;
    private List<SearchViewModel> carViewModelList;

    public List<SearchViewModel> getBrandViewModelList() {
        return brandViewModelList;
    }

    public List<SearchViewModel> getCarViewModelList() {
        return carViewModelList;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void generateBrandListViewModel(List<BrandData> brandList){
        brandViewModelList = brandList
                                .stream()
                                .map(brand -> {
                                    SearchViewModel brandModel = new SearchViewModel();
                                    brandModel.setId(brand.getId());
                                    brandModel.setName(brand.getName());
                                    return brandModel;
                                })
                                .collect(Collectors.toList());
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void generateCarListViewModel(CarData carData){
        carViewModelList = carData.getModel_groups()
                                .stream()
                                .map(car -> {
                                    SearchViewModel carModel = new SearchViewModel();
                                    carModel.setId(car.getId());
                                    carModel.setName(car.getName());
                                    return carModel;
                                })
                                .collect(Collectors.toList());
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public List<SearchViewModel> generateModelListViewModel(ModelData modelData){
        return modelData.getModels()
                        .stream()
                        .map(model -> {
                            SearchViewModel viewModel = new SearchViewModel();
                            viewModel.setId(model.getId());
                            viewModel.setName(model.getName());
                            return viewModel;
                        })
                        .collect(Collectors.toList());
    }
}
