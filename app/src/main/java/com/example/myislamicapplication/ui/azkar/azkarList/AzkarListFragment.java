package com.example.myislamicapplication.ui.azkar.azkarList;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myislamicapplication.R;

public class AzkarListFragment extends Fragment {

  private  AzkarListFragmentArgs args;
  private RecyclerView azkarListRV;
  private AzkarListAdapter adapter;
  private AzkarListViewModel viewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         args = AzkarListFragmentArgs.fromBundle(requireArguments());
         adapter = new AzkarListAdapter();
         viewModel = new AzkarListViewModel();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_azkar_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        azkarListRV = view.findViewById(R.id.azkar_list_rv);
        azkarListRV.setLayoutManager(new LinearLayoutManager(getContext()));
        azkarListRV.setAdapter(adapter);
        adapter.setAzkar(viewModel.getAzkar(getContext(),args.getAzkarType()));
    }
}