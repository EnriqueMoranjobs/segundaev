package com.example.enriquemoransegundaev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class TerceraActivity extends AppCompatActivity {
    private SharedPreferences preferencias;
    EditText etmail;
    Button btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tercera);
        etmail=findViewById(R.id.etMail);
        btn3=findViewById(R.id.btn3);


        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                escribirMemoriaInterna();
                siguiente();
            }
        });
    }


    public void recuperarEdad() {
        String edad = preferencias.getString("keyEdad", "edad");
    }


    public void escribirMemoriaInterna() {
        try {
            FileOutputStream fos = openFileOutput("Fichero_prueba.txt", Context.MODE_PRIVATE);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osw);
            String cadena = etmail.getText().toString();
            bw.write(cadena);
            bw.close();
            osw.close();
            fos.close();
        } catch (java.io.IOException ex) {
            Log.e("Ficheros", "Error en escritura de fichero a memoria interna");
        }
    }

    private void siguiente() {
        // recogiendo información de la EditText
        String email = etmail.getText().toString();

        if (etmail.equals("")) {
            Toast toast = Toast.makeText(getApplicationContext(), "Introduzca dato", Toast.LENGTH_SHORT);
            toast.show();
        } else {
            // creando Intent

            String nombre = getIntent().getExtras().getString("keynombre");
            String apellido = getIntent().getExtras().getString("keyapellido");
            String edad = getIntent().getExtras().getString("keyedad");

            Intent intent = new Intent(this, CuartaActivity.class);
            intent.putExtra("keyemail", email);
            intent.putExtra("keynombre", nombre);
            intent.putExtra("keyapellido", apellido);
            intent.putExtra("keyedad", edad);

            // iniciando actividad
            startActivity(intent);

            // finalizando actividad
            this.finish();
        }
    }



}