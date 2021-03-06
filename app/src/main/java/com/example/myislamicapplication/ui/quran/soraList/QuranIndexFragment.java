package com.example.myislamicapplication.ui.quran.soraList;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myislamicapplication.R;
import com.example.myislamicapplication.data.utils.IndexTabsUtils;

public class QuranIndexFragment extends Fragment {
   private RecyclerView soraList;
   private QuranIndexViewModel viewModel;
    private IndexTabsUtils.QuranTabs currentTab;


    public QuranIndexFragment(IndexTabsUtils.QuranTabs currentTab) {
        this.currentTab = currentTab;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sora_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
      //  search = view.findViewById(R.id.search_quran_et);
        viewModel = new QuranIndexViewModel();
        soraList = view.findViewById(R.id.sora_rv);
        soraList.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
        soraList.setAdapter(new QuranIndexAdapter(viewModel.provideIndexList(getContext(),currentTab),this));


    }
}