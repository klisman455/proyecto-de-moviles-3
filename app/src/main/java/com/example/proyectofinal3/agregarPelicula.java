package com.example.proyectofinal3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class agregarPelicula extends AppCompatActivity {
    EditText etTitulo, etDescripcion, etAnho, etPoster;
    AppDatabaseDataSource dataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_pelicula);


        etTitulo = findViewById(R.id.etTitulo);
        etDescripcion = findViewById(R.id.etDescripcion);
        etAnho = findViewById(R.id.etAnho);
        etPoster = findViewById(R.id.etPoster);


        dataSource = new AppDatabaseDataSource(this);


    }

    public void agregar(View view) {
        String titulo, descripcion,poster;
        int anho;

        titulo = etTitulo.getText().toString();
        descripcion = etDescripcion.getText().toString();
        anho = Integer.parseInt(etAnho.getText().toString());
        poster = etPoster.getText().toString();

        Pelicula pelicula = new Pelicula(titulo, descripcion, anho, poster);
        dataSource.crearPelicula(pelicula);
        Toast.makeText(getApplicationContext(), "Se guardó", Toast.LENGTH_SHORT).show();


    }


    public void mostrar(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
        startActivity(intent);


    }
}