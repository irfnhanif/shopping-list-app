package com.irfhan.shoppinglistapp.model;

public class ShoppingItem {
    private String itemId;
    private String name;
    private String description;

    public ShoppingItem(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public ShoppingItem(){

    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
