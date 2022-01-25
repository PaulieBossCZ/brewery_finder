package com.example.breweryfinder.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.breweryfinder.Models.BreweryModel;
import com.example.breweryfinder.R;

import java.util.List;

//recycle view adapter pro brewery

public class BreweryAdapter extends RecyclerView.Adapter<BreweryAdapter.BreweryViewHolder> {
    List<BreweryModel> breweryList;
    Context context;

    public BreweryAdapter(Context context, List<BreweryModel> breweries){
        this.context = context;
        breweryList = breweries;
    }

    @NonNull
    @Override
    public BreweryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(context).inflate(R.layout.item,parent,false);


        return new BreweryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BreweryViewHolder holder, int position) {

        BreweryModel brewery = breweryList.get(position);
        holder.id.setText(brewery.getId());
        holder.name.setText(brewery.getName());
        holder.brewery_type.setText(brewery.getBrewery_type());
        holder.street.setText(brewery.getStreet());
        holder.address_2.setText(brewery.getAddress_2());
        holder.address_3.setText(brewery.getAddress_3());
        holder.city.setText(brewery.getCity());
        holder.county_province.setText(brewery.getCounty_province());
        holder.state.setText(brewery.getState());
        holder.postal_code.setText(brewery.getPostal_code());
        holder.country.setText(brewery.getCountry());
        holder.longitude.setText(brewery.getLongitude());
        holder.latitude.setText(brewery.getLatitude());
        holder.phone.setText(brewery.getPhone());
        holder.website_url.setText(brewery.getWebsite_url());
        holder.updated_at.setText(brewery.getUpdated_at());
        holder.created_at.setText(brewery.getCreated_at());

    }

    @Override
    public int getItemCount() {
        return breweryList.size();
    }

    public class BreweryViewHolder extends RecyclerView.ViewHolder{

        TextView id,name,brewery_type,street,address_2,address_3,city,county_province,state,postal_code,country,longitude,latitude,phone,website_url,updated_at,created_at;

        public BreweryViewHolder(@NonNull View itemView) {
            super(itemView);

            id = itemView.findViewById(R.id.itemID);
            name = itemView.findViewById(R.id.itemName);
            brewery_type = itemView.findViewById(R.id.itemBreweryType);
            street = itemView.findViewById(R.id.itemStreet);
            address_2 = itemView.findViewById(R.id.itemAddress_2);
            address_3 = itemView.findViewById(R.id.itemAddress_3);
            city = itemView.findViewById(R.id.itemCity);
            county_province = itemView.findViewById(R.id.itemCountyProvince);
            state = itemView.findViewById(R.id.itemState);
            postal_code = itemView.findViewById(R.id.itemPostalCode);
            country = itemView.findViewById(R.id.itemCountry);
            longitude = itemView.findViewById(R.id.itemLongitude);
            latitude = itemView.findViewById(R.id.itemLatitude);
            phone = itemView.findViewById(R.id.itemPhone);
            website_url = itemView.findViewById(R.id.itemWebsiteURL);
            updated_at = itemView.findViewById(R.id.itemUpdatedAt);
            created_at = itemView.findViewById(R.id.itemCreatedAt);






        }
    }
}
