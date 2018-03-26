package com.example.cobe.carapp.ui.details;

import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.cobe.carapp.R;
import com.example.cobe.carapp.common.data.DataHolder;

import java.util.List;

/**
 * Created by cobe on 26/03/2018.
 */

public class ImageAdapter extends PagerAdapter {

    private List<String> imagesURL = DataHolder.getInstance().getCarImagesURL();

    @Override
    public int getCount() {
        return imagesURL.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(container.getContext());
        View view = inflater.inflate(R.layout.images_pager_item, container, false);

        ImageView imageView = view.findViewById(R.id.ivCarImages);
        Glide.with(imageView.getContext()).load(imagesURL.get(position)).into(imageView);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
