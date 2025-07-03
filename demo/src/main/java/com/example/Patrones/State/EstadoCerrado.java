package com.example.Patrones.State;

public class EstadoCerrado implements EstadoRestaurante {
    public String manejar() {
        return "El restaurante está cerrado. No se puede atender.";
    }
}