package com.example.breweryfinder;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.breweryfinder.Interfaces.Daoclass;
import com.example.breweryfinder.Models.SearchModel;

//trida pro Room Database

@Database(entities = {SearchModel.class}, version = 1 )
public abstract class DatabaseClass extends RoomDatabase {

    public abstract Daoclass getDao();
    private static DatabaseClass instance;


    static DatabaseClass getDatabase (final Context context)
    {

    if(instance==null){
        synchronized (DatabaseClass.class){
            instance = Room.databaseBuilder(context, DatabaseClass.class,"DATABASE").allowMainThreadQueries().build();
        }

    }
    return instance;
    }
}
