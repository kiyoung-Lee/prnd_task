package com.prndapplication.task.DetailPage;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.prndapplication.R;

import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by KiyoungLee on 2018-01-07.
 */

public class DetailViewPagerAdapter extends PagerAdapter{

    private Context context;
    private LayoutInflater inflater;
    private List<String> imageList;

    public DetailViewPagerAdapter(Context context, LayoutInflater inflater) {
        this.context = context;
        this.inflater = inflater;
    }

    @Override
    public int getCount() {
        if(imageList != null) {
            return imageList.size();
        }
        return 0;
    }

    public void setImageData(List<String> imageList) {
        this.imageList = imageList;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = null;
        view = inflater.inflate(R.layout.detail_image_childview, null);
        ImageView iv_tip_image = ButterKnife.findById(view, R.id.iv_image);
        for (int i = 0; i < imageList.size(); i++) {
            Glide.with(context).load(imageList.get(position)).into(iv_tip_image);
        }
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View v, Object obj) {
        return v == obj;
    }

}
