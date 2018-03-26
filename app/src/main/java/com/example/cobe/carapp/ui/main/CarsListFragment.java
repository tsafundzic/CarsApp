package com.example.cobe.carapp.ui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cobe.carapp.R;
import com.example.cobe.carapp.ui.details.CarDetailsActivity;
import com.example.cobe.carapp.ui.listeners.OnCarClickListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class CarsListFragment extends Fragment implements OnCarClickListener{

    RecyclerView recyclerView;
    CarAdapter adapter;
    RecyclerView.LayoutManager layoutManager;

    public CarsListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cars_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setUI(view);
        setAdapter();
    }

    private void setAdapter() {
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new CarAdapter();
        adapter.setOnCarClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            getFragmentManager().beginTransaction().detach(this).attach(this).commit();
        }
    }

    private void setUI(View view) {
        recyclerView = view.findViewById(R.id.rlCarsList);
    }

    @Override
    public void onCarClick(int id) {
        startActivity(CarDetailsActivity.getLauchIntent(getActivity(), id));
    }
}
