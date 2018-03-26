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

import java.util.List;

/**
 * Created by Tomislav on 25.3.2018..
 */

public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    ImageView imageView;
    TextView carModel;
    TextView carAge;
    private List<Car> cars = DataHolder.getInstance().getCars();

    public ViewHolder(View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.ivCarImage);
        carModel = itemView.findViewById(R.id.tvCarModel);
        carAge = itemView.findViewById(R.id.tvCarAge);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(view.getContext(), CarDetailsActivity.class);
        intent.putExtra("ID", cars.get(getAdapterPosition()).getId());
        setImagesURL(cars.get(getAdapterPosition()).getId());
        view.getContext().startActivity(intent);
    }

    public void setImagesURL(int id){
        Car car = DataHolder.getInstance().returnCarBasedOnCarID(id);
        DataHolder.getInstance().setCarImages(car);
    }
}