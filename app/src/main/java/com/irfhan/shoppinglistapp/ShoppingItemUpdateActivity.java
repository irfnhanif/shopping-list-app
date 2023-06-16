package com.irfhan.shoppinglistapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.irfhan.shoppinglistapp.model.ShoppingItem;

public class ShoppingItemUpdateActivity extends AppCompatActivity {
    private ShoppingItemViewModel shoppingItemViewModel;
    private EditText etEditName, etEditDescription;
    private Button btnUpdate;
    private ShoppingItem shoppingItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopping_update_layout);

        shoppingItem = getIntent().getParcelableExtra("extra_item");

        String id = shoppingItem.getItemId();
        etEditName = findViewById(R.id.et_edit_name);
        etEditName.setText(shoppingItem.getName());
        etEditDescription = findViewById(R.id.et_edit_description);
        etEditDescription.setText(shoppingItem.getDescription());
        btnUpdate = findViewById(R.id.btn_edit);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etEditName.getText().toString();
                String description = etEditDescription.getText().toString();
                shoppingItemViewModel.updateShoppingItem(id, name, description);
                finish();
            }
        });

        shoppingItemViewModel = new ShoppingItemViewModel();
    }
}