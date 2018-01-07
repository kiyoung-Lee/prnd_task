package com.prndapplication.task.Main;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.prndapplication.R;
import com.prndapplication.task.DetailPage.DetailPageActivity;
import com.prndapplication.task.Main.Data.MainRepositoryImpl;
import com.prndapplication.task.Search.SearchActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainContract.ActivityView{

    @BindView(R.id.car_list)
    RecyclerView carList;
    @BindView(R.id.swipeContainer)
    SwipeRefreshLayout swipeContainer;
    @BindView(R.id.search_name)
    TextView searchName;
    @BindView(R.id.noItem_view)
    LinearLayout noItemView;

    private MainContract.Presenter presenter;
    private MainAdapter adapter;
    private GridLayoutManager layoutManager;
    private int searchModelId;
    private final int REQUEST_CODE = 1;
    private int lastScrolPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        presenter = new MainPresenterImpl(new MainRepositoryImpl());
        adapter = new MainAdapter();
        layoutManager = new GridLayoutManager(this, 2);
        carList.setLayoutManager(layoutManager);
        carList.setAdapter(adapter);
        carList.addOnScrollListener(scrollListener);
        adapter.setPresenter(presenter);

        presenter.setActivityView(this);
        presenter.setAdapterModel(adapter);
        presenter.setAdapterView(adapter);

        initView();
        presenter.start(1);
    }

    private void initView(){
        swipeContainer.setOnRefreshListener(() -> {
            swipeContainer.setRefreshing(false);
            resetMainVIew();
        });
    }

    @Override
    public void showEmptyList() {
        swipeContainer.setVisibility(View.GONE);
        noItemView.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.btn_refresh)
    public void clickRefresh(){
        showCarList();
        resetMainVIew();
    }

    private void showCarList(){
        swipeContainer.setVisibility(View.VISIBLE);
        noItemView.setVisibility(View.GONE);
    }

    private void resetMainVIew(){
        presenter.start(1);
        lastScrolPos = 0;
        searchModelId = 0;
        setSearchName("차종검색");
    }

    RecyclerView.OnScrollListener scrollListener = new RecyclerView.OnScrollListener(){
        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            // 스크롤 갱신
            int lastVisibleItem = layoutManager.findLastVisibleItemPosition();
            int itemCount = adapter.getItemCount();
            if(itemCount >= 20) {
                if ((itemCount - 5) == lastVisibleItem && lastScrolPos < lastVisibleItem) {
                    lastScrolPos = lastVisibleItem;
                    int pageCnt = (lastVisibleItem / 20) + 2;

                    if(searchModelId == 0) {
                        presenter.start(pageCnt);
                    }else{
                        presenter.showSearchCarList(pageCnt, searchModelId);
                    }
                }
            }
        }
    };

    @OnClick(R.id.search_layout)
    public void clickSearch(){
        Intent intent = new Intent(this, SearchActivity.class);
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE){
            if(resultCode == RESULT_OK){
                lastScrolPos = 0;
                carList.scrollToPosition(0);

                String searchName = data.getStringExtra("searchName");
                setSearchName(searchName);
                showCarList();
                searchModelId = data.getIntExtra("searchResult", 0);
                presenter.showSearchCarList(1, searchModelId);
            }
        }
    }

    @Override
    public void showCarDetailPage(int carId) {
        Intent intent = new Intent(this, DetailPageActivity.class);
        intent.putExtra("carId", carId);
        startActivity(intent);
    }

    private void setSearchName(String name){
        searchName.setText(name);
    }
}
