package com.prndapplication.task.Search;

import com.prndapplication.task.Search.Data.SearchRepsitory;

/**
 * Created by kiyoungLee on 2018-01-02.
 */

public class SearchPresenterImpl implements SearchContract.Presenter {

    private SearchRepsitory repsitory;
    private SearchContract.ActivityView activityView;

    public SearchPresenterImpl(SearchRepsitory repsitory) {
        this.repsitory = repsitory;
    }

    public void setActivityView(SearchContract.ActivityView activityView) {
        this.activityView = activityView;
    }

    @Override
    public void start() {

    }
}
