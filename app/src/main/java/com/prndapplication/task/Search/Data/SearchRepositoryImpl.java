package com.prndapplication.task.Search.Data;

import com.prndapplication.task.Common.RetrofitClient;
import com.prndapplication.task.Common.StringApplication;
import com.prndapplication.task.Main.Data.CarInfo;
import com.prndapplication.task.Search.Data.CallBack.GetBrandListCallBack;
import com.prndapplication.task.Search.Data.CallBack.GetCarListCallBack;
import com.prndapplication.task.Search.Data.CallBack.GetModelListCallBack;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by kiyoungLee on 2018-01-02.
 */

public class SearchRepositoryImpl implements SearchRepsitory {

    @Override
    public void getBrandList(BrandListCallBack callBack) {
        if(callBack != null) {
            RetrofitClient<IGetBrandListData> client = new RetrofitClient<>();
            IGetBrandListData loader = client.getClient(IGetBrandListData.class,
                    StringApplication.BASE_URL);
            Call<List<BrandData>> call = loader.getBrandList();

            if (call != null) {
                call.enqueue(new GetBrandListCallBack(callBack));
            }
        }
    }

    @Override
    public void getCarList(int brandId, CarListCallBack callBack) {
        if(callBack != null) {
            RetrofitClient<IGetCarListData> client = new RetrofitClient<>();
            IGetCarListData loader = client.getClient(IGetCarListData.class, StringApplication.BASE_URL);
            Call<List<CarData>> call = loader.getCarList(brandId);

            if (call != null) {
                call.enqueue(new GetCarListCallBack(callBack));
            }
        }
    }

    @Override
    public void getModelList(int modelGroupId, ModelListCallBack callBack) {
        if(callBack != null) {
            RetrofitClient<IGetModelListData> client = new RetrofitClient<>();
            IGetModelListData loader = client.getClient(IGetModelListData.class, StringApplication.BASE_URL);
            Call<List<ModelData>> call = loader.getModelList(modelGroupId);

            if (call != null) {
                call.enqueue(new GetModelListCallBack(callBack));
            }
        }
    }
}

// 브랜드 목록
interface IGetBrandListData {
    @GET("/car_meta/brands/")
    Call<List<BrandData>> getBrandList();
}

// 차종 목록
interface IGetCarListData {
    @GET("/car_meta/brand/{brand_id}")
    Call<List<CarData>> getCarList(@Path("brand_id") int brandId);
}

// 모델 목록
interface IGetModelListData {
    @GET("/car_meta/model_group/{model_group_id}")
    Call<List<ModelData>> getModelList(@Path("model_group_id") int modelGroupId);
}
