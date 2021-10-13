package com.example.myislamicapplication.ui.prayertimes.prayertimeshome;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myislamicapplication.R;

import java.util.Calendar;

public class PrayerTimesFragment extends Fragment {
    private static final String TAG = "PrayerTimesFragment";
   private RecyclerView times;
   private DatePicker datePicker;
   private Spinner citiesSpinner,prayerTimingMethodSpinner;
   private PrayerTimesListAdapter adapter;
   private PrayerTimesViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
          viewModel = new ViewModelProvider(this).get(PrayerTimesViewModel.class);
        return inflater.inflate(R.layout.fragment_prayer_times, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initViews( view);
        setupAdapter();
        initDatePicker();
        initClickListener();
        setupObservers();


    }


    private void initViews(View view){
        times = view.findViewById(R.id.prayer_rv);
        datePicker = view.findViewById(R.id.date);
        citiesSpinner = view.findViewById(R.id.citySpinner);
        prayerTimingMethodSpinner = view.findViewById(R.id.methodSpinner);
    }
    private void setupAdapter() {
        citiesSpinner.setAdapter(new CitiesAdapter(getContext(),viewModel.getCities(getContext())));
        adapter = new PrayerTimesListAdapter();
        times.setAdapter(adapter);
    }
    private void initDatePicker() {
        Calendar calendar = Calendar.getInstance();
        datePicker.init(calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH),
                (view1, year, monthOfYear, dayOfMonth) -> {
                    viewModel.setPrayerTimings(getContext(),viewModel.getCurrentCity().getValue(),
                             viewModel.getCurrentPrayerCalculatedMethod().getValue(),
                            dayOfMonth,monthOfYear,year);
                });
    }

    private void initClickListener() {
        citiesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                viewModel.setCurrentCity(getContext(),position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void setupObservers() {
        viewModel.getPrayerTimings().observe(getViewLifecycleOwner(), prayerTimings -> {
            adapter.setTimings(prayerTimings);
        });

        viewModel.getCurrentCity().observe(getViewLifecycleOwner(), city -> {
         if(viewModel.getCurrentPrayerCalculatedMethod().getValue() != null)
             viewModel.setPrayerTimings(getContext(),city,
                     viewModel.getCurrentPrayerCalculatedMethod().getValue(),
                     datePicker.getMonth(),
                     datePicker.getDayOfMonth(), datePicker.getDayOfMonth());

        });

        viewModel.getCurrentPrayerCalculatedMethod().observe(getViewLifecycleOwner(), prayerMethod ->{
            if(viewModel.getCurrentCity().getValue() != null)
                viewModel.setPrayerTimings(
                        getContext(),
                        viewModel.getCurrentCity().getValue(),
                        prayerMethod,
                        datePicker.getDayOfMonth(),
                        datePicker.getMonth(),
                        datePicker.getYear());
        });

        viewModel.getPrayerTimingMethods().observe( getViewLifecycleOwner(), prayerTimingMethods -> {
            prayerTimingMethodSpinner.setAdapter(new PrayerMethodsAdapter(requireContext(),
                    prayerTimingMethods.getMethods()));
        });

    }


}