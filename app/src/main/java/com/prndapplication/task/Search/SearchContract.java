package com.prndapplication.task.Search;

import com.prndapplication.task.Common.BaseAdapter;
import com.prndapplication.task.Common.BasePresenter;
import com.prndapplication.task.Common.BaseView;

/**
 * Created by kiyoungLee on 2018-01-02.
 */

public interface SearchContract {

    interface ActivityView {
        void selectCarModel(int id);
    }

    interface Presenter extends BasePresenter {

        void setActivityView(SearchContract.ActivityView activityView);

        void setAdapterModel(BaseAdapter.Model adapterModel);

        void setAdapterView(BaseAdapter.View adapterView);

        SearchPresenterImpl.SearchType getCurrentType();

        void clickSearchResult(int id);

        void clickBackButton();
    }
}
