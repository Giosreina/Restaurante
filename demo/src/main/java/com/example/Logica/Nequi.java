package com.example.Logica;

public class Nequi {
    private final String NUMERODETELEFONO = "3115371433";
    private double SALDO = 0.0;
    private final String RESTAURANTE = "taqueria";

    public void meterDinero(double cantidad) {
        this.SALDO += cantidad;
    }
    public String getNumeroTelefono() {
        return NUMERODETELEFONO;
    }
    public double getSaldo() {
        return SALDO;
    }
    public String getRestaurante() {
        return RESTAURANTE;
    }
}
