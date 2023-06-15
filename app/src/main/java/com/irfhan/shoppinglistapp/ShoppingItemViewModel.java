package com.irfhan.shoppinglistapp;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.irfhan.shoppinglistapp.model.ShoppingItem;
import com.irfhan.shoppinglistapp.model.ShoppingItemCallback;
import com.irfhan.shoppinglistapp.model.ShoppingItemRepository;

import java.util.ArrayList;
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
        shoppingItemRepository.getAllShoppingItems(new ShoppingItemCallback() {

            @Override
            public void onShoppingItemReceived(ShoppingItem item) {

            }

            @Override
            public void onShoppingItemReceived(List<ShoppingItem> items) {
                dataList.setValue(items);
            }

            @Override
            public void onShoppingItemError(String errorMessage) {
                Log.e("ERROR", errorMessage);
            }
        });
    }


    public void addShoppingItem(String name, String description) {
        shoppingItemRepository.addShoppingItem(name, description);
    }

    public void updateShoppingItem(String noteId, String name, String description) {
        shoppingItemRepository.updateShoppingItem(noteId, name, description);
    }

    public void deleteShoppingItem(String noteId) {
        shoppingItemRepository.deleteShoppingItem(noteId);
        List<ShoppingItem> updatedList = new ArrayList<>(dataList.getValue());
        dataList.setValue(updatedList);
    }
}
