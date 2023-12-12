package com.example.chilefutbol;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class Plantillacolo extends AppCompatActivity {
    private ListView listViewJugadores;
    private ArrayAdapter<String> adapter;
    private ArrayList<Jugador> jugadoresList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plantillacolo);

        // Inicializar la lista de jugadores
        jugadoresList = new ArrayList<>();
        jugadoresList.add(new Jugador("Brayan Cortes", "Arquero","1"));
        jugadoresList.add(new Jugador("De Paul", "Arquero","12"));
        jugadoresList.add(new Jugador("Emiliano Amor", "Defensa","15"));
        jugadoresList.add(new Jugador("Falcon", "Defensa","37"));
        jugadoresList.add(new Jugador("Gutierrez", "Defensa","3"));
        jugadoresList.add(new Jugador("Gonzalez", "Defensa","23"));
        jugadoresList.add(new Jugador("Saldivia", "Defensa","4"));
        jugadoresList.add(new Jugador("Wiemberg", "Defensa","21"));
        jugadoresList.add(new Jugador("Opazo", "Defensa","13"));
        jugadoresList.add(new Jugador("Rojas", "Defensa","2"));
        jugadoresList.add(new Jugador("Gutierrez", "Defensa","13"));
        jugadoresList.add(new Jugador("Pavez", "MedioCentro","23"));
        jugadoresList.add(new Jugador("Pizarro", "MedioCentro","34"));
        jugadoresList.add(new Jugador("Fuentes", "MedioCentro","28"));
        jugadoresList.add(new Jugador("Gil", "MedioCentro","5"));
        jugadoresList.add(new Jugador("Parra", "MedioCentro","10"));
        jugadoresList.add(new Jugador("Palacios", "MedioCentro","7"));
        jugadoresList.add(new Jugador("Oroz", "Delantero","20"));
        jugadoresList.add(new Jugador("Moya", "Delantero","26"));
        jugadoresList.add(new Jugador("Bouzat", "Delantero","18"));
        jugadoresList.add(new Jugador("Castillo", "Delantero","17"));
        jugadoresList.add(new Jugador("Thompson", "Delantero","24"));
        jugadoresList.add(new Jugador("Bolados", "Delantero","11"));
        jugadoresList.add(new Jugador("Lezcano", "Delantero","16"));
        jugadoresList.add(new Jugador("Damian Pizzaro", "Delantero","9"));
        jugadoresList.add(new Jugador("Benegas", "Delantero","22"));


        // Inicializar vistas
        listViewJugadores = findViewById(R.id.listViewJugadores);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, obtenerNombresJugadores());
        listViewJugadores.setAdapter(adapter);
    }

    private ArrayList<String> obtenerNombresJugadores() {
        ArrayList<String> nombresJugadores = new ArrayList<>();
        for (Jugador jugador : jugadoresList) {
            nombresJugadores.add(jugador.getNombre() + " - " + jugador.getPosicion());
        }
        return nombresJugadores;
    }
}