package com.prndapplication.task.Search;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.prndapplication.R;
import com.prndapplication.task.Search.Data.SearchRepositoryImpl;

public class SearchActivity extends AppCompatActivity {

    private SearchContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        presenter = new SearchPresenterImpl(new SearchRepositoryImpl());
    }
}
