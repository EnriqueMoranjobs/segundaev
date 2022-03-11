package com.example.enriquemoransegundaev;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class CuartaActivity extends AppCompatActivity {
     private TextView tvfinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuarta);
        tvfinal=findViewById(R.id.tvFinal);



        String nombre = getIntent().getExtras().getString("keynombre");
        String apellido = getIntent().getExtras().getString("keyapellido");
        String edad = getIntent().getExtras().getString("keyedad");
        String email = getIntent().getExtras().getString("keyemail");

        String total = nombre+apellido+edad+email;

        tvfinal.setText(total);




    }
}