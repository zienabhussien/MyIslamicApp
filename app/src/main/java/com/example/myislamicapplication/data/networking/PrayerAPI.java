package com.example.myislamicapplication.data.networking;

import com.example.myislamicapplication.data.pojo.prayermethod.PrayerTimesMethodsResponse;
import com.example.myislamicapplication.data.pojo.prayertimes.PrayerAPIResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PrayerAPI {

    @GET("calendarByCity")
    Call<PrayerAPIResponse> getPrayers(@Query("city") String city,
                                       @Query("country") String country,
                                       @Query("method") int method,
                                       @Query("month") int month,
                                       @Query("year") int year);
    @GET("methods")
    Call<PrayerTimesMethodsResponse> getPrayersMethods();

}
