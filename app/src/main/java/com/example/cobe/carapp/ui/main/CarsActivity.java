package com.example.cobe.carapp.ui.main;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.cobe.carapp.R;

public class CarsActivity extends AppCompatActivity {


    TextView userEmail;
    ViewPager viewPager;
    FrameLayout frameLayout;

    static final int NUMBER_OF_PAGES = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cars);

        setUI();
        recieveUserEmail();
    }

    private String recieveUserEmail() {
        Intent intent = getIntent();
        String email = intent.getExtras().getString("EMAIL");
        return email;
    }

    private void setUI() {
        userEmail = findViewById(R.id.tvUserEmail);
        userEmail.setText(recieveUserEmail());

        viewPager = findViewById(R.id.viewPager);

        frameLayout = findViewById(R.id.frameLayout);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, new CarsListFragment());
        fragmentTransaction.commit();
    }
}
