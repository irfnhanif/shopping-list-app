package com.irfhan.shoppinglistapp;

import java.util.List;

public interface ShoppingItemCallback {
    void onShoppingItemReceived(List<ShoppingItem> items);
    void onShoppingItemError(String errorMessage);
}
