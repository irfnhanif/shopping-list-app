package com.irfhan.shoppinglistapp;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ShoppingAdapter extends RecyclerView.Adapter {

    private List<> shoppingList = new ArrayList<>();
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return shoppingList.size();
    }

    class VH extends RecyclerView.ViewHolder {
        public TextView tvNama;
        public TextView tvJumlah;
        public Button btnEdit;
        public Button btnDelete;

        VH(View rowView) {
            super(rowView);
            this.tvNama = rowView.findViewById(R.id.tvNama);
            this.tvJumlah = rowView.findViewById(R.id.tvJumlah);
            this.btnEdit = rowView.findViewById(R.id.btnEdit);
            this.btnDelete = rowView.findViewById(R.id.btnDelete);
        }
    }
}
