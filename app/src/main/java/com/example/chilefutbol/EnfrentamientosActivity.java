package com.example.chilefutbol;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class EnfrentamientosActivity extends AppCompatActivity {

    private EditText editTextEquipo1, editTextEquipo2, editTextAnotacionesEquipo1, editTextAnotacionesEquipo2;
    private Button buttonAgregar, buttonVolver;
    private ListView listView;
    private ArrayList<String> enfrentamientosList;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enfrentamientos);

        editTextEquipo1 = findViewById(R.id.editTextEquipo1);
        editTextEquipo2 = findViewById(R.id.editTextEquipo2);
        editTextAnotacionesEquipo1 = findViewById(R.id.editTextAnotacionesEquipo1);
        editTextAnotacionesEquipo2 = findViewById(R.id.editTextAnotacionesEquipo2);
        buttonAgregar = findViewById(R.id.buttonAgregar);
        buttonVolver = findViewById(R.id.buttonVolver);
        listView = findViewById(R.id.listView);

        enfrentamientosList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, enfrentamientosList);
        listView.setAdapter(adapter);

        buttonAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregarDatos();
            }
        });

        buttonVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Cierra la actividad actual y vuelve a la actividad anterior
            }
        });
    }

    private void agregarDatos() {
        String equipo1 = editTextEquipo1.getText().toString();
        String equipo2 = editTextEquipo2.getText().toString();
        String anotacionesEquipo1 = editTextAnotacionesEquipo1.getText().toString();
        String anotacionesEquipo2 = editTextAnotacionesEquipo2.getText().toString();

        // Validar que los campos no estén vacíos antes de agregar a la lista
        if (!equipo1.isEmpty() && !equipo2.isEmpty() && !anotacionesEquipo1.isEmpty() && !anotacionesEquipo2.isEmpty()) {
            String enfrentamiento = equipo1 + " vs " + equipo2 + ": " + anotacionesEquipo1 + " - " + anotacionesEquipo2;
            enfrentamientosList.add(enfrentamiento);
            adapter.notifyDataSetChanged();

            // Limpiar los EditText después de agregar a la lista
            editTextEquipo1.getText().clear();
            editTextEquipo2.getText().clear();
            editTextAnotacionesEquipo1.getText().clear();
            editTextAnotacionesEquipo2.getText().clear();
        }
    }
}
