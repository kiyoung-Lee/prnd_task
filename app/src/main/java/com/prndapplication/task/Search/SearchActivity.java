package com.prndapplication.task.Search;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.prndapplication.R;
import com.prndapplication.task.Search.Data.SearchRepositoryImpl;

import butterknife.BindView;

public class SearchActivity extends AppCompatActivity implements SearchContract.ActivityView{

    @BindView(R.id.search_list)
    RecyclerView searchList;

    private SearchContract.Presenter presenter;
    private SearchAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        presenter = new SearchPresenterImpl(new SearchRepositoryImpl());
        adapter = new SearchAdapter();
        adapter.setPresenter(presenter);
        searchList.setLayoutManager(new LinearLayoutManager(this));
        searchList.setAdapter(adapter);

        presenter.setActivityView(this);
        presenter.setAdapterModel(adapter);
        presenter.setAdapterView(adapter);

        presenter.start();
    }

}
