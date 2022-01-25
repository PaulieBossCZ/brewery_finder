package com.example.breweryfinder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.breweryfinder.Adapters.BreweryAdapter;
import com.example.breweryfinder.Interfaces.IOpenBreweryDB;
import com.example.breweryfinder.Models.BreweryModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SearchActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);


        //ziskani hodnot predaneho z intentu z main activity
        Intent intent = getIntent();
        String SearchTerm = intent.getStringExtra(MainActivity.EXTRA_SEARCH_TERM);
        int SearchBy = intent.getIntExtra(MainActivity.EXTRA_SEARCH_BY,1);


        TextView SearchTermTextView = findViewById(R.id.searchTerm);
        SearchTermTextView.setText(SearchTerm);


        recyclerView = findViewById(R.id.recycleView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



        //inicializace retrofitu
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.openbrewerydb.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        IOpenBreweryDB openBreweryApi = retrofit.create(IOpenBreweryDB.class);


        //ziskani dat z openBrewery API na zaklade predane hodnoty SearchBy
        //by name
        if(SearchBy == 1){

            Call<List<BreweryModel>> call = openBreweryApi.getBreweryByName(SearchTerm);
            call.enqueue(new Callback<List<BreweryModel>>() {
                @Override
                public void onResponse(Call<List<BreweryModel>> call, Response<List<BreweryModel>> response) {

                    if(!response.isSuccessful()){

                        Toast.makeText(SearchActivity.this,response.code(),Toast.LENGTH_SHORT).show();
                        return;
                    }

                    List<BreweryModel> breweries = response.body();
                    BreweryAdapter breweryAdapter = new BreweryAdapter(SearchActivity.this,breweries);
                    recyclerView.setAdapter(breweryAdapter);

                }

                @Override
                public void onFailure(Call<List<BreweryModel>> call, Throwable t) {
                    Toast.makeText(SearchActivity.this,t.getMessage(),Toast.LENGTH_SHORT).show();
                }
            });


        }



        //by city
        if(SearchBy ==2){

            Call<List<BreweryModel>> call = openBreweryApi.getBreweryByCity(SearchTerm);
            call.enqueue(new Callback<List<BreweryModel>>() {
                @Override
                public void onResponse(Call<List<BreweryModel>> call, Response<List<BreweryModel>> response) {

                    if(!response.isSuccessful()){

                        Toast.makeText(SearchActivity.this,response.code(),Toast.LENGTH_SHORT).show();
                        return;
                    }

                    List<BreweryModel> breweries = response.body();
                    BreweryAdapter breweryAdapter = new BreweryAdapter(SearchActivity.this,breweries);
                    recyclerView.setAdapter(breweryAdapter);

                }

                @Override
                public void onFailure(Call<List<BreweryModel>> call, Throwable t) {
                    Toast.makeText(SearchActivity.this,t.getMessage(),Toast.LENGTH_SHORT).show();
                }
            });


        }

        //by postal code
        if(SearchBy == 3){

            Call<List<BreweryModel>> call = openBreweryApi.getBreweryByPostalCode(SearchTerm);
            call.enqueue(new Callback<List<BreweryModel>>() {
                @Override
                public void onResponse(Call<List<BreweryModel>> call, Response<List<BreweryModel>> response) {

                    if(!response.isSuccessful()){

                        Toast.makeText(SearchActivity.this,response.code(),Toast.LENGTH_SHORT).show();
                        return;
                    }

                    List<BreweryModel> breweries = response.body();
                    BreweryAdapter breweryAdapter = new BreweryAdapter(SearchActivity.this,breweries);
                    recyclerView.setAdapter(breweryAdapter);

                }

                @Override
                public void onFailure(Call<List<BreweryModel>> call, Throwable t) {
                    Toast.makeText(SearchActivity.this,t.getMessage(),Toast.LENGTH_SHORT).show();
                }
            });


        }





    }
}