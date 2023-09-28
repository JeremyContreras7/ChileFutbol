package com.example.chilefutbol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistroActivity extends AppCompatActivity {
    Button boton1;
    EditText nombre;
    EditText apellido;
    EditText correo;
    EditText contrasena;
    Button boton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro);
        boton1 = findViewById(R.id.btnvolverregistro);
        nombre = findViewById(R.id.txtnombre);
        apellido = findViewById(R.id.txtapellido);
        correo = findViewById(R.id.txtcorreo);
        contrasena = findViewById(R.id.txtcontrasena1);
        boton2 = findViewById(R.id.btnregistrar);


        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
