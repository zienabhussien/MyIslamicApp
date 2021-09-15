package com.example.myislamicapplication.ui.quran.soraList;

import android.content.Context;

import androidx.annotation.NonNull;

import com.example.myislamicapplication.data.database.QuranDao;
import com.example.myislamicapplication.data.database.QuranDatabase;
import com.example.myislamicapplication.data.pojo.Jozz;
import com.example.myislamicapplication.data.pojo.Sora;
import com.example.myislamicapplication.data.utils.IndexTabsUtils;

import java.text.Collator;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class QuranIndexViewModel {

    public ArrayList<Sora> getAllSoras(Context context){
        QuranDao quranDao = QuranDatabase.getInstance(context).quranDao();
        ArrayList<Sora> soras = new ArrayList<>();
        for (int i = 1; i <= 114; i++) {
            soras.add(quranDao.getSoraByNumber(i));
        }
        return soras;
    }

    public ArrayList<Jozz> getAllAjzaa(Context context){
        QuranDao quranDao = QuranDatabase.getInstance(context).quranDao();
        ArrayList<Jozz> ajzaa = new ArrayList<>();
        for (int i = 1; i <= 114; i++) {
            ajzaa.add(quranDao.getJozzByNumber(i));
        }
        return ajzaa;
    }

    public List<Integer> getPages(){
        return IntStream.range(1,114).boxed().collect(Collectors.toList());
    }

 public List<?> provideIndexList(Context context, @NonNull IndexTabsUtils.QuranTabs quranTab){
        switch (quranTab){
            case SORA:
                return getAllSoras(context);
            case JOZZ:
                return getAllAjzaa(context);
            case PAGE:
                return getPages();
            default:
                return null;

        }
 }
}
