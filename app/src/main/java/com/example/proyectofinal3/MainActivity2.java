package com.example.proyectofinal3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void buscara1(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity3.class);
        startActivity(intent);
    }
}