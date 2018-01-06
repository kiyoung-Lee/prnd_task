package com.prndapplication.task.Search.Data;

/**
 * Created by kiyoungLee on 2018-01-02.
 */

public interface SearchRepsitory {

    interface BrandListCallBack{

    }

    interface CarListCallBack{

    }

    interface ModelListCallBack{

    }

    void getBrandList(BrandListCallBack callBack);

    void getCarList(int brandId, CarListCallBack callBack);

    void getModelList(int modelGroupId, ModelListCallBack callBack);
}
