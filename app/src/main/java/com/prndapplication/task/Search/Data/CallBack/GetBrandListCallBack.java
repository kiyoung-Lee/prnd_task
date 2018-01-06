package com.prndapplication.task.Search.Data.CallBack;

import com.prndapplication.task.Search.Data.BrandData;
import com.prndapplication.task.Search.Data.SearchRepsitory;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by KiyoungLee on 2018-01-07.
 */

public class GetBrandListCallBack implements Callback<List<BrandData>> {

    private SearchRepsitory.BrandListCallBack callBack;

    public GetBrandListCallBack(SearchRepsitory.BrandListCallBack callBack) {
        this.callBack = callBack;
    }

    @Override
    public void onResponse(Call<List<BrandData>> call, Response<List<BrandData>> response) {

    }

    @Override
    public void onFailure(Call<List<BrandData>> call, Throwable t) {

    }
}
