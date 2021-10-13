package com.example.myislamicapplication.data.prayersnotification;

import android.content.Context;

import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;

import java.util.concurrent.TimeUnit;

public class AzanPrayerUtil {
    public static void registerPrayers(Context context) {
        WorkManager.getInstance(context).cancelAllWork();
        PeriodicWorkRequest registerRequest = new PeriodicWorkRequest
                .Builder(RegisterPrayerTimesWorker.class,30, TimeUnit.DAYS)
                .addTag("REGISTER_PRAYERS")
                .build();
        WorkManager.getInstance(context)
                .enqueueUniquePeriodicWork("REGISTER_PRAYERS", ExistingPeriodicWorkPolicy.REPLACE,registerRequest);
    }
}
