package com.example.enriquemoransegundaev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText etN, etA;
    private SQLiteDatabase bd;
   private Button buton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buton= findViewById(R.id.btnAlta);
        etN = findViewById(R.id.etNombre);
        etA = findViewById(R.id.etApellido);


        AdminSQLite adminSQLite = new AdminSQLite(this, "personas", null, 1);
        bd = adminSQLite.getWritableDatabase();


        buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                altaSQL();
                siguiente();
            }
        });
    }


    public void altaSQL() {
        // si la bd se abrio correctamente
        if (bd != null) {
            String name = etN.getText().toString();
            String apellido = etA.getText().toString();
            String sql;
            sql = "INSERT INTO persona VALUES('" + name + "','" + apellido + "')";
            bd.execSQL(sql);
            Toast.makeText(this, "Se cargaron los datos", Toast.LENGTH_SHORT).show();
        }
    }

    private void siguiente () {
        // recogiendo información de la EditText
        String nombre = etN.getText().toString();
        String apellido = etA.getText().toString();

        if (etN.equals("")) {
            Toast toast = Toast.makeText(getApplicationContext(), "Introduzca dato", Toast.LENGTH_SHORT);
            toast.show();
        } else {
            // creando Intent
            Intent intent = new Intent(this, SegundaActivity.class);
            intent.putExtra("keynombre", nombre);
            intent.putExtra("keyapellido", apellido);

            // iniciando actividad
            startActivity(intent);

            // finalizando actividad
            this.finish();
        }
    }


}