package com.example.myislamicapplication.ui.quran.soraList;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myislamicapplication.R;
import com.example.myislamicapplication.data.pojo.Sora;

import java.util.List;

public class SoraListAdapter extends RecyclerView.Adapter<SoraListAdapter.ViewHolder> {
  List<Sora> index;
  Fragment fragment;
    public SoraListAdapter(List<Sora> index, Fragment fragment) {
        this.index = index;
        this.fragment = fragment;
    }

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_sora,parent,false));
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {
          holder.bind(index.get(position));
    }

    @Override
    public int getItemCount() {
        return index.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
       TextView soraNumber, soraName,from,to;
        public ViewHolder( View itemView) {
            super(itemView);
            soraNumber = itemView.findViewById(R.id.sora_number);
            soraName = itemView.findViewById(R.id.soraName);
            from = itemView.findViewById(R.id.sora_start);
            to = itemView.findViewById(R.id.sora_end);
        }

        public void bind(Sora sora) {
            soraNumber.setText(Integer.toString(sora.getSoraNumber()));
            soraName.setText(sora.getArabicName());
            from.setText(Integer.toString(sora.getStartPage()));
            to.setText(Integer.toString(sora.getEndPage()));
            itemView.setOnClickListener( v->{
                NavHostFragment.findNavController(fragment).navigate(SoraListFragmentDirections.actionSoraListFragmentToQuranFragment(sora.getStartPage())) ;
            });
        }
    }
}
