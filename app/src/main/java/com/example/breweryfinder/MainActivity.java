package com.example.breweryfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.breweryfinder.Models.SearchModel;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    //nazvy promennych, ktere se predavaji z mainactivity do searchactivity
    public static final String EXTRA_SEARCH_TERM = "com.example.breweryfinder.EXTRA_SEARCH_TERM";
    public static final String EXTRA_SEARCH_BY = "com.example.breweryfinder.EXTRA_SEARCH_BY";

    Button SearchBtn;
    Button SearchByCityBtn;
    Button SearchByPostalCodeBtn;
    ImageButton SearchHistoryImageBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SearchBtn = findViewById(R.id.btnSearch);
        SearchByCityBtn = findViewById(R.id.btnSearchByCity);
        SearchByPostalCodeBtn = findViewById(R.id.btnSearchByPostal);
        SearchHistoryImageBtn = findViewById(R.id.searchHistoryImageBtn);


        //click listener pro tlacitko Search by name
        SearchBtn.setOnClickListener(v -> {


            EditText SearchTermEditText = findViewById(R.id.editTextSearch);
            String SearchTerm = SearchTermEditText.getText().toString();

            //integer hodnota pro urceni podle jakeho kriteria se bude vyhledavat; 1 - by name, 2 - by city, 3 - by postal code
            int SearchBy = 1;


            //vrati soucasny cas a datum
            String currentDateAndTime = java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());



            //kontrola, zda hledany vyraz neni prazdy retezec
            if (SearchTerm.equals("")){

                Toast.makeText(MainActivity.this,"Enter your search term!",Toast.LENGTH_SHORT).show();
            }
            else{

                //otevreni SearchActivity a predani hodnot
                Intent intent = new Intent(this,SearchActivity.class);
                intent.putExtra(EXTRA_SEARCH_TERM,SearchTerm);
                intent.putExtra(EXTRA_SEARCH_BY,SearchBy);
                startActivity(intent);

                //ulozeni hledaneho vyrazu do tabulky Room database (hledany vyraz, soucasny cas a datum)
                saveData(SearchTerm,currentDateAndTime);

            }




        });

        //click listener pro tlacitko Search by city
        SearchByCityBtn.setOnClickListener(v -> {


            EditText SearchTermEditText = findViewById(R.id.editTextSearch);
            String SearchTerm = SearchTermEditText.getText().toString();
            int SearchBy = 2;



            String currentDateAndTime = java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());


            if (SearchTerm.equals("")){

                Toast.makeText(MainActivity.this,"Enter your search term!",Toast.LENGTH_SHORT).show();
            }
            else{

            Intent intent = new Intent(this,SearchActivity.class);
            intent.putExtra(EXTRA_SEARCH_TERM,SearchTerm);
            intent.putExtra(EXTRA_SEARCH_BY,SearchBy);
            startActivity(intent);

            saveData(SearchTerm,currentDateAndTime);
            }

        });

        //click listener pro tlacitko Search by postal code
        SearchByPostalCodeBtn.setOnClickListener(v -> {



            EditText SearchTermEditText = findViewById(R.id.editTextSearch);
            String SearchTerm = SearchTermEditText.getText().toString();
            int SearchBy = 3;

            String currentDateAndTime = java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());

            if (SearchTerm.equals("")){

                Toast.makeText(MainActivity.this,"Enter your search term!",Toast.LENGTH_SHORT).show();
            }
            else {

            Intent intent = new Intent(this,SearchActivity.class);
            intent.putExtra(EXTRA_SEARCH_TERM,SearchTerm);
            intent.putExtra(EXTRA_SEARCH_BY,SearchBy);
            startActivity(intent);


            saveData(SearchTerm,currentDateAndTime);

             }

        });


        //click listener pro tlacitko na zobrazeni activity historie vyhledavani
        SearchHistoryImageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), GetSearchHistoryData.class);
                startActivity(intent);
            }
        });


    }

    //metoda pro ulozeni zaznamu hledaneho vyrazu do tablulky v Room Database
    private void saveData(String searchTerm,String time){


            SearchModel model = new SearchModel();
            model.setName(searchTerm);
            model.setDate(time);

            DatabaseClass.getDatabase(getApplicationContext()).getDao().insertAllData(model);


          //  Toast.makeText(this,"Data were stored",Toast.LENGTH_SHORT).show();



    }
}