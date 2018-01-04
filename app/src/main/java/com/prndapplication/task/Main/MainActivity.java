package com.prndapplication.task.Main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.AbsListView;

import com.prndapplication.R;
import com.prndapplication.task.Main.Data.MainRepositoryImpl;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainContract.ActivityView{

    @BindView(R.id.car_list)
    RecyclerView carList;

    private MainContract.Presenter presenter;
    private MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        presenter = new MainPresenterImpl(new MainRepositoryImpl());
        adapter = new MainAdapter();
        carList.setLayoutManager(new GridLayoutManager(this, 2));
        carList.setAdapter(adapter);
        adapter.setPresenter(presenter);

        presenter.setActivityView(this);
        presenter.setAdapterModel(adapter);
        presenter.setAdapterView(adapter);
        presenter.start();
    }

    @Override
    public void showEmptyList() {

    }
}
