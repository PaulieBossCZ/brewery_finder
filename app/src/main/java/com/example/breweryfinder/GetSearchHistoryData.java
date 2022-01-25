package com.example.breweryfinder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.breweryfinder.Adapters.SearchAdapter;

public class GetSearchHistoryData extends AppCompatActivity {

    //trida pro naplneni recyclerview daty z databaze historie vyhledavani

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_data);

        recyclerView = findViewById(R.id.recyclerView);

        getData();
    }

    private void getData(){

        recyclerView.setAdapter(new SearchAdapter(getApplicationContext(),DatabaseClass.getDatabase(getApplicationContext()).getDao().getAllData()));

    }
}