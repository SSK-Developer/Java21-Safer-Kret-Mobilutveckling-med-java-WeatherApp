package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;

public class MainActivity4 extends AppCompatActivity {

    //api.openweathermap.org/data/2.5/forecast?q={city name}&appid={API key}
    private final String url = "https://api.openweathermap.org/data/2.5/forecast";
    private final String appid = "beb6e0b3168d890265d204cb9f18c34b";
    DecimalFormat df = new DecimalFormat("#.##");
    TextView day1, day2,day3,day4,day5,day6,day7,sevenDayCityAndCountry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        day1 = findViewById(R.id.day1);
        day2 = findViewById(R.id.day2);
        day3 = findViewById(R.id.day3);
        day4 = findViewById(R.id.day4);
        day5 = findViewById(R.id.day5);
        day6 = findViewById(R.id.day6);
        day7 = findViewById(R.id.day7);
        sevenDayCityAndCountry = findViewById(R.id.sevenDayCityAndCountry);

        String cityInput = getIntent().getStringExtra("7DayCityInput");

        String city = cityInput;
        if (city.equals("")) {
            Toast.makeText(MainActivity4.this, "You must enter a city", Toast.LENGTH_SHORT).show();
        } else {

            String tempUrl = url + "?q=" + city + "&appid=" + appid;

            StringRequest stringRequest = new StringRequest(Request.Method.POST, tempUrl, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        JSONObject jsonResponse = new JSONObject(response);

                        JSONArray jsonArray = jsonResponse.getJSONArray("list");

                        //Day 1
                        JSONObject jsonObjectWeather1 = jsonArray.getJSONObject(0);
                        JSONObject jsonObjectMain1 = jsonObjectWeather1.getJSONObject("main");
                        double temp1 = jsonObjectMain1.getDouble("temp") - 273.15;
                        day1.setText(df.format(temp1) + "C");

                        //Day 2
                        JSONObject jsonObjectWeather2 = jsonArray.getJSONObject(1);
                        JSONObject jsonObjectMain2 = jsonObjectWeather2.getJSONObject("main");
                        double tem2 = jsonObjectMain2.getDouble("temp") - 273.15;
                        day2.setText(df.format(tem2) + "C");

                        //Day 3
                        JSONObject jsonObjectWeather3 = jsonArray.getJSONObject(2);
                        JSONObject jsonObjectMain3 = jsonObjectWeather3.getJSONObject("main");
                        double temp3 = jsonObjectMain3.getDouble("temp") - 273.15;
                        day3.setText(df.format(temp3) + "C");

                        //Day 4
                        JSONObject jsonObjectWeather4 = jsonArray.getJSONObject(3);
                        JSONObject jsonObjectMain4 = jsonObjectWeather4.getJSONObject("main");
                        double temp4 = jsonObjectMain4.getDouble("temp") - 273.15;
                        day4.setText(df.format(temp4) + "C");

                        //Day 5
                        JSONObject jsonObjectWeather5 = jsonArray.getJSONObject(4);
                        JSONObject jsonObjectMain5 = jsonObjectWeather5.getJSONObject("main");
                        double temp5 = jsonObjectMain5.getDouble("temp") - 273.15;
                        day5.setText(df.format(temp5) + "C");

                        //Day 6
                        JSONObject jsonObjectWeather6 = jsonArray.getJSONObject(5);
                        JSONObject jsonObjectMain6 = jsonObjectWeather6.getJSONObject("main");
                        double temp6 = jsonObjectMain6.getDouble("temp") - 273.15;
                        day6.setText(df.format(temp6) + "C");

                        //Day 7
                        JSONObject jsonObjectWeather7 = jsonArray.getJSONObject(6);
                        JSONObject jsonObjectMain7 = jsonObjectWeather7.getJSONObject("main");
                        double temp7 = jsonObjectMain7.getDouble("temp") - 273.15;
                        day7.setText(df.format(temp7) + "C");


                        JSONObject jsonObjectCity = jsonResponse.getJSONObject("city");
                        String countryName = jsonObjectCity.getString("country");
                        String cityName = jsonObjectCity.getString("name");

                        sevenDayCityAndCountry.setText(cityName + "(" + countryName + ")");


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getApplicationContext(), error.toString().trim(), Toast.LENGTH_SHORT).show();
                }
            });
            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
            requestQueue.add(stringRequest);
        }

    }
}