package com.prndapplication.task.Main.Data;

import java.util.List;

/**
 * Created by kiyoungLee on 2018-01-02.
 */

public interface MainRepository {

    interface DefaultCarListCallBack{
        void defaultCarListLoaded(List<CarInfo> body);

        void dataNotAvailable();
    }

    interface SearchCarListCallBack{
        void searchCarListLoaded(List<CarInfo> body);

        void dataNotAvailable();
    }

    void getDefaultCarList(int page, DefaultCarListCallBack callBack);

    void getSearchCarList(int page, int modelId, SearchCarListCallBack callBack);
}
