package com.example.myislamicapplication.ui.quran.quranindex;

import com.example.myislamicapplication.data.utils.IndexTabsUtils;

public class QuranIndexViewModel {

    private String [] tabList;
    public QuranIndexViewModel() {
        tabList = IndexTabsUtils.QURAN_INDEX_TABS;
    }

    public String getTabAt(int position){
        return tabList[position]; }
}
