package com.prndapplication.task.Main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.prndapplication.R;
import com.prndapplication.task.Common.BaseAdapter;
import com.prndapplication.task.Common.BasePresenter;
import com.prndapplication.task.Common.BaseRecyclerViewHolder;
import com.prndapplication.task.Main.Data.CarInfo;

import java.util.List;

/**
 * Created by kiyoungLee on 2018-01-04.
 */

public class MainAdapter extends RecyclerView.Adapter<BaseRecyclerViewHolder>
                            implements BaseAdapter.Model<List<CarInfo>>, BaseAdapter.View<MainContract.Presenter> {

    private MainContract.Presenter presenter;
    private List<CarInfo> carList;

    @Override
    public int getItemCount() {
        if(carList != null){
            return carList.size();
        }
        return 0;
    }

    @Override
    public void replaceData(List<CarInfo> data) {
        this.carList = data;
    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void notifyAdapter() {
        notifyDataSetChanged();
    }

    @Override
    public BaseRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int resId = R.layout.main_view_holder;
        View view = LayoutInflater.from(parent.getContext()).inflate(resId, parent, false);
        BaseRecyclerViewHolder viewHolder = new MainViewHolder(parent.getContext(), view);
        viewHolder.setPresenter(presenter);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(BaseRecyclerViewHolder holder, int position) {
        holder.bind(carList.get(position));
    }
}
