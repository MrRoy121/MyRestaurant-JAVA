package com.example.myrestaurant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class CartActivity extends AppCompatActivity {

    MyListAdapter adapter;
    ArrayList<model>myListData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        this.getSupportActionBar().hide();


        SharedPreferences preferences = getSharedPreferences("order_list", Context.MODE_PRIVATE);
        Set<String> fetch = preferences.getStringSet("data", null);

        myListData = new ArrayList<>();

        if(!(fetch == null)){
            Log.e("DATA", String.valueOf(fetch));
            for (String currentString : fetch) {
                Log.e("DATA", currentString);
                String[] separated = currentString.split(":");
                Log.e(separated[0], separated[1]+"\n"+separated[2]);
                myListData.add(new model(separated[0],separated[2], separated[1], String.valueOf(Float.parseFloat(separated[2])*Float.parseFloat(separated[1]))));
            }
            Log.e("DATA", String.valueOf(myListData.size()));
            RecyclerView recyclerView = findViewById(R.id.cart);
            adapter = new MyListAdapter(myListData);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(adapter);
        }


        SharedPreferences sh = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
        TextView total = findViewById(R.id.totals);
        DecimalFormat df = new DecimalFormat("#.##");
        total.setText(df.format(sh.getFloat("total", 0)));

        findViewById(R.id.clear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor myEdit = sh.edit();
                myEdit.putFloat("total",  0);
                myEdit.apply();
                SharedPreferences preferences = getSharedPreferences("order_list", Context.MODE_PRIVATE);
                preferences.edit().clear().apply();
                Toast.makeText(getApplicationContext(), "Cart Cleared!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }
}