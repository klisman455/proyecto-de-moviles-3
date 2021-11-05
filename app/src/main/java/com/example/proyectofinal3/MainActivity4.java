package com.example.proyectofinal3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MainActivity4 extends AppCompatActivity {

    EditText etNombre, etPais,etContraseña,NombreUsuario,NumeroUsuario,CCV;
    FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);


        etNombre = findViewById(R.id.etNombre);
        etPais = findViewById(R.id.etPais);
        etContraseña = findViewById(R.id.etContraseña);
        NombreUsuario = findViewById(R.id.etNombreUsuario);
        NumeroUsuario =findViewById(R.id.cardNumber);
        CCV =findViewById(R.id.CCV);



        db = FirebaseFirestore.getInstance();

        db.collection("usuarios")
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        for (QueryDocumentSnapshot usuario: Objects.requireNonNull(task.getResult())) {


                        }

                    } else {
                        Log.w("App", "error de documentos", task.getException());
                    }
                });
    }


    public void guardar(View view) {
        String nombre = etNombre.getText().toString();
        String pais = etPais.getText().toString();
        String clave = etContraseña.getText().toString();
        String nombreUsuario = NombreUsuario.getText().toString();
        int numeroUsuario =Integer.parseInt(NumeroUsuario.getText().toString());
        int ccv =Integer.parseInt(CCV.getText().toString());

        Map<String, Object> usuario = new HashMap<>();
        usuario.put("nombre", nombre);
        usuario.put("precio", pais);
        usuario.put("clave", clave);
        usuario.put("NombreUsuario",nombreUsuario);
        usuario.put("NumeroUsuario",numeroUsuario);
        usuario.put("CCV",ccv);

        db.collection("usuarios")
                .add(usuario)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(getApplicationContext(),"Guardado con id"+documentReference.getId(), Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("Error", "Error adding document", e);
                    }
                });

    }
    public void aceptarContinuar(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        finishAffinity();
    }
}