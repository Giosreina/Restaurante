package com.example.Patrones.Memento;

public class CajaPasada {
    private Caja caja;

    public CajaPasada(Caja caja) {
        this.caja = caja;
    }

    public Caja getCaja() {
        return caja;
    }
}