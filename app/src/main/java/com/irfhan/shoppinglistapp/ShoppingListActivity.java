package com.irfhan.shoppinglistapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.irfhan.shoppinglistapp.model.ShoppingItem;

import java.util.List;

public class ShoppingListActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnAdd;
    RecyclerView rvShopping;
    ShoppingItemViewModel shoppingItemViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopping_list_layout);

        shoppingItemViewModel = new ViewModelProvider(this).get(ShoppingItemViewModel.class);

        rvShopping = findViewById(R.id.rvShopping);
        btnAdd.findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);

        ShoppingAdapter adapter = new ShoppingAdapter(this, shoppingItemViewModel);
        rvShopping.setLayoutManager(new LinearLayoutManager(this));
        rvShopping.setAdapter(adapter);

        shoppingItemViewModel.getDataList().observe(this, new Observer<List<ShoppingItem>>() {
            @Override
            public void onChanged(List<ShoppingItem> data) {
                adapter.setData(data);
            }
        });
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(ShoppingListActivity.this, ShoppingItemInsertActivity.class);
        startActivity(intent);
    }
}