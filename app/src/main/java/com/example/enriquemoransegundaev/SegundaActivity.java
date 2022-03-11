package com.example.enriquemoransegundaev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SegundaActivity extends AppCompatActivity {

    private SharedPreferences preferencias;
    private EditText et2;
    private Button bt2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        //obtenemos las referencias
        preferencias = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        et2 = findViewById(R.id.et2);
        bt2 = findViewById(R.id.bt2);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guardarEdad();
                siguiente();
            }
        });


    }


    public void guardarEdad() {
        // con el editor modificamos
        SharedPreferences.Editor editor = preferencias.edit();
        String miEdad = et2.getText().toString();
        editor.putString("keyEdad", miEdad);
        editor.commit();
    }


    private void siguiente() {
        // recogiendo información de la EditText
        String edad = et2.getText().toString();

        if (et2.equals("")) {
            Toast toast = Toast.makeText(getApplicationContext(), "Introduzca dato", Toast.LENGTH_SHORT);
            toast.show();
        } else {
            // creando Intent

            String nombre = getIntent().getExtras().getString("keynombre");
            String apellido = getIntent().getExtras().getString("keyapellido");

            Intent intent = new Intent(this, TerceraActivity.class);
            intent.putExtra("keyedad", edad);
            intent.putExtra("keynombre", nombre);
            intent.putExtra("keyapellido", apellido);


            // iniciando actividad
            startActivity(intent);

            // finalizando actividad
            this.finish();
        }
    }


}