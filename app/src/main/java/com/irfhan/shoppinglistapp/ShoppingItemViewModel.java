package com.irfhan.shoppinglistapp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class ShoppingItemViewModel extends ViewModel {
    private ShoppingItemRepository shoppingItemRepository;
    private MutableLiveData<List<ShoppingItem>> dataList;

    public LiveData<List<ShoppingItem>> getDataList() {
        return dataList;
    }

    public ShoppingItemViewModel() {
        shoppingItemRepository = new ShoppingItemRepository();
        dataList = new MutableLiveData<>();
    }

    public void getAllShoppingItems() {
        shoppingItemRepository.getAllShoppingItems();
    }

    public void addShoppingItem(String name, String description) {
        shoppingItemRepository.addShoppingItem(name, description);
    }

    public void updateShoppingItem(String noteId, String name, String description) {
        shoppingItemRepository.updateShoppingItem(noteId, name, description);
    }

    public void deleteShoppingItem(String noteId) {
        shoppingItemRepository.deleteShoppingItem(noteId);
    }
}
