package com.example.cobe.carapp.ui.details;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.cobe.carapp.R;
import com.example.cobe.carapp.common.data.DataHolder;
import com.example.cobe.carapp.model.Car;

public class CarDetailsActivity extends AppCompatActivity {

    TextView carName;
    TextView carAge;
    TextView carSpeed;
    TextView carRegistration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_details);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle(R.string.car_details);

        setUI();
        setText();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
    }

    private void setUI() {
        carName = findViewById(R.id.tvCarName);
        carAge = findViewById(R.id.tvCarAge);
        carSpeed = findViewById(R.id.tvCarSpeed);
        carRegistration = findViewById(R.id.tvCarRegistration);
    }

    private void setText() {
        Intent intent = getIntent();
        int id = intent.getIntExtra("ID", 0);
        Car car = DataHolder.getInstance().returnCarBasedOnCarID(id);

        carName.setText(car.getModel());
        carAge.setText(String.format(getString(R.string.car_age_format), car.getAge()));
        carSpeed.setText(String.format(getString(R.string.car_speed_format), car.getSpeed()));
        carRegistration.setText(String.format(getString(R.string.car_registration_format), car.getRegistration()));
    }

}

