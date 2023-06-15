package com.irfhan.shoppinglistapp;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.irfhan.shoppinglistapp.model.ShoppingItem;

import java.util.ArrayList;
import java.util.List;

public class ShoppingAdapter extends RecyclerView.Adapter {

    private List<ShoppingItem> shoppingList = new ArrayList<>();
    private final Context ctx;
    private ShoppingItemViewModel shoppingItemViewModel;
    public ShoppingAdapter(Context ctx, ShoppingItemViewModel shoppingItemViewModel) {
        this.ctx = ctx;
        this.shoppingItemViewModel = shoppingItemViewModel;
    }


    public void setData(List<ShoppingItem> data) {
        shoppingList.clear();
        shoppingList.addAll(data);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(ctx).inflate(R.layout.item_layout, parent, false);
        VH vh = new VH(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ShoppingItem s = shoppingList.get(position);
        VH vh = (VH) holder;
        vh.tvNama.setText(s.getName());
        vh.tvJumlah.setText(s.getDescription());

        vh.acivDelete.setOnClickListener(v -> {
            String itemId = s.getItemId();
            shoppingItemViewModel.deleteShoppingItem(itemId);
        });
    }

    @Override
    public int getItemCount() {
        return shoppingList.size();
    }

    class VH extends RecyclerView.ViewHolder {
        public TextView tvNama;
        public TextView tvJumlah;
        public AppCompatImageView acivEdit, acivDelete;

        VH(View rowView) {
            super(rowView);
            tvNama = rowView.findViewById(R.id.tvNama);
            tvJumlah = rowView.findViewById(R.id.tvJumlah);
            acivEdit = rowView.findViewById(R.id.btnEdit);
            acivDelete = rowView.findViewById(R.id.btnDelete);
        }
    }
}
