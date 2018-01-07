package com.prndapplication.task.Search.Data;

import java.util.List;

/**
 * Created by kiyoungLee on 2018-01-02.
 */

public interface SearchRepsitory {

    interface BrandListCallBack{
        void brandListLoaded(List<BrandData> brandList);

        void dataNotAvailable();
    }

    interface CarListCallBack{
        void carListLoaded(CarData carData);

        void dataNotAvailable();
    }

    interface ModelListCallBack{
        void modelListLoaded(ModelData modelData);

        void dataNotAvailable();
    }

    void getBrandList(BrandListCallBack callBack);

    void getCarList(int brandId, CarListCallBack callBack);

    void getModelList(int modelGroupId, ModelListCallBack callBack);
}
