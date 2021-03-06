package com.prndapplication.task.Common;

/**
 * Created by kiyoung Lee on 2017-06-19.
 */

public interface BaseAdapter {

    interface Model<T> {
        void replaceData(T data);
    }

    interface View<T> {
        void setPresenter(T presenter);

        void notifyAdapter();
    }
}
