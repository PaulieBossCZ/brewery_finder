package com.example.breweryfinder.Models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


//modelova trida pro tabulku v Room Database na ulozeni vyhledavanych vyrazu

@Entity(tableName = "searchHistoryTable")

public class SearchModel {

    //primarni klic
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int key;

    //hledany vyraz
    @ColumnInfo(name = "name")
    private String name;

    //soucasny cas
    @ColumnInfo(name = "date")
    private String date;



    public int getKey() {
        return key;
    }
    public void setKey(int key) {
        this.key = key;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


}
