package com.example.myislamicapplication.ui.quran.quranSearch;

import android.content.Context;

import com.example.myislamicapplication.data.database.QuranDao;
import com.example.myislamicapplication.data.database.QuranDatabase;
import com.example.myislamicapplication.data.pojo.Aya;

import java.util.ArrayList;

public class QuranSearchViewModel {

    ArrayList<Aya> getSearchResult(Context context, String keyWord){
        QuranDao quranDao = QuranDatabase.getInstance(context).quranDao();
        return (ArrayList<Aya>) quranDao.getAyaBySubText(keyWord);
    }
}
