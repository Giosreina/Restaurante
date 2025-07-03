package com.example.Patrones.State;

public class RestauranteContext {
    private EstadoRestaurante estadoActual;

    public void setEstado(EstadoRestaurante estado) {
        this.estadoActual = estado;
    }

    public String ejecutarEstado() {
        return estadoActual.manejar();
    }
}