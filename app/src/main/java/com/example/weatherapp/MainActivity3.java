package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity3 extends AppCompatActivity {

    Button get7DayForecastBtn;
    EditText ed7DayCityInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        get7DayForecastBtn = findViewById(R.id.get7DayForecastBtn);
        ed7DayCityInput = findViewById(R.id.ed7DayCityInput);

        get7DayForecastBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity4.class);
                intent.putExtra("7DayCityInput", ed7DayCityInput.getText().toString());
                startActivity(intent);
            }
        });

    }
}