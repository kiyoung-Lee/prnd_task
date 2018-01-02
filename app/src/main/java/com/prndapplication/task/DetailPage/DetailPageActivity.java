package com.prndapplication.task.DetailPage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.prndapplication.R;
import com.prndapplication.task.DetailPage.Data.DetailPageRepositoryImpl;

public class DetailPageActivity extends AppCompatActivity {


    private DetailPageContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_page);

        presenter = new DetailPresenterImpl(new DetailPageRepositoryImpl());
    }
}
