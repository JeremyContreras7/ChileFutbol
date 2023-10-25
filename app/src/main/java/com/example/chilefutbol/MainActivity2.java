package com.example.chilefutbol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity2 extends AppCompatActivity {
    Button boton2;
    Button boton1;
    Button boton3;
    ImageButton boton4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        boton2 = findViewById(R.id.btnVolver);
        boton1 = findViewById(R.id.btnequipoC);
        boton3 = findViewById(R.id.btndatosColo);
        boton4 = findViewById(R.id.btnmapacolocolo);
        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), EquipocoloActivity.class);
                startActivity(intent);
            }
        });
        boton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), DatoscoloActivity.class);
                startActivity(intent);
            }
        });
        boton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), mapacolocolo.class);
                startActivity(intent);
            }
        });
    }
}