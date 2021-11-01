package com.example.proyectofinal3;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Pelicula.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    private static final String DB_NAME = "peliculas.db";
    private static AppDatabase INSTANCIA = null;

    public static AppDatabase getInstance(Context context) {
        if(INSTANCIA == null){
            synchronized (AppDatabase.class){
                INSTANCIA = Room.databaseBuilder(
                        context.getApplicationContext(),
                        AppDatabase.class,
                        DB_NAME)
                        .allowMainThreadQueries()
                        .build();
            }
        }
        return INSTANCIA;
    }


    public abstract PeliculaDAO peliculaDAO();
}
