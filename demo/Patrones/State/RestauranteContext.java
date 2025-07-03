package com.example.Patrones.State;

public class RestauranteContext {

    private EstadoRestaurante estadoActual;
    protected boolean estado; //true = abierto, false = cerrado

    public RestauranteContext() {
        estado = true;
    }

    public void setEstado(EstadoRestaurante estado) {
        this.estadoActual = estado;
    }

    public void ejecutarEstado() {
        estado = estadoActual.manejar();
    }

    public boolean isEstado() {
        return estado;
    }
}
