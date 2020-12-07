package com.example.myrestaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FoodDetailsActivity extends AppCompatActivity {

    HashMap<String, Object> vegburger, chickenburger, beefburger, fishburger, eggburger, aaluparatha, chickentikka, palakpaneer, fishcurry;
    HashMap<String, Object> friedrice, chickensoup, dumplings, chowmein, coke, pepsi, fanta, redbull;

    ImageView img;
    TextView name, des, price;
    EditText quan;
    Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_details);
        this.getSupportActionBar().hide();
        init();

        name = findViewById(R.id.name);
        des = findViewById(R.id.des);
        price = findViewById(R.id.price);
        img = findViewById(R.id.img);
        quan = findViewById(R.id.quan);
        add = findViewById(R.id.add);

        declear();

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!quan.getText().toString().equals("")){

                    SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);

                    SharedPreferences.Editor myEdit = sharedPreferences.edit();
                    myEdit.putFloat("total",  sharedPreferences.getFloat("total",0)+(Float.parseFloat(price.getText().toString())*Float.parseFloat(quan.getText().toString())));
                    myEdit.apply();


                    SharedPreferences preferences = getSharedPreferences("order_list", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor=preferences.edit();

                    Set<String> input = preferences.getStringSet("data", new HashSet<String>());

                    input.add(name.getText().toString()+":"+price.getText().toString()+":"+quan.getText().toString());
                    editor.putStringSet("data", input);
                    Log.e("DATA", String.valueOf(input));
                    editor.apply();
                    Toast.makeText(getApplicationContext(), "1 Item Added to the Cart!!", Toast.LENGTH_SHORT).show();
                    finish();
                }else{
                    Toast.makeText(FoodDetailsActivity.this, "Please Provide The Quantity!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void init(){

        vegburger = new HashMap<>();
        vegburger.put("name", "Veg Burger");
        vegburger.put("description", "Crispy Vegetable Patty with Cheese, Tomatoes, Mushrooms and ranch dressing.");
        vegburger.put("img", R.drawable.vegburger);
        vegburger.put("price", 9.99);

        chickenburger = new HashMap<>();
        chickenburger.put("description", "Crispy Chicken with Cheese, Tomatoes, Mushrooms and ranch dressing");
        chickenburger.put("img", R.drawable.chickenburger);
        chickenburger.put("price", 14.99);
        chickenburger.put("name", "Chicken Burger");

        beefburger = new HashMap<>();
        beefburger.put("description", "Crispy Beef with Cheese, Tomatoes, Mushrooms and ranch dressing");
        beefburger.put("img", R.drawable.beefburger);
        beefburger.put("price", 24.99);
        beefburger.put("name", "Beef Burger");


        fishburger = new HashMap<>();
        fishburger.put("description", "Crispy Fish with Cheese, Tomatoes, Mushrooms and ranch dressing");
        fishburger.put("img", R.drawable.fishburger);
        fishburger.put("price", 19.99);
        fishburger.put("name", "Fish Burger");


        eggburger = new HashMap<>();
        eggburger.put("description", "Crispy Egg with Cheese, Tomatoes, Mushrooms and ranch dressing");
        eggburger.put("img", R.drawable.eggburger);
        eggburger.put("price", 9.99);
        eggburger.put("name", "Egg Burger");


        aaluparatha = new HashMap<>();
        aaluparatha.put("description", "Aloo means potato and paratha means stuffed flatbread in Hindi, so the name is quite telling: aloo paratha is an unleavened whole wheat flatbread stuffed with a savory spiced potato mixture.");
        aaluparatha.put("img", R.drawable.aalooparatha);
        aaluparatha.put("price", 14.99);
        aaluparatha.put("name", "Aloo paratha");

        chickentikka = new HashMap<>();
        chickentikka.put("description", "Chicken tikka is a chicken dish originating in the Indian subcontinent during the Mughal era. The dish is popular in India.");
        chickentikka.put("img", R.drawable.chickentikka);
        chickentikka.put("price", 9.99);
        chickentikka.put("name", "Chicken Tikka");

        palakpaneer = new HashMap<>();
        palakpaneer.put("description", "Palak paneer is a vegetarian dish, consisting of paneer in a thick paste made from pureed spinach, called palak in Hindi, Marathi, Gujarati, and other Indian languages. ");
        palakpaneer.put("img", R.drawable.palakpaneer);
        palakpaneer.put("price", 9.99);
        palakpaneer.put("name", "Palak Paneer");

        fishcurry = new HashMap<>();
        fishcurry.put("description", "Fish Curry is an Indian also Goan dish. It consists of sardines semi-stewed in a India.");
        fishcurry.put("img", R.drawable.fishcurry);
        fishcurry.put("price", 24.99);
        fishcurry.put("name", "Fish Curry");

        friedrice = new HashMap<>();
        friedrice.put("description", "Fried rice is a dish of cooked rice that has been stir-fried in a wok or a frying pan and is usually mixed with other ingredients such as eggs, vegetables, seafood, or meat.");
        friedrice.put("img", R.drawable.friedrice);
        friedrice.put("price", 9.99);
        friedrice.put("name", "Fried Rice");

        chickensoup = new HashMap<>();
        chickensoup.put("description", "Chicken soup is a soup made from chicken, simmered in water, usually with various other ingredients.");
        chickensoup.put("img", R.drawable.chickensoup);
        chickensoup.put("price", 14.99);
        chickensoup.put("name", "Chicken Soup");

        dumplings = new HashMap<>();
        dumplings.put("description", "Dumpling is a broad class of dishes that consist of pieces of dough, often wrapped around a filling. The dough can be based on bread, flour.");
        dumplings.put("img", R.drawable.dumplings);
        dumplings.put("price", 4.99);
        dumplings.put("name", "Dumplings");

        chowmein = new HashMap<>();
        chowmein.put("description", "Chow mein is a dish of Chinese stir-fried noodles with vegetables and sometimes meat or tofu.");
        chowmein.put("img", R.drawable.chowmein);
        chowmein.put("price", 9.99);
        chowmein.put("name", "Chow Mein");

        coke = new HashMap<>();
        coke.put("description", "Coca-Cola, or Coke, is a carbonated soft drink manufactured by the Coca-Cola Company. Originally marketed as a temperance drink and intended as a patent medicine.");
        coke.put("img", R.drawable.coke);
        coke.put("price", 4.99);
        coke.put("name", "Coke");

        pepsi = new HashMap<>();
        pepsi.put("description", "Pepsi is a carbonated soft drink manufactured by PepsiCo. Originally created and developed in 1893 by Caleb Bradham and introduced as Brad's Drink.");
        pepsi.put("img", R.drawable.pepsi);
        pepsi.put("price", 4.99);
        pepsi.put("name", "Pepsi");

        fanta = new HashMap<>();
        fanta.put("description", "Fanta is a brand of fruit-flavored carbonated soft drinks created by Coca-Cola Deutschland under the leadership of German businessman Max Keith.");
        fanta.put("img", R.drawable.fanta);
        fanta.put("price", 4.99);
        fanta.put("name", "Fanta");

        redbull = new HashMap<>();
        redbull.put("description", "Red Bull is a brand of energy drinks sold by Austrian company Red Bull GmbH.");
        redbull.put("img", R.drawable.redbull);
        redbull.put("price", 4.99);
        redbull.put("name", "Red Bull");
    }

    public void declear(){

        Intent i = getIntent();
        if(i.getStringExtra("s").equals("Veg Burger")){
            name.setText(String.valueOf(vegburger.get("name")));
            des.setText(String.valueOf(vegburger.get("description")));
            price.setText(""+vegburger.get("price"));
            img.setImageResource(Integer.parseInt(String.valueOf(vegburger.get("img"))));
        }else if(i.getStringExtra("s").equals("Chicken Burger")){
            name.setText(String.valueOf(chickenburger.get("name")));
            des.setText(String.valueOf(chickenburger.get("description")));
            price.setText(""+chickenburger.get("price"));
            img.setImageResource(Integer.parseInt(String.valueOf(chickenburger.get("img"))));
        }else if(i.getStringExtra("s").equals("Beef Burger")){
            name.setText(String.valueOf(beefburger.get("name")));
            des.setText(String.valueOf(beefburger.get("description")));
            price.setText(""+beefburger.get("price"));
            img.setImageResource(Integer.parseInt(String.valueOf(beefburger.get("img"))));
        }else if(i.getStringExtra("s").equals("Fish Burger")){
            name.setText(String.valueOf(fishburger.get("name")));
            des.setText(String.valueOf(fishburger.get("description")));
            price.setText(""+fishburger.get("price"));
            img.setImageResource(Integer.parseInt(String.valueOf(fishburger.get("img"))));
        }else if(i.getStringExtra("s").equals("Egg Burger")){
            name.setText(String.valueOf(eggburger.get("name")));
            des.setText(String.valueOf(eggburger.get("description")));
            price.setText(""+eggburger.get("price"));
            img.setImageResource(Integer.parseInt(String.valueOf(eggburger.get("img"))));
        }else if(i.getStringExtra("s").equals("Aalu Parata")){
            name.setText(String.valueOf(aaluparatha.get("name")));
            des.setText(String.valueOf(aaluparatha.get("description")));
            price.setText(""+aaluparatha.get("price"));
            img.setImageResource(Integer.parseInt(String.valueOf(aaluparatha.get("img"))));
        }else if(i.getStringExtra("s").equals("Chicken Tikka")){
            name.setText(String.valueOf(chickentikka.get("name")));
            des.setText(String.valueOf(chickentikka.get("description")));
            price.setText(""+chickentikka.get("price"));
            img.setImageResource(Integer.parseInt(String.valueOf(chickentikka.get("img"))));
        }else if(i.getStringExtra("s").equals("Palak paneer")){
            name.setText(String.valueOf(palakpaneer.get("name")));
            des.setText(String.valueOf(palakpaneer.get("description")));
            price.setText(""+palakpaneer.get("price"));
            img.setImageResource(Integer.parseInt(String.valueOf(palakpaneer.get("img"))));
        }else if(i.getStringExtra("s").equals("Fish Curry")){
            name.setText(String.valueOf(fishcurry.get("name")));
            des.setText(String.valueOf(fishcurry.get("description")));
            price.setText(""+fishcurry.get("price"));
            img.setImageResource(Integer.parseInt(String.valueOf(fishcurry.get("img"))));
        }else if(i.getStringExtra("s").equals("Fried Rice")){
            name.setText(String.valueOf(friedrice.get("name")));
            des.setText(String.valueOf(friedrice.get("description")));
            price.setText(""+friedrice.get("price"));
            img.setImageResource(Integer.parseInt(String.valueOf(friedrice.get("img"))));
        }else if(i.getStringExtra("s").equals("Chicken Soup")){
            name.setText(String.valueOf(chickensoup.get("name")));
            des.setText(String.valueOf(chickensoup.get("description")));
            price.setText(""+chickensoup.get("price"));
            img.setImageResource(Integer.parseInt(String.valueOf(chickensoup.get("img"))));
        }else if(i.getStringExtra("s").equals("Dumpling")){
            name.setText(String.valueOf(dumplings.get("name")));
            des.setText(String.valueOf(dumplings.get("description")));
            price.setText(""+dumplings.get("price"));
            img.setImageResource(Integer.parseInt(String.valueOf(dumplings.get("img"))));
        }else if(i.getStringExtra("s").equals("Chow Mein")){
            name.setText(String.valueOf(chowmein.get("name")));
            des.setText(String.valueOf(chowmein.get("description")));
            price.setText(""+chowmein.get("price"));
            img.setImageResource(Integer.parseInt(String.valueOf(chowmein.get("img"))));
        }else if(i.getStringExtra("s").equals("Coke")){
            name.setText(String.valueOf(coke.get("name")));
            des.setText(String.valueOf(coke.get("description")));
            price.setText(""+coke.get("price"));
            img.setImageResource(Integer.parseInt(String.valueOf(coke.get("img"))));
        }else if(i.getStringExtra("s").equals("Pepsi")){
            name.setText(String.valueOf(pepsi.get("name")));
            des.setText(String.valueOf(pepsi.get("description")));
            price.setText(""+pepsi.get("price"));
            img.setImageResource(Integer.parseInt(String.valueOf(pepsi.get("img"))));
        }else if(i.getStringExtra("s").equals("Fanta")){
            name.setText(String.valueOf(fanta.get("name")));
            des.setText(String.valueOf(fanta.get("description")));
            price.setText(""+fanta.get("price"));
            img.setImageResource(Integer.parseInt(String.valueOf(fanta.get("img"))));
        }else if(i.getStringExtra("s").equals("Red Bull")){
            name.setText(String.valueOf(redbull.get("name")));
            des.setText(String.valueOf(redbull.get("description")));
            price.setText(""+redbull.get("price"));
            img.setImageResource(Integer.parseInt(String.valueOf(redbull.get("img"))));
        }
    }

}