package com.irfhan.shoppinglistapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ShoppingListActivity extends AppCompatActivity {

    Button btnAdd;
    RecyclerView rvShopping;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopping_list_layout);

        rvShopping = findViewById(R.id.rvShopping);
        btnAdd.findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(view -> {

        });
    }
}