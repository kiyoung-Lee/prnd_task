package com.prndapplication.task.DetailPage.Data.CallBack;

import com.prndapplication.task.DetailPage.Data.CarDetail;
import com.prndapplication.task.DetailPage.Data.DetailRepository;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by KiyoungLee on 2018-01-07.
 */

public class GetCarDetailPageCallBack implements Callback<CarDetail> {

    private DetailRepository.CarDetailCallBack callBack;

    public GetCarDetailPageCallBack(DetailRepository.CarDetailCallBack callBack) {
        this.callBack = callBack;
    }

    @Override
    public void onResponse(Call<CarDetail> call, Response<CarDetail> response) {
        if (response.isSuccessful()) {
            callBack.carDetailLoaded(response.body());
        }else{
            callBack.dataNotAvailable();
        }
    }

    @Override
    public void onFailure(Call<CarDetail> call, Throwable t) {

    }
}
