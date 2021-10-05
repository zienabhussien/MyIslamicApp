package com.example.myislamicapplication.ui.prayertimes.prayertimeshome;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myislamicapplication.R;
import com.example.myislamicapplication.data.pojo.prayertimes.City;

import java.util.List;

public class CitiesAdapter extends ArrayAdapter<City> {
    private List<City> cities;
    public CitiesAdapter(@NonNull Context context,List<City> cities) {
        super(context,0,cities);
        this.cities = cities;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    @Nullable
    @Override
    public City getItem(int position) {
        return cities.get(position);
    }

    private View initView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        if(convertView == null){
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.spinner_list_city,parent,false);
            City city = getItem(position);

            TextView cityText = convertView.findViewById(R.id.city);
            TextView countryCodeText = convertView.findViewById(R.id.country_code);
            cityText.setText(city.getName());
            countryCodeText.setText(city.getCode());

        }
        return convertView;
    }

}
