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

        Bundle bundle = getIntent().getBundleExtra("bundle");

        String itemId = bundle.getString("itemId");
        etEditName = findViewById(R.id.et_edit_name);
        etEditName.setText(bundle.getString("name"));
        etEditDescription = findViewById(R.id.et_edit_description);
        etEditDescription.setText(bundle.getString("description"));
        btnUpdate = findViewById(R.id.btn_edit);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etEditName.getText().toString();
                String description = etEditDescription.getText().toString();
                shoppingItemViewModel.updateShoppingItem(itemId, name, description);
                finish();
            }
        });

        shoppingItemViewModel = new ShoppingItemViewModel();
    }
}