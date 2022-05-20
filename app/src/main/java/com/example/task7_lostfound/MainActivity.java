package com.example.task7_lostfound;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    Button createButton;
    Button viewItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createButton = findViewById(R.id.button);
        viewItems = findViewById(R.id.button2);


        createButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent createAdvert = new Intent(MainActivity.this, CreateAdvert.class);
                startActivity(createAdvert);
            }
        });

        viewItems.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent displayItems = new Intent(MainActivity.this, DisplayItems.class);
                startActivity(displayItems);
            }
        });
    }
}