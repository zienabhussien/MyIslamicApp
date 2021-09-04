package com.example.myislamicapplication.ui.quran.quranPage;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.myislamicapplication.R;

public class QuranPageFragment extends Fragment {
    private ImageView imageView;
    private QuranViewModel quranViewModel;
    private int pageNumber;

    public QuranPageFragment(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        quranViewModel = new QuranViewModel();
        return inflater.inflate(R.layout.fragment_page_quran, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imageView = view.findViewById(R.id.quran_page);
        Drawable quranPage = quranViewModel.getQuranPageNumber(getContext(),pageNumber);
        imageView.setImageDrawable(quranPage);

    }
}