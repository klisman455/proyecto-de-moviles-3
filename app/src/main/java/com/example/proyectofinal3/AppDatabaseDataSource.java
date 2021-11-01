package com.example.proyectofinal3;

import android.content.Context;

import java.util.List;

public class AppDatabaseDataSource {

    private final PeliculaDAO peliculaDAO;

    public AppDatabaseDataSource(Context context) {
        AppDatabase baseDatos = AppDatabase.getInstance(context);
        peliculaDAO = baseDatos.peliculaDAO();
    }

    public void crearPelicula(Pelicula pelicula){
        peliculaDAO.addPelicula(pelicula);
    }

    public List<Pelicula> traerPelicula(){
        return peliculaDAO.traerTodo();
    }

   public void eliminarPelicula(Pelicula pelicula){
        peliculaDAO.eliminarPelicula(pelicula);
   }
}
