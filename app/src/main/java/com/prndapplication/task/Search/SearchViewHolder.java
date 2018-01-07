package com.prndapplication.task.Search;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.prndapplication.R;
import com.prndapplication.task.Common.BaseRecyclerViewHolder;
import com.prndapplication.task.Search.Data.SearchViewModel;

import butterknife.BindView;

/**
 * Created by KiyoungLee on 2018-01-07.
 */

public class SearchViewHolder extends BaseRecyclerViewHolder<SearchViewModel, SearchContract.Presenter> {

    @BindView(R.id.search_result)
    TextView searchResult;
    @BindView(R.id.search_holder)
    LinearLayout searchHolder;

    public SearchViewHolder(Context context, View itemView) {
        super(context, itemView);
    }

    @Override
    public void bind(SearchViewModel data) {
        super.bind(data);
        searchResult.setText(data.getName());
        searchHolder.setOnClickListener(view -> {
            presenter.clickSearchResult(data.getName(), data.getId());
        });
    }
}
