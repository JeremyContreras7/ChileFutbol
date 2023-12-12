package com.example.chilefutbol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class  MainActivity extends AppCompatActivity {
    ImageButton boton1;
    ImageButton boton2;
    ImageButton boton3;

    Button boton4;
    Button boton5,boton6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boton1=findViewById(R.id.btnColo);
        boton2=findViewById(R.id.btnU);
        boton3=findViewById(R.id.btnlogeovolver);
        boton4=findViewById(R.id.btnpartido);
        boton5=findViewById(R.id.btnProfile);
        boton6=findViewById(R.id.btngohan);

        boton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), EnfrentamientosActivity.class);
                startActivity(intent);
            }

        });
        boton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), ProfileActivity.class);
                startActivity(intent);
            }

        });
        boton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), ChatActivity.class);
                startActivity(intent);
            }

        });


        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), MainActivity2.class);
                startActivity(intent);
            }

        });
        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), UdechileActivity.class);
                startActivity(intent);
            }
        });


        boton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }

        });

    }



}