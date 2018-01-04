package com.prndapplication.task.Main.Data.CallBack;

import com.prndapplication.task.Main.Data.CarInfo;
import com.prndapplication.task.Main.Data.MainRepository;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by kiyoungLee on 2018-01-04.
 */

public class GetDefaultCarListCallBack implements Callback<List<CarInfo>> {

    private MainRepository.DefaultCarListCallBack callBack;

    public GetDefaultCarListCallBack(MainRepository.DefaultCarListCallBack callBack) {
        this.callBack = callBack;
    }

    @Override
    public void onResponse(Call<List<CarInfo>> call, Response<List<CarInfo>> response) {
        if (response.isSuccessful()) {
            callBack.defaultCarListLoaded(response.body());
        }else{
            callBack.dataNotAvailable();
        }
    }

    @Override
    public void onFailure(Call<List<CarInfo>> call, Throwable t) {
        callBack.dataNotAvailable();
    }
}
