package com.example.chilefutbol;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class PlantillaUdeChile extends AppCompatActivity {
    private ListView listViewJugadores;
    private ArrayAdapter<String> adapter;
    private ArrayList<Jugador> jugadoresList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plantillacolo);

        // Inicializar la lista de jugadores
        jugadoresList = new ArrayList<>();
        jugadoresList.add(new Jugador("Campos", "Arquero",1));
        jugadoresList.add(new Jugador("Toselli", "Arquero",12));
        jugadoresList.add(new Jugador("Dominguez", "Defensa",23));
        jugadoresList.add(new Jugador("Casanova", "Defensa",17));
        jugadoresList.add(new Jugador("Zaldivia", "Defensa",22));
        jugadoresList.add(new Jugador("Tapia", "Defensa",3));
        jugadoresList.add(new Jugador("Fernandez", "Defensa",15));
        jugadoresList.add(new Jugador("Morales", "Defensa",14));
        jugadoresList.add(new Jugador("Castro", "Defensa",4));
        jugadoresList.add(new Jugador("Gomez", "Defensa",19));
        jugadoresList.add(new Jugador("Andia", "Defensa",6));
        jugadoresList.add(new Jugador("Navarrete", "Defensa",2));
        jugadoresList.add(new Jugador("Ojeda", "MedioCentro",5));
        jugadoresList.add(new Jugador("Cordero", "MedioCentro",29));
        jugadoresList.add(new Jugador("Mateos", "MedioCentro",20));
        jugadoresList.add(new Jugador("Poblete", "MedioCentro",28));
        jugadoresList.add(new Jugador("Fuentealba", "MedioCentro",17));
        jugadoresList.add(new Jugador("Assadi", "MedioCentro",10));
        jugadoresList.add(new Jugador("Lobos", "MedioCentro",18));
        jugadoresList.add(new Jugador("Huerta", "Delantero",24));
        jugadoresList.add(new Jugador("Fernandez", "Delantero",9));
        jugadoresList.add(new Jugador("Palacios", "Delantero",30));
        jugadoresList.add(new Jugador("Guerra", "Delantero",16));




        // Inicializar vistas
        listViewJugadores = findViewById(R.id.listViewJugadores);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, obtenerNombresJugadores());
        listViewJugadores.setAdapter(adapter);
    }

    private ArrayList<String> obtenerNombresJugadores() {
        ArrayList<String> nombresJugadores = new ArrayList<>();
        for (Jugador jugador : jugadoresList) {
            nombresJugadores.add(jugador.getNombre() + " - " + jugador.getPosicion()+" - "+jugador.getDorsal());
        }
        return nombresJugadores;
    }
}