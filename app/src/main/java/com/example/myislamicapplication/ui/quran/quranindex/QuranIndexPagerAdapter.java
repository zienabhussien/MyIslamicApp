package com.example.myislamicapplication.ui.quran.quranindex;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.myislamicapplication.databinding.FragmentPageQuranBinding;
import com.example.myislamicapplication.ui.quran.soraList.SoraListFragment;

public class QuranIndexPagerAdapter extends FragmentStateAdapter {

    public QuranIndexPagerAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        return new SoraListFragment();
    }

    @Override
    public int getItemCount() {
        return 1;
    }
}
