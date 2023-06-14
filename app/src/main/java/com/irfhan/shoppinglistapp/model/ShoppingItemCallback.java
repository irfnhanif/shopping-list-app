package com.irfhan.shoppinglistapp.model;

import java.util.List;

public interface ShoppingItemCallback {
    void onShoppingItemReceived(List<ShoppingItem> items);
    void onShoppingItemError(String errorMessage);
}
