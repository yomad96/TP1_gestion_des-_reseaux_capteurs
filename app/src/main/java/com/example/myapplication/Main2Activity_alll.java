package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity_alll extends AppCompatActivity {

    private Button btn_exo1;
    private Button btn_exo2;
    private Button btn_exo3;
    private Button btn_exo4;
    private Button btn_exo5;
    private Button btn_exo6;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2_alll);

        btn_exo1 = (Button) findViewById(R.id.btn_exo1);
        btn_exo2 = (Button) findViewById(R.id.btn_exo2);
        btn_exo3 = (Button) findViewById(R.id.btn_exo3);
        btn_exo4 = (Button) findViewById(R.id.btn_exo4);
        btn_exo5 = (Button) findViewById(R.id.btn_exo5);
        btn_exo6 = (Button) findViewById(R.id.btn_exo6);

        btn_exo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main2Activity_alll.this, MainActivity.class));
            }
        });

        btn_exo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main2Activity_alll.this, Main2Activity_exo2.class));
            }
        });

        btn_exo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main2Activity_alll.this, Main2Activity_exo3.class));
            }
        });

        btn_exo4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main2Activity_alll.this, Main2Activity_exo4.class));
            }
        });

        btn_exo5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main2Activity_alll.this, Main2Activity_exo5.class));
            }
        });

        btn_exo6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main2Activity_alll.this, Main2Activity_exo6.class));
            }
        });


    }
}
