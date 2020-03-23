package com.example.myapplication;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.hardware.Sensor;
import java.util.ArrayList;
import java.util.List;
import android.hardware.SensorManager;
import android.os.Build;
import android.util.Log;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;



@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class MainActivity extends AppCompatActivity {

    ListView LV_capteurs;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Exercice 1
        SensorManager sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> liste = sensorManager.getSensorList(Sensor.TYPE_ALL);
        LV_capteurs = (ListView) findViewById(R.id.listView);
        ArrayList<String> listeName = new ArrayList<String>();
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, listeName);
        LV_capteurs.setAdapter(adapter);

        for (int i = 0 ; i < liste.size() ; i++)
        {
            listeName.add(liste.get(i).getName());
            Log.d("TEST", "TEST");
            adapter.notifyDataSetChanged();
        }

    }
}
