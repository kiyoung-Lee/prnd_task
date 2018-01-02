package com.prndapplication.task.Main;

import com.prndapplication.task.Main.Data.MainRepository;

/**
 * Created by kiyoungLee on 2018-01-02.
 */

public class MainPresenterImpl implements MainContract.Presenter{

    private MainRepository repository;
    private MainContract.ActivityView activityView;

    public MainPresenterImpl(MainRepository repository) {
        this.repository = repository;
    }

    public void setActivityView(MainContract.ActivityView activityView) {
        this.activityView = activityView;
    }

    @Override
    public void start() {

    }
}
