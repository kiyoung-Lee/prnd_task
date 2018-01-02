package com.prndapplication.task.Main;

import com.prndapplication.task.Common.BasePresenter;
import com.prndapplication.task.Common.BaseView;

/**
 * Created by kiyoungLee on 2018-01-02.
 */

public interface MainContract {

    interface ActivityView extends BaseView<Presenter> {
    }

    interface Presenter extends BasePresenter {

    }
}
