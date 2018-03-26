package com.example.cobe.carapp.ui.main;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cobe.carapp.R;
import com.example.cobe.carapp.common.data.DataHolder;

public class CarsActivity extends AppCompatActivity implements View.OnClickListener {

    TextView userEmail;
    ViewPager viewPager;
    TabLayout tabLayout;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cars);

        setUI();
        checkCurrentPage();
        recieveUserEmail();
    }

    private String recieveUserEmail() {
        String email = null;
        Intent intent = getIntent();
        if (intent.getExtras() != null) {
            email = intent.getExtras().getString("EMAIL");
        }
        return email;
    }

    private void setUI() {
        back = findViewById(R.id.ivBackToLogin);
        back.setOnClickListener(this);
        userEmail = findViewById(R.id.tvUserEmail);
        userEmail.setText(recieveUserEmail());

        viewPager = findViewById(R.id.viewPager);
        setUpViewPager(viewPager);
        tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void checkCurrentPage() {
        if (viewPager.getCurrentItem() == 0) {
            DataHolder.getInstance().setFavoritesCarsToList();
        } else if (viewPager.getCurrentItem() == 1) {
            DataHolder.getInstance().setAllCarsToList();
        }

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    DataHolder.getInstance().setFavoritesCarsToList();
                }
                if (position == 1) {
                    DataHolder.getInstance().setAllCarsToList();
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void setUpViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new CarsListFragment(), getString(R.string.favorite));
        adapter.addFragment(new CarsListFragment(), getString(R.string.all));
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
        onBackPressed();
    }
}
