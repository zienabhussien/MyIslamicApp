package com.example.myislamicapplication.ui.azkar.azkarList;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myislamicapplication.R;
import com.example.myislamicapplication.data.pojo.azkar.Zekr;

import java.util.ArrayList;

public class AzkarListAdapter extends RecyclerView.Adapter<AzkarListAdapter.ViewHolder>{
    private ArrayList<Zekr> azkar;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_zekr,parent,false));    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(azkar.get(position));
    }

    @Override
    public int getItemCount() {
        return azkar ==null ? 0 : azkar.size();
    }

    public void setAzkar(ArrayList<Zekr> azkar) {
        this.azkar = azkar;
        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView zekrName;
        ImageView zekrImage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            zekrName = itemView.findViewById(R.id.zekr_name);
            zekrImage = itemView.findViewById(R.id.zekr_image);
        }

        public void bind(Zekr zekr) {
            zekrName.setText(zekr.getZekr());

        }
    }
}
