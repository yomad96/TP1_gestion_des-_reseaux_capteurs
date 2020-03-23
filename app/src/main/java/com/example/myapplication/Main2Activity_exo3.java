package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.RelativeLayout;

public class Main2Activity_exo3 extends AppCompatActivity implements SensorEventListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2_exo3);
    }

    //Exercice 3
    @Override
    protected void onResume() {
        SensorManager sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        sensorManager.registerListener((SensorEventListener) this,sensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION),SensorManager.SENSOR_DELAY_UI);
        super.onResume();
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        RelativeLayout relatLayout1 = findViewById(R.id.relatLayout);
        // Récupérer les valeurs du capteur
        float x,y,z;
        if (event.sensor.getType() == Sensor.TYPE_LINEAR_ACCELERATION) {
            x = event.values[0];
            y = event.values[1];
            z = event.values[2];

            float acceleration = (x * x + y * y + z * z) / (SensorManager.GRAVITY_EARTH * SensorManager.GRAVITY_EARTH);

            Log.d("Valeur de Z", ""+z+"");

            if (acceleration < 1.5){
                relatLayout1.setBackgroundColor(Color.parseColor("#FF2D00"));//Red
            }

            if (acceleration<3){
                relatLayout1.setBackgroundColor(Color.parseColor("#04FF00"));//Green
            }

            if (acceleration>5){
                relatLayout1.setBackgroundColor(Color.parseColor("#000000"));//Black
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

}

