package com.example.chilefutbol;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class EquipoudechileActivity extends AppCompatActivity {

    private EditText editTextDorsal, editTextNombre, editTextPosicion;
    private Button btnAgregar, btnEliminarTodo, btnVolver;
    private ListView listViewDatos;
    private ArrayList<String> listaJugadores;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.equipoudechile);

        editTextDorsal = findViewById(R.id.editTextDorsal1);
        editTextNombre = findViewById(R.id.editTextNombre1);
        editTextPosicion = findViewById(R.id.editTextPosicion1);
        btnAgregar = findViewById(R.id.btnAgregar1);
        btnEliminarTodo = findViewById(R.id.btnEliminarTodo1);
        btnVolver = findViewById(R.id.btnVolver1);
        listViewDatos = findViewById(R.id.listViewDatos1);

        // Inicializar la lista de jugadores
        listaJugadores = new ArrayList<>();

        // Inicializar el adaptador
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaJugadores);

        // Asignar el adaptador a la lista
        listViewDatos.setAdapter(adapter);

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregarDato();
            }
        });

        btnEliminarTodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eliminarTodo();
            }
        });

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                volverAtras();
            }
        });
    }

    public void agregarDato() {
        // Obtener datos de los EditText
        String dorsal = editTextDorsal.getText().toString();
        String nombre = editTextNombre.getText().toString();
        String posicion = editTextPosicion.getText().toString();

        // Crear una cadena con la información del jugador
        String jugador = "Dorsal: " + dorsal + "\nNombre: " + nombre + "\nPosición: " + posicion;

        // Agregar el jugador a la lista
        listaJugadores.add(jugador);

        // Actualizar la lista
        adapter.notifyDataSetChanged();

        // Limpiar los EditText después de agregar el jugador
        editTextDorsal.getText().clear();
        editTextNombre.getText().clear();
        editTextPosicion.getText().clear();
    }

    public void eliminarTodo() {
        // Limpiar la lista de jugadores
        listaJugadores.clear();

        // Actualizar la lista
        adapter.notifyDataSetChanged();
    }

    public void volverAtras() {
        // Implementa lógica para volver atrás, si es necesario
        // Puedes utilizar finish() para cerrar la actividad si lo deseas
        finish();
    }
}
