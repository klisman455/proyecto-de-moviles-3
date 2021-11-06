package com.example.proyectofinal3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    FirebaseFirestore db;
    TextView tvId,etPasword;
    String idd, clave;
    String nombre;
    Button logiarse;
    String usuario;
    String pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = FirebaseFirestore.getInstance();
        tvId = findViewById(R.id.etId);
        etPasword = findViewById(R.id.etPasword);


    }
    public void pagRegistro(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity4.class);
        startActivity(intent);
    }


    public void login(View view) {
            String pass= etPasword.getText().toString();
            String nombre= tvId.getText().toString();



             db.collection("usuarios")
                     .whereEqualTo("nombre",nombre)
                     .get()
                     .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                         @Override
                         public void onComplete(@NonNull Task<QuerySnapshot> task) {
                           if(task.isSuccessful()) {
                               if (task.getResult().isEmpty()) {
                                   Log.d("REROR","usuario y/o contraseña no coinciden 1");
                               }else {

                                   for (QueryDocumentSnapshot document : task.getResult()) {
                                       if (pass.equals(document.getData().get("clave"))) {
                                           Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                                           startActivity(intent);
                                       }else{
                                           Log.d("REROR","usuaio y/o contraseña no coinciden2");
                                       }
                                   }
                               }
                           }else {
                               Log.e("EREROR","error getting docmuent", task.getException());
                           }

                         }
                     });



    }

}