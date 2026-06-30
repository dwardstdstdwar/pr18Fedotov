package com.example.pr18fedotov;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnTask2, btnTask3, btnTask4, btnTask5, btnTask6, btnTask7, btnTask8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTask2 = findViewById(R.id.btnTask2);
        btnTask3 = findViewById(R.id.btnTask3);
        btnTask4 = findViewById(R.id.btnTask4);
        btnTask5 = findViewById(R.id.btnTask5);
        btnTask6 = findViewById(R.id.btnTask6);
        btnTask7 = findViewById(R.id.btnTask7);
        btnTask8 = findViewById(R.id.btnTask8);

        btnTask2.setOnClickListener(v ->
                startActivity(new Intent(this, Task2Activity.class)));

        btnTask3.setOnClickListener(v ->
                startActivity(new Intent(this, Task3Activity.class)));

        btnTask4.setOnClickListener(v ->
                startActivity(new Intent(this, Task4Activity.class)));

        btnTask5.setOnClickListener(v ->
                startActivity(new Intent(this, Task5Activity.class)));

        btnTask6.setOnClickListener(v ->
                startActivity(new Intent(this, Task6Activity.class)));

        btnTask7.setOnClickListener(v ->
                startActivity(new Intent(this, Task7Activity.class)));

        btnTask8.setOnClickListener(v ->
                startActivity(new Intent(this, Task8Activity.class)));
    }
}
