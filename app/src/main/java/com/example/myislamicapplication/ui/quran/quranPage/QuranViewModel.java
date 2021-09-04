package com.example.myislamicapplication.ui.quran.quranPage;

import android.content.Context;
import android.graphics.drawable.Drawable;

import com.example.myislamicapplication.data.PagesManager;

public class QuranViewModel {

    public Drawable getQuranPageNumber(Context context, int pageNumber){
        return PagesManager.getQuranImageByPageNumber(context,pageNumber);
    }
}
