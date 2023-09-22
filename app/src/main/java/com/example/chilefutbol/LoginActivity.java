package com.example.chilefutbol;

import  com.android.volley.Request.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

public class LoginActivity extends AppCompatActivity {
Button boton1;
Button boton2;

Button botoningresar;
EditText usuario,contrasena;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        boton1=findViewById(R.id.btnirRegistro);
        boton2=findViewById(R.id.btnSaltar);
        botoningresar=findViewById(R.id.btningreso);
        usuario=findViewById(R.id.txtusuario);
        contrasena=findViewById(R.id.txtcontrasena);
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), RegistroActivity.class);
                startActivity(intent);
            }

        });
        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }

        });


    }

    }
