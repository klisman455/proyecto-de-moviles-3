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

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    FirebaseFirestore db;
    TextView tvId,etPasword;
    String idd, clave;
    String nombre;
    Button logiarse;
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
            String num1= etPasword.getText().toString();
            String id= tvId.getText().toString();

            if( etPasword !=null )
                {

             db.collection("usuarios")
                     .document(id)
                     .get()
                     .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                         @Override
                         public void onSuccess(DocumentSnapshot documentSnapshot) {

                             if (Integer.parseInt(documentSnapshot.getData().get("clave").toString()) == Integer.parseInt(num1)) {
                                 Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                                 startActivity(intent);

                             } else {

                                 Toast.makeText(getApplicationContext(), "vuelva a ingresar la contraseña o el usuario", Toast.LENGTH_SHORT).show();

                             }

                         }
                     })
                     .addOnFailureListener(new OnFailureListener() {
                         @Override
                         public void onFailure(@NonNull Exception e) {
                             Log.w("app", "error al traer document", e);
                         }
                     });
         }else{

                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent); }
    }
}