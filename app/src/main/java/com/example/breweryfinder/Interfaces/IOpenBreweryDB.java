package com.example.breweryfinder.Interfaces;

import com.example.breweryfinder.Models.BreweryModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IOpenBreweryDB {

    //retrofit rozhrani pro vytvareni get pozadavku pro OpenBreweryDB api

    @GET("breweries")
    Call<List<BreweryModel>> getBreweryByName(@Query("by_name") String name);

    @GET("breweries")
    Call<List<BreweryModel>> getBreweryByCity(@Query("by_city") String city);

    @GET("breweries")
    Call<List<BreweryModel>> getBreweryByPostalCode(@Query("by_postal") String postal_code);



}
