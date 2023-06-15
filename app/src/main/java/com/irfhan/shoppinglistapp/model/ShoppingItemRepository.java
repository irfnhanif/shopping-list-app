package com.irfhan.shoppinglistapp.model;

import androidx.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.irfhan.shoppinglistapp.helper.ShoppingItemCallback;
import com.irfhan.shoppinglistapp.helper.ShoppingItemDeletedCallback;

import java.util.ArrayList;
import java.util.List;

public class ShoppingItemRepository {
    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;
    private String url = "https://pam-firebase-3e5ba-default-rtdb.asia-southeast1.firebasedatabase.app/";

    public ShoppingItemRepository() {
        mDatabase = FirebaseDatabase.getInstance(url).getReference("/");
        mAuth = FirebaseAuth.getInstance();
    }

    public void getAllShoppingItems(final ShoppingItemCallback callback) {
        String userId = mAuth.getCurrentUser().getUid();
        mDatabase.child("users").child(userId).child("items").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List<ShoppingItem> items = new ArrayList<>();
                for (DataSnapshot itemSnapshot : snapshot.getChildren()) {
                    ShoppingItem shoppingItem = itemSnapshot.getValue(ShoppingItem.class);
                    if (shoppingItem != null) {
                        items.add(shoppingItem);
                    }
                }
                callback.onShoppingItemReceived(items);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                callback.onShoppingItemError(error.getMessage());
            }
        });
    }

    public void getShoppingItem(String itemId, final ShoppingItemCallback callback) {
        String userId = mAuth.getCurrentUser().getUid();
        DatabaseReference itemRef = mDatabase.child("users").child(userId).child("items").child(itemId);

        itemRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ShoppingItem shoppingItem = snapshot.getValue(ShoppingItem.class);
                if (shoppingItem != null) {
                    callback.onShoppingItemReceived(shoppingItem);
                } else {
                    callback.onShoppingItemError("Shopping item not found");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                callback.onShoppingItemError(error.getMessage());
            }
        });
    }


    public void addShoppingItem(String name, String description) {
        ShoppingItem shoppingItem = new ShoppingItem(name, description);
        String userId = mAuth.getCurrentUser().getUid();

        DatabaseReference newItemRef = mDatabase.child("users").child(userId).child("items").push();
        String newItemId = newItemRef.getKey();

        shoppingItem.setItemId(newItemId);
        newItemRef.setValue(shoppingItem);
    }

    public void updateShoppingItem(String noteId, String name, String description) {
        String userId = mAuth.getCurrentUser().getUid();
        DatabaseReference itemRef = mDatabase.child("users").child(userId).child("items").child(noteId);
        itemRef.child("name").setValue(name);
        itemRef.child("description").setValue(description);
    }

    public void deleteShoppingItem(String noteId, ShoppingItemDeletedCallback shoppingItemDeletedCallback) {
        String userId = mAuth.getCurrentUser().getUid();
        DatabaseReference itemRef = mDatabase.child("users").child(userId).child("items").child(noteId);
        itemRef.removeValue();
    }
}
