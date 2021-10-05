package com.example.myislamicapplication.ui.quran.quranSearch;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myislamicapplication.R;
import com.example.myislamicapplication.data.pojo.quran.Aya;

import java.util.ArrayList;

public class QuranSearchAdapter extends RecyclerView.Adapter<QuranSearchAdapter.ViewHolder> {

    private ArrayList<Aya> ayat;
    private Fragment fragment;

    public QuranSearchAdapter(Fragment fragment) {
        this.fragment = fragment;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_quran_search ,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
         holder.bind(ayat.get(position));
    }

    @Override
    public int getItemCount() {
        return  ayat==null? 0 : ayat.size();
    }

    public void setAyat(ArrayList<Aya> ayat) {
        this.ayat = ayat;
        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView ayaNo, ayaContent, soraNo, soraName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ayaNo = itemView.findViewById(R.id.aya_no);
            ayaContent = itemView.findViewById(R.id.aya_content);
            soraNo = itemView.findViewById(R.id.sora_no);
            soraName = itemView.findViewById(R.id.sora_name);
        }

        public void bind(Aya aya) {
            ayaNo.setText(String.valueOf(aya.getAya_no()));
            soraNo.setText(String.valueOf(aya.getSora()));
            soraName.setText(aya.getSora_name_ar());
            ayaContent.setText(aya.getAya_text());

            itemView.setOnClickListener( v -> {
                NavHostFragment.findNavController(fragment)
                        .navigate(QuranSearchFragmentDirections
                                .actionQuranSearchFragmentToQuranFragment(aya.getPage()));
            });

        }
    }
}
