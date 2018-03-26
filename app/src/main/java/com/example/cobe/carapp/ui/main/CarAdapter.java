package com.example.cobe.carapp.ui.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.cobe.carapp.R;
import com.example.cobe.carapp.common.data.DataHolder;
import com.example.cobe.carapp.model.Car;
import com.example.cobe.carapp.ui.listeners.OnCarClickListener;

import java.util.List;


/**
 * Created by cobe on 23/03/2018.
 */

public class CarAdapter extends RecyclerView.Adapter<CarViewHolder> {

    private List<Car> cars = DataHolder.getInstance().getCars();
    private OnCarClickListener onCarClickListener;

    public void setOnCarClickListener(OnCarClickListener onCarClickListener) {
        this.onCarClickListener = onCarClickListener;
    }

    @Override
    public CarViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cars_list_item, parent, false);
        return new CarViewHolder(view, onCarClickListener);
    }

    @Override
    public void onBindViewHolder(CarViewHolder holder, int position) {
        Car car = cars.get(position);
        Context context = holder.itemView.getContext();
        Glide.with(context).load(car.getImages().get(0)).into(holder.imageView);
        holder.carModel.setText(car.getModel());
        holder.carAge.setText(String.format(context.getString(R.string.car_age_format), car.getAge()));
    }

    @Override
    public int getItemCount() {
        return cars.size();
    }

}
