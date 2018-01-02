package com.prndapplication.task.Main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.prndapplication.R;
import com.prndapplication.task.Main.Data.MainRepositoryImpl;

public class MainActivity extends AppCompatActivity {

    private MainContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenterImpl(new MainRepositoryImpl());
    }
}
