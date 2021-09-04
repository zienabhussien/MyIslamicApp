package com.example.myislamicapplication.ui.quran.soraList;

import android.content.Context;

import com.example.myislamicapplication.data.database.QuranDao;
import com.example.myislamicapplication.data.database.QuranDatabase;
import com.example.myislamicapplication.data.pojo.Sora;

import java.util.ArrayList;

public class SoraListViewModel {

    public ArrayList<Sora> getAllSoras(Context context){

        QuranDao quranDao = QuranDatabase.getInstance(context).quranDao();
        ArrayList<Sora> soras = new ArrayList<>();
        for (int i = 1; i <= 114; i++) {
            soras.add(quranDao.getSoraByNumber(i));
        }

        return soras;
    }
}
