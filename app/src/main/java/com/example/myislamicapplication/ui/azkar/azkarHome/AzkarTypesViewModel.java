package com.example.myislamicapplication.ui.azkar.azkarHome;

import android.content.Context;

import com.example.myislamicapplication.data.azkarProvider.AzkarProvider;
import com.example.myislamicapplication.data.pojo.ZekrType;

import java.util.ArrayList;
import java.util.HashSet;

public class AzkarTypesViewModel {

    HashSet<ZekrType> getAzkarTypes(Context context){
        return AzkarProvider.getAzkarTypes(context);
    }
}
