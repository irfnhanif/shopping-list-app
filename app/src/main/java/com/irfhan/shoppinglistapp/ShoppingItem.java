package com.irfhan.shoppinglistapp;

public class ShoppingItem {
    private String id;
    private String nama;
    private String judul;

    public ShoppingItem(String nama, String judul) {
        this.nama = nama;
        this.judul = judul;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getJudul() {
        return judul;
    }
}
