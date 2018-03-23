package com.example.cobe.carapp.ui.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.cobe.carapp.R;
import com.example.cobe.carapp.common.data.DataHolder;
import com.example.cobe.carapp.model.Car;

import java.util.List;


/**
 * Created by cobe on 23/03/2018.
 */

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.ViewHolder> {

    List<Car> cars = DataHolder.getInstance().getCars();
    private Car car;

    @Override
    public CarAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cars_list_item, parent, false);
        return new CarAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CarAdapter.ViewHolder holder, int position) {
        car = cars.get(position);
        Context context = holder.itemView.getContext();
        Glide.with(context).load(car.getImages().get(0)).into(holder.imageView);
        holder.carModel.setText(car.getModel());
        holder.carAge.setText(String.valueOf(car.getAge()));
    }

    @Override
    public int getItemCount() {
        return cars.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView carModel;
        TextView carAge;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.ivCarImage);
            carModel = itemView.findViewById(R.id.tvCarModel);
            carAge = itemView.findViewById(R.id.tvCarAge);
        }
    }
}
