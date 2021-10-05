package com.example.myislamicapplication.data.pojo.prayertimes;

public class PrayerTiming {
    private String prayerName, prayerTime;

    public PrayerTiming(String prayerName, String prayerTime) {
        this.prayerName = prayerName;
        this.prayerTime = prayerTime;
    }

    public String getPrayerName() {
        return prayerName;
    }

    public String getPrayerTime() {
        return prayerTime;
    }
}
