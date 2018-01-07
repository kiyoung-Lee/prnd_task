package com.prndapplication.task.DetailPage;

import static com.prndapplication.task.Util.Layout.getFormattedPrice;

import android.annotation.SuppressLint;
import android.graphics.Paint;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;

import com.prndapplication.R;
import com.prndapplication.task.DetailPage.Data.CarDetail;
import com.prndapplication.task.DetailPage.Data.DetailPageRepositoryImpl;
import com.prndapplication.task.Util.Layout;
import com.rd.PageIndicatorView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailPageActivity extends AppCompatActivity implements DetailPageContract.ActivityView{

    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.viewPager)
    ViewPager detailImageViewPager;
    @BindView(R.id.pageIndicatorView)
    PageIndicatorView pageIndicator;
    @BindView(R.id.origin_price)
    TextView originPrice;
    @BindView(R.id.sale_price)
    TextView salePrice;
    @BindView(R.id.sale_status)
    TextView saleStatus;
    @BindView(R.id.car_num)
    TextView carNum;
    @BindView(R.id.drive_distance)
    TextView driveDistance;
    @BindView(R.id.regist_year)
    TextView registYear;
    @BindView(R.id.car_year)
    TextView carYear;
    @BindView(R.id.gas_type)
    TextView gasType;
    @BindView(R.id.btn_call)
    TextView buttonCall;

    private DetailPageContract.Presenter presenter;
    private DetailViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_page);
        ButterKnife.bind(this);

        viewPagerAdapter = new DetailViewPagerAdapter(this, getLayoutInflater());
        presenter = new DetailPresenterImpl(new DetailPageRepositoryImpl());
        presenter.setActivityView(this);

        int carId = getIntent().getIntExtra("carId", 0);
        presenter.start(carId);
    }

    @OnClick(R.id.back_button)
    public void clickBackButton(){
        finish();
    }

    @Override
    public void showDetailPage(CarDetail detail) {
        title.setText(detail.getFull_name());
        setViewPagerImage(detail);
        setPriceView(detail);
        setSaleStatus(detail);

        carNum.setText(detail.getCar_number());
        driveDistance.setText(String.valueOf(detail.getMileage()));
        carYear.setText(String.valueOf(detail.getYear()) + "년");
        gasType.setText(detail.getFuel());
    }

    private void setViewPagerImage(CarDetail detail){
        viewPagerAdapter.setImageData(detail.getImage_urls());
        detailImageViewPager.setAdapter(viewPagerAdapter);
        viewPagerAdapter.notifyDataSetChanged();

        pageIndicator.setViewPager(detailImageViewPager);
        pageIndicator.setRadius(Layout.dpToPixel(getApplicationContext(), 1));
        pageIndicator.setSelectedColor(getResources().getColor(R.color.white_00));
    }

    @SuppressLint("ResourceAsColor")
    private void setPriceView(CarDetail detail){
        originPrice.setText(getFormattedPrice(detail.getPrice()));
        salePrice.setText(getFormattedPrice(detail.getDiscounted_price()));

        if(detail.getDiscounted_price() == 0){
            originPrice.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);
            salePrice.setVisibility(View.INVISIBLE);
        }else{
            originPrice.setPaintFlags(originPrice.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);
            originPrice.setTextColor(ContextCompat.getColor(this, R.color.transBlack));
        }
    }

    private void setSaleStatus(CarDetail detail){
        String saleStatusText = detail.getStatus_display();
        saleStatus.setText(saleStatusText);

        switch (saleStatusText){
            case "판매중":
                saleStatus.setTextColor(ContextCompat.getColor(this, R.color.cornflowerblue));
                buttonCall.setBackgroundColor(ContextCompat.getColor(this, R.color.cornflowerblue));
                break;
            case "세일중":
                saleStatus.setTextColor(ContextCompat.getColor(this, R.color.mediumseagreen));
                buttonCall.setBackgroundColor(ContextCompat.getColor(this, R.color.mediumseagreen));
                break;

            case "판매완료":
                saleStatus.setTextColor(ContextCompat.getColor(this, R.color.transBlack));
                buttonCall.setBackgroundColor(ContextCompat.getColor(this, R.color.transBlack));
                originPrice.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);
                originPrice.setTextColor(ContextCompat.getColor(this, R.color.transBlack));
                salePrice.setVisibility(View.INVISIBLE);
                break;
        }
    }
}
