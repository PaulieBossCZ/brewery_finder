package com.example.breweryfinder.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.breweryfinder.R;
import com.example.breweryfinder.Models.SearchModel;

import java.util.List;

//recycler view adapter pro polozky z tabulky historie vyhledavani

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {
    Context context;
    List<SearchModel> list;

    public SearchAdapter(Context context, List<SearchModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.name.setText(list.get(position).getName());
        holder.time.setText(list.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView name,time;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            name=itemView.findViewById(R.id.searchName);
            time = itemView.findViewById(R.id.searchTime);
        }
    }

}
