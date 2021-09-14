package com.example.myislamicapplication.data;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.icu.text.DecimalFormat;

import java.io.IOException;
import java.io.InputStream;


public class PagesManager {

    public static Drawable getQuranImageByPageNumber(Context context, int pageNumber){

        DecimalFormat formatter = new DecimalFormat("000");
        String drawableName = "quran/images/page" +formatter.format(pageNumber)+".png";

        InputStream istr = null;

        try {
            istr = context.getAssets().open(drawableName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Drawable.createFromStream(istr,null);
    }
}
