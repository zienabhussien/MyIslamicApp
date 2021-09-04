package com.example.myislamicapplication.ui.quran.quranContainer;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.myislamicapplication.ui.quran.quranPage.QuranPageFragment;

public class QuranPagesAdapter extends FragmentStateAdapter {
    private static final int NUM_PAGES = 604;

    public QuranPagesAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @Override
    public Fragment createFragment(int position) {
        return new QuranPageFragment(NUM_PAGES-position);
    }

    @Override
    public int getItemCount() {
        return NUM_PAGES;
    }

 }
