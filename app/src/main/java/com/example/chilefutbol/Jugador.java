package com.example.chilefutbol;

public class Jugador {
    private String nombre;
    private String posicion;
    private  String dorsal;


    public Jugador(String nombre, String posicion,String dorsal) {
        this.nombre = nombre;
        this.posicion = posicion;
        this.dorsal = dorsal;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPosicion() {
        return posicion;
    }

    public String getDorsal() {
        return dorsal;
    }
}
