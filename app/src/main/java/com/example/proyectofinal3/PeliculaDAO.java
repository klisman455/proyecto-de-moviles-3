package com.example.proyectofinal3;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PeliculaDAO {
    @Query("SELECT * FROM pelicula")
    List<Pelicula> traerTodo();

    @Insert
    void addPelicula(Pelicula ... peliculas);

    @Delete
    void eliminarPelicula(Pelicula pelicula);

}
