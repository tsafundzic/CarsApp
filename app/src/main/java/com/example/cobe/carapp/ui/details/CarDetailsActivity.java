package com.example.cobe.carapp.ui.details;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cobe.carapp.R;
import com.example.cobe.carapp.common.data.DataHolder;
import com.example.cobe.carapp.model.Car;

public class CarDetailsActivity extends AppCompatActivity implements View.OnClickListener {

    TextView carName;
    TextView carAge;
    TextView carSpeed;
    TextView carRegistration;
    ViewPager viewPager;
    ImageView back;
    Car car;

    public static Intent getLauchIntent(Context from, int id) {
        Intent intent = new Intent(from, CarDetailsActivity.class);
        intent.putExtra("ID", id);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_details);

        setUI();
        recieveCarID();
        setText();
    }


    private void setUI() {
        back = findViewById(R.id.ivBack);
        back.setOnClickListener(this);
        carName = findViewById(R.id.tvCarName);
        carAge = findViewById(R.id.tvCarAge);
        carSpeed = findViewById(R.id.tvCarSpeed);
        carRegistration = findViewById(R.id.tvCarRegistration);
        viewPager = findViewById(R.id.vpImageViewPager);
        setUpViewPager(viewPager);
    }

    private void setUpViewPager(ViewPager viewPager) {
        ImageAdapter imageAdapter = new ImageAdapter();
        viewPager.setAdapter(imageAdapter);
    }

    private void recieveCarID() {
        Intent intent = getIntent();
        int id = intent.getIntExtra("ID", 0);
        car = DataHolder.getInstance().returnCarBasedOnCarID(id);
    }

    private void setText() {
        carName.setText(car.getModel());
        carAge.setText(String.format(getString(R.string.car_age_format), car.getAge()));
        carSpeed.setText(String.format(getString(R.string.car_speed_format), car.getSpeed()));
        carRegistration.setText(String.format(getString(R.string.car_registration_format), car.getRegistration()));
    }

    @Override
    public void onClick(View view) {
        onBackPressed();
    }
}

