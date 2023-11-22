package com.example.chilefutbol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
public class EquipoudechileActivity extends AppCompatActivity {
    private EditText editTextDorsal;
    private EditText editTextNombre;
    private EditText editTextPosicion;
    private ListView listViewDatos;
    private ArrayList<String> listaDatos;
    private ArrayAdapter<String> adapter;
    private static final String PREFS_NAME = "MisPreferencias";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.equipocolo);

        editTextDorsal = findViewById(R.id.editTextDorsal);
        editTextNombre = findViewById(R.id.editTextNombre);
        editTextPosicion = findViewById(R.id.editTextPosicion);
        listViewDatos = findViewById(R.id.listViewDatos);
        listaDatos = new ArrayList<>();

        // Crear un adaptador para la lista
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaDatos);

        // Vincular el adaptador a la lista
        listViewDatos.setAdapter(adapter);

        cargarDatos();

        Button btnAgregar = findViewById(R.id.btnAgregar);
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarDato();
            }
        });

        Button btnVolver = findViewById(R.id.btnVolver);
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public void agregarDato() {
        // Obtener los valores de los EditText
        String dorsal = editTextDorsal.getText().toString();
        String nombre = editTextNombre.getText().toString();
        String posicion = editTextPosicion.getText().toString();

        // Construir el string a mostrar en la lista
        String dato = "Dorsal: " + dorsal + "\nNombre: " + nombre + "\nPosición: " + posicion;

        // Agregar el string a la lista de datos
        listaDatos.add(dato);

        // Notificar al adaptador que los datos han cambiado
        adapter.notifyDataSetChanged();

        // Limpiar los EditText
        editTextDorsal.getText().clear();
        editTextNombre.getText().clear();
        editTextPosicion.getText().clear();

        // Guardar los datos
        guardarDatos();
    }

    private void guardarDatos() {
        SharedPreferences preferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        Set<String> set = new HashSet<>(listaDatos);
        editor.putStringSet("listaDatos", set);
        editor.apply();
    }

    private void cargarDatos() {
        SharedPreferences preferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        Set<String> set = preferences.getStringSet("listaDatos", null);
        if (set != null) {
            listaDatos.addAll(set);
            adapter.notifyDataSetChanged();
        }
    }
}
