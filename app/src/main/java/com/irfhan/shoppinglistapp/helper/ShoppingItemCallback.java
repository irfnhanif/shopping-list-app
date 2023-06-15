package com.irfhan.shoppinglistapp.helper;

import com.irfhan.shoppinglistapp.model.ShoppingItem;

import java.util.List;

public interface ShoppingItemCallback {
    void onShoppingItemReceived(ShoppingItem item);
    void onShoppingItemReceived(List<ShoppingItem> items);
    void onShoppingItemError(String errorMessage);
}
