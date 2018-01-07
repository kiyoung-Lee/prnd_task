package com.prndapplication.task.DetailPage;

import com.prndapplication.task.DetailPage.Data.CarDetail;
import com.prndapplication.task.DetailPage.Data.DetailRepository;

/**
 * Created by kiyoungLee on 2018-01-02.
 */

public class DetailPresenterImpl implements DetailPageContract.Presenter {

    private DetailRepository repository;
    private DetailPageContract.ActivityView activityView;

    public DetailPresenterImpl(DetailRepository repository) {
        this.repository = repository;
    }

    public void setActivityView(DetailPageContract.ActivityView activityView) {
        this.activityView = activityView;
    }

    public void start(int carId) {
        repository.getCarDetailPage(carId, new DetailRepository.CarDetailCallBack() {
            @Override
            public void carDetailLoaded(CarDetail detail) {
                activityView.showDetailPage(detail);
            }

            @Override
            public void dataNotAvailable() {

            }
        });
    }
}
