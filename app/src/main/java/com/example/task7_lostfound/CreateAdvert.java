package com.example.task7_lostfound;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.task7_lostfound.data.DatabaseHelper;
import com.example.task7_lostfound.model.Item;

public class CreateAdvert extends AppCompatActivity {
    TextView name;
    TextView phone;
    TextView description;
    TextView date;
    TextView location;
    Button save;
    RadioButton lost;
    RadioButton found;
    DatePickerDialog dpDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_advert);
        name = findViewById(R.id.nameEntry);
        phone = findViewById(R.id.phoneEntry);
        description = findViewById(R.id.descriptionEntry);
        date = findViewById(R.id.dateEntry);
        location = findViewById(R.id.locationEntry);
        save = findViewById(R.id.button3);
        lost = findViewById(R.id.radioButton);
        found = findViewById(R.id.radioButton2);
        DatabaseHelper db = new DatabaseHelper(CreateAdvert.this);

        lost.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(found.isChecked()){
                    found.setChecked(false);
                }
            }
        });

        found.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (lost.isChecked()) {
                    lost.setChecked(false);
                }
            }
        });
        save.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String lostFound = (lost.isChecked()) ? "Lost" : "Found";
                Item item = new Item(name.getText().toString(), phone.getText().toString(), description.getText().toString(), date.getText().toString(), location.getText().toString(), lostFound);
                db.insertItem(item);
                Toast.makeText(CreateAdvert.this, "Item submitted", Toast.LENGTH_SHORT).show();
            }
        });
    }
}