package com.prndapplication.task.Search.Data.CallBack;

import com.prndapplication.task.Search.Data.CarData;
import com.prndapplication.task.Search.Data.SearchRepsitory;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by KiyoungLee on 2018-01-07.
 */

public class GetCarListCallBack implements Callback<List<CarData>> {

    private SearchRepsitory.CarListCallBack callBack;

    public GetCarListCallBack(SearchRepsitory.CarListCallBack callBack) {
        this.callBack = callBack;
    }

    @Override
    public void onResponse(Call<List<CarData>> call, Response<List<CarData>> response) {

    }

    @Override
    public void onFailure(Call<List<CarData>> call, Throwable t) {

    }
}
