package com.prndapplication.task.Main.Data;

import com.prndapplication.task.Common.RetrofitClient;
import com.prndapplication.task.Common.StringApplication;
import com.prndapplication.task.Main.Data.CallBack.GetDefaultCarListCallBack;
import com.prndapplication.task.Main.Data.CallBack.GetSearchCarListCallBack;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by kiyoungLee on 2018-01-02.
 */

public class MainRepositoryImpl implements MainRepository{

    @Override
    public void getDefaultCarList(DefaultCarListCallBack callBack) {
        if(callBack != null) {
            RetrofitClient<IGetDefaultCarListData> client = new RetrofitClient<>();
            IGetDefaultCarListData loader = client.getClient(IGetDefaultCarListData.class, StringApplication.BASE_URL);
            Call<List<CarInfo>> call = loader.getDefaultCarList();

            if (call != null) {
                call.enqueue(new GetDefaultCarListCallBack(callBack));
            }
        }
    }

    @Override
    public void getSearchCarList(int modelId, SearchCarListCallBack callBack) {
        if(callBack != null) {
            RetrofitClient<IGetSearchCarListData> client = new RetrofitClient<>();
            IGetSearchCarListData loader = client.getClient(IGetSearchCarListData.class, StringApplication.BASE_URL);
            Call<List<CarInfo>> call = loader.getSearchCarList(modelId);

            if (call != null) {
                call.enqueue(new GetSearchCarListCallBack(callBack));
            }
        }
    }
}

interface IGetDefaultCarListData {
    @GET("/cars/")
    Call<List<CarInfo>> getDefaultCarList();
}

interface IGetSearchCarListData {
    @GET("/cars/?model={model_id}")
    Call<List<CarInfo>> getSearchCarList(@Path("model_id") int modelId);
}