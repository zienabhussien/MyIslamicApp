package com.example.myislamicapplication.ui.prayertimes.prayertimeshome;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myislamicapplication.data.citiesProvider.CitiesProvider;
import com.example.myislamicapplication.data.networking.PrayersRetrofit;
import com.example.myislamicapplication.data.pojo.prayermethod.PrayerTimesMethodsResponse;
import com.example.myislamicapplication.data.pojo.prayermethod.PrayerTimingMethods;
import com.example.myislamicapplication.data.pojo.prayertimes.City;
import com.example.myislamicapplication.data.pojo.prayertimes.PrayerAPIResponse;
import com.example.myislamicapplication.data.pojo.prayertimes.PrayerTiming;
import com.example.myislamicapplication.data.pojo.prayertimes.Timings;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PrayerTimesViewModel extends ViewModel {

    private static final String TAG ="PrayerTimesViewModel";

    private MutableLiveData<City> currentCity;
    private MutableLiveData<ArrayList<PrayerTiming>> prayerTimings;

    private MutableLiveData<PrayerTimingMethods> prayerTimingMethods;
    private MutableLiveData<Integer> currentPrayerCalculatedMethod;

    public PrayerTimesViewModel() {
        prayerTimings = new MutableLiveData<>();
        currentCity = new MutableLiveData<>();
        prayerTimingMethods = new MutableLiveData<>();
        currentPrayerCalculatedMethod = new MutableLiveData<>(5);

        setPrayerTimingMethods();
    }

    public MutableLiveData<Integer> getCurrentPrayerCalculatedMethod() {
        return currentPrayerCalculatedMethod;
    }

    Call<PrayerTimesMethodsResponse> getPrayerTimingResponse(){
        return PrayersRetrofit.getAPI().getPrayersMethods();
    }


  private   Call<PrayerAPIResponse> getPrayers(String city,
                                       String country,
                                       int method,
                                       int month,
                                       int year){
        return PrayersRetrofit.getAPI().getPrayers(city,country,method,month,year);
    }


    ArrayList<PrayerTiming> convertFromTimings(Timings timings){
        ArrayList<PrayerTiming> res = new ArrayList<>();
         res.add(new PrayerTiming("Fajr",timings.getFajr()));
         res.add(new PrayerTiming("Dhur",timings.getDhuhr()));
         res.add(new PrayerTiming("Asr",timings.getAsr()));
         res.add(new PrayerTiming("Maghrib",timings.getMaghrib()));
         res.add(new PrayerTiming("Isha",timings.getIsha()));
        return res;
    }


    public void setPrayerTimings(City city,int method, int day, int month, int year) {
        getPrayers(city.getName(), city.getCode(), method,month,year)
                .enqueue(new Callback<PrayerAPIResponse>() {
                    @Override
                    public void onResponse(Call<PrayerAPIResponse> call, Response<PrayerAPIResponse> response) {
                        Log.d(TAG, "onResponse: "+response);
                        Timings timings = response.body().getData().get(day - 1).getTimings();
                        ArrayList<PrayerTiming> prayers = convertFromTimings(timings);
                        prayerTimings.setValue(prayers);
                    }

                    @Override
                    public void onFailure(Call<PrayerAPIResponse> call, Throwable t) {
                        Log.d(TAG, "onFailure: "+t.getLocalizedMessage());
                    }
                });
    }

    private void setPrayerTimingMethods() {
       getPrayerTimingResponse().enqueue(new Callback<PrayerTimesMethodsResponse>() {
           @Override
           public void onResponse(Call<PrayerTimesMethodsResponse> call, Response<PrayerTimesMethodsResponse> response) {
               Log.d(TAG, "onResponse: "+response.body().getData());
               prayerTimingMethods.setValue(new PrayerTimingMethods(response.body().getData()));
           }

           @Override
           public void onFailure(Call<PrayerTimesMethodsResponse> call, Throwable t) {
               Log.d(TAG, "onFailure: "+t.getLocalizedMessage());
           }
       });

    }

    public List<City> getCities(Context context) {
        return CitiesProvider.getCities(context);
    }

    public void setCurrentCity(Context context,int position) {
         currentCity.setValue(getCities(context).get(position));
    }

    public MutableLiveData<City> getCurrentCity() {
        return currentCity;
    }

    public MutableLiveData<ArrayList<PrayerTiming>> getPrayerTimings() {
        return prayerTimings;
    }

    public MutableLiveData<PrayerTimingMethods> getPrayerTimingMethods() {
        return prayerTimingMethods;
    }
}
