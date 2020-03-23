package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;

public class Main2Activity_exo6 extends AppCompatActivity implements SensorEventListener {

    float p;
    SensorManager sensorManager;
    Sensor proximity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2_exo6);

        // Instancier le SensorManager
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        // Instancier le capteur de lumière
        proximity = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        Log.d("test", "TEST");
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener( this, proximity);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, proximity, SensorManager.SENSOR_DELAY_NORMAL);
    }


    @Override
    public void onSensorChanged(SensorEvent event) {
        // Mettre à jour uniquement dans le cas de notre capteur
        if (event.sensor.getType() == Sensor.TYPE_PROXIMITY) {
            // La valeur de la lumière
            p = event.values[0];

            if (p < 1){
                Log.d("distance du téléphone","le téléphone est près");
            }else{
                Log.d("distance du téléphone","le téléphone est loin");
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
