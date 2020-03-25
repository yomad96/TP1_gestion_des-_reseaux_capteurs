package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Main2Activity_exo2 extends AppCompatActivity {

    ListView LV_capteurs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2_exo2);

        LV_capteurs = (ListView) findViewById(R.id.listView);
        ArrayList<String> capteur = new ArrayList<String>();
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(Main2Activity_exo2.this, android.R.layout.simple_list_item_1, capteur);
        LV_capteurs.setAdapter(adapter);

        //Exercice 2
        SensorManager sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        if (sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE) != null){
            Log.d("capteur temperature", "temperature = oui");
            capteur.add("capteur temperature : oui");
            adapter.notifyDataSetChanged();
        } else {
            Log.d("capteur temperature", "temperature = non");
            capteur.add("capteur temperature : non");
            adapter.notifyDataSetChanged();
        }
        if (sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) != null){
            Log.d("capteur accelerometre", "accelerometre = oui");
            capteur.add("capteur accelerometre : oui");
            adapter.notifyDataSetChanged();
        } else {
            Log.d("capteur accelerometre", "accelerometre = non");
            capteur.add("capteur accelerometre : oui");
            adapter.notifyDataSetChanged();
        }
    }
}
