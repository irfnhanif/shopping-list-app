package com.irfhan.shoppinglistapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ShoppingItemInsertActivity extends AppCompatActivity implements View.OnClickListener {

    private ShoppingItemViewModel shoppingItemViewModel;
    private EditText etItemName, etItemDescription;
    private Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopping_insert_layout);

        etItemName = findViewById(R.id.et_item_name);
        etItemDescription = findViewById(R.id.et_item_description);
        btnAdd = findViewById(R.id.btn_add);

        btnAdd.setOnClickListener(this);

        shoppingItemViewModel = new ShoppingItemViewModel();
    }

    @Override
    public void onClick(View view) {
        String itemName = etItemName.getText().toString();
        String itemDescription = etItemDescription.getText().toString();

        shoppingItemViewModel.addShoppingItem(itemName, itemDescription);
        finish();
    }
}
