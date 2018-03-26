package com.example.cobe.carapp.ui.main;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cobe.carapp.R;
import com.example.cobe.carapp.common.data.DataHolder;
import com.example.cobe.carapp.model.Car;
import com.example.cobe.carapp.ui.details.CarDetailsActivity;
import com.example.cobe.carapp.ui.listeners.OnCarClickListener;

import java.util.List;

/**
 * Created by Tomislav on 25.3.2018..
 */

public class CarViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    ImageView imageView;
    TextView carModel;
    TextView carAge;
    private List<Car> cars = DataHolder.getInstance().getCars();
    private OnCarClickListener onCarClickListener;

    public CarViewHolder(View itemView, OnCarClickListener onCarClickListener) {
        super(itemView);
        imageView = itemView.findViewById(R.id.ivCarImage);
        carModel = itemView.findViewById(R.id.tvCarModel);
        carAge = itemView.findViewById(R.id.tvCarAge);
        this.onCarClickListener = onCarClickListener;
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (onCarClickListener != null) {
            setImagesURL(cars.get(getAdapterPosition()).getId());

            onCarClickListener.onCarClick(cars.get(getAdapterPosition()).getId());

        }
    }

    public void setImagesURL(int id) {
        Car car = DataHolder.getInstance().returnCarBasedOnCarID(id);
        DataHolder.getInstance().setCarImages(car);
    }
}