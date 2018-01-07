package com.prndapplication.task.Search.Data.CallBack;

import com.prndapplication.task.Search.Data.ModelData;
import com.prndapplication.task.Search.Data.SearchRepsitory;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by KiyoungLee on 2018-01-07.
 */

public class GetModelListCallBack implements Callback<ModelData> {

    private SearchRepsitory.ModelListCallBack callBack;

    public GetModelListCallBack(SearchRepsitory.ModelListCallBack callBack) {
        this.callBack = callBack;
    }

    @Override
    public void onResponse(Call<ModelData> call, Response<ModelData> response) {
        if (response.isSuccessful()) {
            callBack.modelListLoaded(response.body());
        }else{
            callBack.dataNotAvailable();
        }
    }

    @Override
    public void onFailure(Call<ModelData> call, Throwable t) {
        callBack.dataNotAvailable();
    }
}
