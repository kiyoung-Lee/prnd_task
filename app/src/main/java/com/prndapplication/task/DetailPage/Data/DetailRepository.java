package com.prndapplication.task.DetailPage.Data;

/**
 * Created by kiyoungLee on 2018-01-02.
 */

public interface DetailRepository {

    interface CarDetailCallBack{
        void carDetailLoaded(CarDetail detail);

        void dataNotAvailable();
    }

    void getCarDetailPage(int carId, CarDetailCallBack callBack);
}
