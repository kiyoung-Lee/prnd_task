package com.prndapplication.task.Search;

import com.prndapplication.task.Common.BaseAdapter;
import com.prndapplication.task.Search.Data.SearchRepsitory;

/**
 * Created by kiyoungLee on 2018-01-02.
 */

public class SearchPresenterImpl implements SearchContract.Presenter {

    private SearchRepsitory repsitory;
    private SearchContract.ActivityView activityView;
    private BaseAdapter.Model adapterModel;
    private BaseAdapter.View adapterView;

    public SearchPresenterImpl(SearchRepsitory repsitory) {
        this.repsitory = repsitory;
    }

    public void setActivityView(SearchContract.ActivityView activityView) {
        this.activityView = activityView;
    }

    public void setAdapterModel(BaseAdapter.Model adapterModel) {
        this.adapterModel = adapterModel;
    }

    public void setAdapterView(BaseAdapter.View adapterView) {
        this.adapterView = adapterView;
    }

    @Override
    public void start() {

    }
}
