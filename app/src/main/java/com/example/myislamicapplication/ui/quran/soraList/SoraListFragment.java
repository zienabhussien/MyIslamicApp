package com.example.myislamicapplication.ui.quran.soraList;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.myislamicapplication.R;
import com.example.myislamicapplication.data.database.QuranDatabase;
import com.example.myislamicapplication.data.pojo.Sora;

import java.util.ArrayList;

public class SoraListFragment extends Fragment {
   private EditText search;
   private RecyclerView soraList;
   private SoraListViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sora_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        search = view.findViewById(R.id.search_quran_et);
        viewModel = new SoraListViewModel();
        soraList = view.findViewById(R.id.sora_rv);
        soraList.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
        soraList.setAdapter(new SoraListAdapter(viewModel.getAllSoras(getContext()),this));

        search.setOnClickListener( v ->{
            NavHostFragment.findNavController(this)
                    .navigate(SoraListFragmentDirections
                            .actionSoraListFragmentToQuranSearchFragment());
        });

    }
}