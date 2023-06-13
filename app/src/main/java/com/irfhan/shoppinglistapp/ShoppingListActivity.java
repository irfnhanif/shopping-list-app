package com.irfhan.shoppinglistapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;

import java.util.List;

public class ShoppingListActivity extends AppCompatActivity {
    Button btnAdd;
    RecyclerView rvShopping;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopping_list_layout);

        ShoppingItemViewModel shoppingListViewModel = new ViewModelProvider(this).get(ShoppingItemViewModel.class);

        rvShopping = findViewById(R.id.rvShopping);
        btnAdd.findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(view -> {

        });

        ShoppingAdapter adapter = new ShoppingAdapter(this);
        rvShopping.setLayoutManager(new LinearLayoutManager(this));
        rvShopping.setAdapter(adapter);

        shoppingListViewModel.getDataList().observe(this, new Observer<List<ShoppingItem>>() {
            @Override
            public void onChanged(List<ShoppingItem> data) {
                adapter.setData(data);
            }
        });
    }
}