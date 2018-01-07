package com.prndapplication.task.DetailPage;

import com.prndapplication.task.Common.BasePresenter;
import com.prndapplication.task.Common.BaseView;
import com.prndapplication.task.DetailPage.Data.CarDetail;

/**
 * Created by kiyoungLee on 2018-01-02.
 */

public interface DetailPageContract {

    interface ActivityView  {
        void showDetailPage(CarDetail detail);
    }

    interface Presenter  {

        void setActivityView(DetailPageContract.ActivityView activityView);

        void start(int carId);
    }
}
