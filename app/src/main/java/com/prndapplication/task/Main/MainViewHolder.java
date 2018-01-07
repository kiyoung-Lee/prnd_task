package com.prndapplication.task.Main;

import android.content.Context;
import android.support.v4.media.VolumeProviderCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.prndapplication.R;
import com.prndapplication.task.Common.BaseRecyclerViewHolder;
import com.prndapplication.task.Main.Data.CarInfo;

import butterknife.BindView;

/**
 * Created by kiyoungLee on 2018-01-04.
 */

public class MainViewHolder extends BaseRecyclerViewHolder<CarInfo, MainContract.Presenter>{

    @BindView(R.id.holder_layout)
    LinearLayout holderLayout;
    @BindView(R.id.car_image)
    ImageView carImage;
    @BindView(R.id.car_name)
    TextView carName;
    @BindView(R.id.car_grade)
    TextView carGrade;
    @BindView(R.id.car_year)
    TextView carYear;
    @BindView(R.id.sale_status)
    TextView saleStatus;
    @BindView(R.id.sale_status_layout)
    LinearLayout saleStatusLayout;

    public MainViewHolder(Context context, View itemView) {
        super(context, itemView);
    }

    @Override
    public void bind(CarInfo data) {
        super.bind(data);

        saleStatus.setText(data.getStatus_display());
        Glide
            .with(context)
            .load(data.getMain_image_url())
            .into(carImage);
        carName.setText(data.getModel_part_name());
        carGrade.setText(data.getGrade_part_name());
        carYear.setText(getOptionInfo(data));

        String[] splitUrl = data.getAbsolute_url().split("/");
        int carId = Integer.valueOf(splitUrl[4]);
        holderLayout.setOnClickListener(view -> {
            presenter.clickCarItem(carId);
        });
    }

    private String getOptionInfo(CarInfo data){
        StringBuilder builder = new StringBuilder();
        builder.append(data.getYear());
        builder.append("·");
        builder.append(data.getMileage());
        builder.append("·");
        builder.append(data.getPrice());
        return builder.toString();
    }
}
