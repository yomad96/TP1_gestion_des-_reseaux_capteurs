package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;


public class MainActivity extends AppCompatActivity implements SensorEventListener {

    ListView LV_capteurs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Exercice 1
//        SensorManager sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
//        List<Sensor> liste = sensorManager.getSensorList(Sensor.TYPE_ALL);
//        LV_capteurs = (ListView) findViewById(R.id.listView);
//        ArrayList<String> listeName = new ArrayList<String>();
//        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, listeName);
//        LV_capteurs.setAdapter(adapter);
//
//        for (int i = 0 ; i < liste.size() ; i++)
//        {
//            listeName.add(liste.get(i).getName());
//            Log.d("TEST", "TEST");
//            adapter.notifyDataSetChanged();
//        }

        //Exercice 2
//        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
//        if (sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE) != null){
//            Log.d("capteur temperature", "temperature = oui");
//        } else {
//            Log.d("capteur temperature", "temperature = non");
//        }
//        if (sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) != null){
//            Log.d("capteur accelerometre", "accelerometre = oui");
//        } else {
//            Log.d("capteur accelerometre", "accelerometre = non");
//        }

    }

    //Exercice 3
//    @Override
//    protected void onResume() {
//        SensorManager sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
//        sensorManager.registerListener((SensorEventListener) this,sensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION),SensorManager.SENSOR_DELAY_UI);
//        super.onResume();
//    }
//
//    @Override
//    public void onSensorChanged(SensorEvent event) {
//
//        RelativeLayout relatLayout1 = findViewById(R.id.relatLayout);
//        // Récupérer les valeurs du capteur
//        float x, y, z;
//        if (event.sensor.getType() == Sensor.TYPE_LINEAR_ACCELERATION) {
//            x = event.values[0];
//            y = event.values[1];
//            z = event.values[2];
////            Log.d("Valeur de X", ""+x+"");
////            Log.d("Valeur de Y", ""+y+"");
//            Log.d("Valeur de Z", ""+z+"");
//
//            if (z==0){
//                relatLayout1.setBackgroundColor(Color.parseColor("#FF2D00"));//Red
//            }
//
//            if (0<z){
//                relatLayout1.setBackgroundColor(Color.parseColor("#04FF00"));//Green
//            }
//
//            if (z>1){
//                relatLayout1.setBackgroundColor(Color.parseColor("#000000"));//Black
//            }
//        }
//    }
//
//    @Override
//    public void onAccuracyChanged(Sensor sensor, int accuracy) {
//
//    }

    //Exercice 4
    @Override
    protected void onResume() {
        SensorManager sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        sensorManager.registerListener((SensorEventListener) this,sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),SensorManager.SENSOR_DELAY_UI);
        super.onResume();
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        // Récupére les valeurs du capteur
        float x, y, z;
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            x = event.values[0];
            y = event.values[1];

            if (x<0){
                Log.d("direction","droite");
            }

            if (x>0){
                Log.d("direction","gauche");
            }

            if (y<0){
                Log.d("direction","bas");
            }

            if (y>0){
                Log.d("direction","haut");
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
