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
import java.util.stream.Stream;

import static solid.collectors.ToList.toList;
import static solid.stream.Stream.stream;

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

    public void generateBrandListViewModel(List<BrandData> brandList){
        brandViewModelList = stream(brandList)
                                .map(brand -> {
                                    SearchViewModel brandModel = new SearchViewModel();
                                    brandModel.setId(brand.getId());
                                    brandModel.setName(brand.getName());
                                    return brandModel;
                                })
                                .collect(toList());
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void generateCarListViewModel(CarData carData){
        carViewModelList = stream(carData.getModel_groups())
                                .map(car -> {
                                    SearchViewModel carModel = new SearchViewModel();
                                    carModel.setId(car.getId());
                                    carModel.setName(car.getName());
                                    return carModel;
                                })
                                .collect(toList());
    }

    public List<SearchViewModel> generateModelListViewModel(ModelData modelData){
        return stream(modelData.getModels())
                        .map(model -> {
                            SearchViewModel viewModel = new SearchViewModel();
                            viewModel.setId(model.getId());
                            viewModel.setName(model.getName());
                            return viewModel;
                        })
                        .collect(toList());
    }
}
