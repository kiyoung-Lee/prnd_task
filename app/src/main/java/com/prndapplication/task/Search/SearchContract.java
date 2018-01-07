package com.prndapplication.task.Search;

import com.prndapplication.task.Common.BaseAdapter;
import com.prndapplication.task.Common.BasePresenter;

/**
 * Created by kiyoungLee on 2018-01-02.
 */

public interface SearchContract {

    interface ActivityView {
        void selectCarModel(String name, int id);

        void setTitle(String title);

        void showEmptyList();

        void showSearchList();
    }

    interface Presenter extends BasePresenter {

        void setActivityView(SearchContract.ActivityView activityView);

        void setAdapterModel(BaseAdapter.Model adapterModel);

        void setAdapterView(BaseAdapter.View adapterView);

        SearchPresenterImpl.SearchType getCurrentType();

        void clickSearchResult(String name, int id);

        void clickBackButton();
    }
}
