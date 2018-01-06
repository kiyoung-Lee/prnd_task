package com.prndapplication.task.Search;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.prndapplication.R;
import com.prndapplication.task.Common.BaseAdapter;
import com.prndapplication.task.Common.BaseRecyclerViewHolder;
import com.prndapplication.task.Search.Data.SearchViewModel;

import java.util.List;

/**
 * Created by KiyoungLee on 2018-01-07.
 */

public class SearchAdapter extends RecyclerView.Adapter<BaseRecyclerViewHolder>
                            implements BaseAdapter.Model<List<SearchViewModel>>, BaseAdapter.View<SearchContract.Presenter>{


    private SearchContract.Presenter presenter;
    private List<SearchViewModel> searchList;

    @Override
    public void replaceData(List<SearchViewModel> data) {
        this.searchList = data;
    }

    @Override
    public void setPresenter(SearchContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void notifyAdapter() {
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if(searchList != null){
            return searchList.size();
        }
        return 0;
    }

    @Override
    public BaseRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int resId = R.layout.search_view_holder;
        View view = LayoutInflater.from(parent.getContext()).inflate(resId, parent, false);
        BaseRecyclerViewHolder viewHolder = new SearchViewHolder(parent.getContext(), view);
        viewHolder.setPresenter(presenter);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(BaseRecyclerViewHolder holder, int position) {
        holder.bind(searchList.get(position));
    }


}
