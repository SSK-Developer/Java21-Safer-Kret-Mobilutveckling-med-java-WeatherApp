package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button getTodaysWeatherBtn;
    EditText edTodayCityInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getTodaysWeatherBtn = findViewById(R.id.getTodaysWeatherBtn);
        edTodayCityInput = findViewById(R.id.edTodayCityInput);

        getTodaysWeatherBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                intent.putExtra("TodayCityInput", edTodayCityInput.getText().toString());
                startActivity(intent);
            }
        });
    }
}