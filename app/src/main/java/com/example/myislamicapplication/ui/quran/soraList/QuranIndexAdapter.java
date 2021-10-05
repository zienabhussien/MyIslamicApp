package com.example.myislamicapplication.ui.quran.soraList;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myislamicapplication.R;
import com.example.myislamicapplication.data.pojo.quran.Jozz;
import com.example.myislamicapplication.data.pojo.quran.Sora;
import com.example.myislamicapplication.ui.quran.quranindex.QuranIndexFragmentDirections;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class QuranIndexAdapter extends RecyclerView.Adapter<QuranIndexAdapter.ViewHolder> {
  List<?> index;
  Fragment fragment;
    public QuranIndexAdapter(List<?> index, Fragment fragment) {
        this.index = index;
        this.fragment = fragment;
    }

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_sora,parent,false));
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {
        if (index.get(position) instanceof Sora) {
            holder.bind((Sora) index.get(position));
        } else if (index.get(position) instanceof Jozz) {
            holder.bind((Jozz) index.get(position));
        } else if (index.get(position) instanceof Integer) {
            holder.bind((Integer) index.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return index.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
       TextView soraNumber, soraName,from,to,wordTo,pageFrom;
        public ViewHolder( View itemView) {
            super(itemView);
            soraNumber = itemView.findViewById(R.id.sora_number);
            soraName = itemView.findViewById(R.id.sora_name);
            from = itemView.findViewById(R.id.sora_start);
            to = itemView.findViewById(R.id.sora_end);
            wordTo = itemView.findViewById(R.id.word_to);
            pageFrom = itemView.findViewById(R.id.word_from);
        }

        public void bind(Sora sora) {
                NumberFormat nf= NumberFormat.getInstance(new Locale("ar","EG"));

                wordTo.setVisibility(View.VISIBLE);

                soraNumber.setText(nf.format(sora.getSoraNumber()));
                soraName.setText(sora.getArabicName());
                from.setText(nf.format(sora.getStartPage()));
                to.setText(nf.format(sora.getEndPage()));
                itemView.setOnClickListener(v -> NavHostFragment
                        .findNavController(fragment)
                        .navigate(QuranIndexFragmentDirections
                                .actionQuranIndexToQuranFragment(sora.getStartPage())));
        }

        public void bind(Jozz jozz) {
            NumberFormat nf= NumberFormat.getInstance(new Locale("ar","EG"));

            soraName.setVisibility(View.GONE);
            wordTo.setVisibility(View.VISIBLE);

            soraNumber.setText(nf.format(jozz.getJozzNumber()));
            from.setText(nf.format(jozz.getStartPage()));
            to.setText(nf.format(jozz.getEndPage()));

            itemView.setOnClickListener(v -> NavHostFragment
                    .findNavController(fragment)
                    .navigate(QuranIndexFragmentDirections
                            .actionQuranIndexToQuranFragment(jozz.getStartPage())));
        }

        public void bind(Integer page) {
            NumberFormat nf= NumberFormat.getInstance(new Locale("ar","EG"));

            soraName.setVisibility(View.GONE);
            from.setVisibility(View.GONE);
            to.setVisibility(View.GONE);
            wordTo.setVisibility(View.GONE);
            pageFrom.setVisibility(View.GONE);

            soraNumber.setText(nf.format(page));

            itemView.setOnClickListener(v -> NavHostFragment
                    .findNavController(fragment)
                    .navigate(QuranIndexFragmentDirections
                            .actionQuranIndexToQuranFragment(page)));
        }
    }
    }

