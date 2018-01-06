package com.prndapplication.task.Search;

import com.prndapplication.task.Common.BaseAdapter;
import com.prndapplication.task.Common.BasePresenter;
import com.prndapplication.task.Common.BaseView;

/**
 * Created by kiyoungLee on 2018-01-02.
 */

public interface SearchContract {

    interface ActivityView {
    }

    interface Presenter extends BasePresenter {

        void setActivityView(SearchContract.ActivityView activityView);

        void setAdapterModel(BaseAdapter.Model adapterModel);

        void setAdapterView(BaseAdapter.View adapterView);
    }
}
