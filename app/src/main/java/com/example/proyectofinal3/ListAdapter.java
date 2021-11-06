package com.example.proyectofinal3;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private List<Pelicula> misDatos;
    private LayoutInflater layoutInflater;
    private Context context;

    public ListAdapter(List<Pelicula> misDatos, Context context) {
        this.misDatos = misDatos;
        this.layoutInflater = LayoutInflater.from(context);
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.contenido, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.juntarData(misDatos.get(position),context);
    }

    @Override
    public int getItemCount() {
        return misDatos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView titulo, descripcion;

        ImageView poster;
        Button btEliminar, btVer;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.etTitulo);
            descripcion = itemView.findViewById(R.id.etDescripcion);
            poster = itemView.findViewById(R.id.etPoster);
            btEliminar = itemView.findViewById(R.id.btEliminar);
            btVer =itemView.findViewById(R.id.btVer);
        }

        public void juntarData(Pelicula item,Context context){
            String new_titulo= item.getTitulo()+ "("+item.getAnho()+")";
            titulo.setText(new_titulo);
            descripcion.setText(item.getDescripcion());

            String url = item.getPoster();
            Picasso.get().load(url).into(ViewHolder.this.poster);

            btEliminar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AppDatabaseDataSource dataSource = new AppDatabaseDataSource(view.getContext()) ;
                    dataSource.eliminarPelicula(item);
                }
            });
            btVer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(view.getContext(),MainActivity3.class);
                    intent.putExtra("id",item.getId());
                    view.getContext().startActivity(intent);
                }
            });
        }
    }

}
