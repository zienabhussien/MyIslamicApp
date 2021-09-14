package com.example.myislamicapplication.ui.azkar.azkarList;

import android.content.Context;

import com.example.myislamicapplication.data.azkarProvider.AzkarProvider;
import com.example.myislamicapplication.data.pojo.Zekr;

import java.util.ArrayList;

public class AzkarListViewModel {

    public ArrayList<Zekr> getAzkar(Context context,String zekerType) {
        return AzkarProvider.getAzkarBType(context,zekerType);
    }
}
