package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Main2Activity_exo4 extends AppCompatActivity implements SensorEventListener {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2_exo4);

        textView = (TextView) findViewById(R.id.textView);
    }

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
                textView.setText("direction: droite");
            }

            if (x>0){
                Log.d("direction","gauche");
                textView.setText("direction: gauche");
            }

            if (y<0){
                Log.d("direction","bas");
                textView.setText("direction: bas");
            }

            if (y>0){
                Log.d("direction","haut");
                textView.setText("direction: haut");
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
