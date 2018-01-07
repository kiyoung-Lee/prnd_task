package com.prndapplication.task.Search;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.prndapplication.R;
import com.prndapplication.task.Search.Data.SearchRepositoryImpl;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SearchActivity extends AppCompatActivity implements SearchContract.ActivityView{

    @BindView(R.id.search_list)
    RecyclerView searchList;

    private SearchContract.Presenter presenter;
    private SearchAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);

        presenter = new SearchPresenterImpl(new SearchRepositoryImpl());
        adapter = new SearchAdapter();
        adapter.setPresenter(presenter);
        searchList.setLayoutManager(new LinearLayoutManager(this));
        searchList.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        searchList.setAdapter(adapter);

        presenter.setActivityView(this);
        presenter.setAdapterModel(adapter);
        presenter.setAdapterView(adapter);

        presenter.start();
    }

    @OnClick(R.id.back_button)
    public void clickBackButton(){
        if(presenter.getCurrentType() == SearchPresenterImpl.SearchType.BRAND){
            finish();
        }else{
            presenter.clickBackButton();
        }
    }

    @Override
    public void selectCarModel(int id) {
        Intent returnIntent = new Intent();
        returnIntent.putExtra("searchResult", id);
        setResult(RESULT_OK, returnIntent);
        finish();
    }

}
