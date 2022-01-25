package com.example.breweryfinder.Interfaces;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.breweryfinder.Models.SearchModel;

import java.util.List;

//rozhrani pro praci s Room databazi

@Dao
public interface Daoclass {
    @Insert
    void insertAllData(SearchModel model);

    //select all data
    @Query("select * from searchHistoryTable")
    List<SearchModel> getAllData();

}
