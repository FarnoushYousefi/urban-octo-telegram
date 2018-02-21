package com.example.android.tourguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView attraction_place = (TextView) findViewById(R.id.attraction_place);
        attraction_place.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent attraction_place = new Intent(MainActivity.this, AttractionPlace.class);
                startActivity(attraction_place);
            }
        });
        TextView restaurant = (TextView) findViewById(R.id.restaurant);
        restaurant.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent restaurant = new Intent(MainActivity.this, Restaurant.class);
                startActivity(restaurant);
            }
        });
        TextView museum = (TextView) findViewById(R.id.museum);
        museum.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent museum = new Intent(MainActivity.this, Museum.class);
                startActivity(museum);
            }
        });
        TextView historical_place = (TextView) findViewById(R.id.historical_place);
        historical_place.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent historical_place = new Intent(MainActivity.this, HistoricalFragment.class);
                startActivity(historical_place);
            }
        });
    }
}

