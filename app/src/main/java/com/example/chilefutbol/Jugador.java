package com.example.chilefutbol;

public class Jugador {
    private String nombre;
    private String posicion;
    private  Integer dorsal;


    public Jugador(String nombre, String posicion,Integer dorsal) {
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

    public Integer getDorsal() {
        return dorsal;
    }
}
