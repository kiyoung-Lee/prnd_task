package com.prndapplication.task.DetailPage.Data;

import com.prndapplication.task.Common.RetrofitClient;
import com.prndapplication.task.Common.StringApplication;
import com.prndapplication.task.DetailPage.Data.CallBack.GetCarDetailPageCallBack;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by kiyoungLee on 2018-01-02.
 */

public class DetailPageRepositoryImpl implements DetailRepository {

    @Override
    public void getCarDetailPage(int carId, CarDetailCallBack callBack) {
        if(callBack != null) {
            RetrofitClient<IGetCarDetail> client = new RetrofitClient<>();
            IGetCarDetail loader = client.getClient(IGetCarDetail.class,
                    StringApplication.BASE_URL);
            Call<CarDetail> call = loader.getCarDetail(carId);

            if (call != null) {
                call.enqueue(new GetCarDetailPageCallBack(callBack));
            }
        }
    }
}

interface IGetCarDetail {
    @GET("/cars/{car_id}")
    Call<CarDetail> getCarDetail(@Path("car_id") int carId);
}
