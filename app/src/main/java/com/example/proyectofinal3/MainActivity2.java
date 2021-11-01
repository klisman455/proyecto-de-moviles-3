package com.example.proyectofinal3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import java.util.List;

public class MainActivity2 extends AppCompatActivity {



    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = findViewById(R.id.new_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");


        AppDatabaseDataSource dataSource =new AppDatabaseDataSource(this);

        List<Pelicula> peliculas = dataSource.traerPelicula();

        ListAdapter adapter =new ListAdapter(peliculas,this);
        RecyclerView miRecycler =findViewById(R.id.myRecycler);
        miRecycler.setLayoutManager(new LinearLayoutManager(this));
        miRecycler.setAdapter(adapter);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                Intent intent = new Intent(getApplicationContext(), MainActivity3.class);
                startActivity(intent);
                return true;
            case R.id.item2:

                return true;
            case R.id.item3:
                Intent intentItem3 = new Intent(getApplicationContext(),agregarPelicula.class);
                startActivity(intentItem3);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }





    public void volverMenuu(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
    public void volverInicio2(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        finishAffinity();
    }

}





