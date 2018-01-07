package com.prndapplication.task.Main;

import com.prndapplication.task.Common.BaseAdapter;
import com.prndapplication.task.Common.BasePresenter;
import com.prndapplication.task.Common.BaseView;

/**
 * Created by kiyoungLee on 2018-01-02.
 */

public interface MainContract {

    interface ActivityView  {

        void showEmptyList();

        void showCarDetailPage(int carId);
    }

    interface Presenter extends BasePresenter {

        void setActivityView(MainContract.ActivityView activityView);

        void setAdapterModel(BaseAdapter.Model adapterModel);

        void setAdapterView(BaseAdapter.View adapterView);

        void showSearchCarList(int modelId);

        void clickCarItem(int carId);
    }
}
