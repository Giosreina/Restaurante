package com.example.Patrones.State;

public class EstadoLimpieza implements EstadoRestaurante {
    public String manejar() {
        return "El restaurante está en limpieza. Espere por favor.";
    }
}
