package com.example.myrestaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class FoodListActivity extends AppCompatActivity {

    ListView simpleListView;
    String burger[] = {"Veg Burger", "Chicken Burger", "Beef Burger", "Egg Burger", "Fish Burger"};
    String indian[] = {"Aalu Parata", "Chicken Tikka", "Palak paneer", "Fish Curry"};
    String chinese[] = {"Fried Rice", "Chicken Soup", "Dumpling", "Chow Mein"};
    String drink[] = {"Coke", "Pepsi", "Fanta", "Red Bull"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);
        this.getSupportActionBar().hide();



        simpleListView = findViewById(R.id.simpleListView);
        Intent i = getIntent();
        if(i.getStringExtra("Select").equals("burger")){

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, android.R.id.text1, burger);
            simpleListView.setAdapter(adapter);

        }else if(i.getStringExtra("Select").equals("indian")){

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, android.R.id.text1, indian);
            simpleListView.setAdapter(adapter);

        }else if(i.getStringExtra("Select").equals("chinese")){

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, android.R.id.text1, chinese);
            simpleListView.setAdapter(adapter);

        }else if(i.getStringExtra("Select").equals("drinks")){

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, android.R.id.text1, drink);
            simpleListView.setAdapter(adapter);

        }

        simpleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String s = (String) parent.getItemAtPosition(position);
                Intent i = new Intent(FoodListActivity.this, FoodDetailsActivity.class);
                i.putExtra("s", s);
                startActivity(i);
            }
        });
        SharedPreferences sh = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
        TextView total = findViewById(R.id.total);
        DecimalFormat df = new DecimalFormat("#.##");
        total.setText(df.format(sh.getFloat("total", 0)));

        findViewById(R.id.cart).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), CartActivity.class));
            }
        });
    }

    @Override
    protected void onResume(){
        super.onResume();

        SharedPreferences sh = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
        TextView total = findViewById(R.id.total);
        total.setText(String.valueOf(sh.getFloat("total", 0)));

    }
}