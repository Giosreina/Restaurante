package com.example.Patrones.State;

public class EstadoCerrado implements EstadoRestaurante {
    public boolean manejar() {
        return false;
    }
}
