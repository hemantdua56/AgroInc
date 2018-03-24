/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.hemant.agroinc;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

/**
 * Fragment that displays "Tuesday".
 */
public class WeatherFragment extends Fragment {
    TextView cityField, detailsField, currentTemperatureField, humidity_field, pressure_field, weatherIcon;

    Typeface weatherFont;
    public static final String MY_PREFS_NAME = "MyPrefsFile";
    String latitude;
    String longitude;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_weathercopy, container, false);
        weatherFont = Typeface.createFromAsset(getActivity().getAssets(), "fonts/weathericons-regular-webfont.ttf");

        cityField = (TextView) view.findViewById(R.id.city_field);
        detailsField = (TextView) view.findViewById(R.id.details_field);
        currentTemperatureField = (TextView) view.findViewById(R.id.current_temperature_field);
        humidity_field = (TextView) view.findViewById(R.id.humidity_field);
        pressure_field = (TextView) view.findViewById(R.id.pressure_field);
        weatherIcon = (TextView) view.findViewById(R.id.weather_icon);
        weatherIcon.setTypeface(weatherFont);


        FunctionForWeather.placeIdTask asyncTask = new FunctionForWeather.placeIdTask(new FunctionForWeather.AsyncResponse() {
            public void processFinish(String weather_city, String weather_description, String weather_temperature, String weather_humidity, String weather_pressure, String weather_updatedOn, String weather_iconText, String sun_rise) {



                detailsField.setText(weather_description);
                currentTemperatureField.setText(weather_temperature);
                humidity_field.setText("Humidity: " + weather_humidity);
                pressure_field.setText("Pressure: " + weather_pressure);
                weatherIcon.setText(Html.fromHtml(weather_iconText));

            }
        });

        SharedPreferences prefs = getActivity().getSharedPreferences(MY_PREFS_NAME, Context.MODE_PRIVATE);

            longitude = prefs.getString("longitude", "No name defined");//"No name defined" is the default value.
             latitude = prefs.getString("latitude", ""); //0 is the default value.




// setting location to weather
        asyncTask.execute(latitude, longitude); //  asyncTask.execute("Latitude", "Longitude")
        try {
            Geocoder geocoder = new Geocoder(getActivity(), Locale.getDefault());
            List<Address> addresses = geocoder.getFromLocation(Double.valueOf(latitude),Double.valueOf( longitude), 1);
            cityField.setText(cityField.getText() + "\n"+addresses.get(0).getAddressLine(0));
        }catch(Exception e)
        {

        }


        final SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipelayout);
        swipeRefreshLayout.setColorSchemeResources(R.color.refresh, R.color.refresh1, R.color.refresh2);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(true);
                (new Handler()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeRefreshLayout.setRefreshing(false);




                        FunctionForWeather.placeIdTask asyncTask = new FunctionForWeather.placeIdTask(new FunctionForWeather.AsyncResponse() {
                            public void processFinish(String weather_city, String weather_description, String weather_temperature, String weather_humidity, String weather_pressure, String weather_updatedOn, String weather_iconText, String sun_rise) {



                                detailsField.setText(weather_description);
                                currentTemperatureField.setText(weather_temperature);
                                humidity_field.setText("Humidity: " + weather_humidity);
                                pressure_field.setText("Pressure: " + weather_pressure);
                                weatherIcon.setText(Html.fromHtml(weather_iconText));

                            }
                        });

                        SharedPreferences prefs = getActivity().getSharedPreferences(MY_PREFS_NAME, Context.MODE_PRIVATE);

                        longitude = prefs.getString("longitude", "No name defined");//"No name defined" is the default value.
                        latitude = prefs.getString("latitude", ""); //0 is the default value.




// setting location to weather
                        asyncTask.execute(latitude, longitude); //  asyncTask.execute("Latitude", "Longitude")
                        try {
                            cityField=null;
                            Geocoder geocoder = new Geocoder(getContext(), Locale.getDefault());
                            List<Address> addresses = geocoder.getFromLocation(Double.valueOf(latitude),Double.valueOf( longitude), 1);
                            cityField.setText(cityField.getText() + "\n"+addresses.get(0).getAddressLine(0));
                        }catch(Exception e)
                        {

                        }

                    }
                },3000);
            }
        });
        return view;
    }

}

