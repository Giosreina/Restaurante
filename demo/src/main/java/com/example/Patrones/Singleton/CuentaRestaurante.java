package com.example.Patrones.Singleton;

public class CuentaRestaurante {
    private String NUMERODECUENTA;
    private double SALDO = 0.0;
    private String TITULAR = "Jose Perez";
    private static CuentaRestaurante instancia;

    private CuentaRestaurante() {
        NUMERODECUENTA = "123445567889";
        TITULAR = "Jose Perez";   // Constructor privado para evitar instanciación externa
    }
    public static CuentaRestaurante getInstancia() {
        if (instancia == null) {
            instancia = new CuentaRestaurante();
        }
        return instancia;
    }

    public void meterDinero(double cantidad) {
        this.SALDO += cantidad;
    }
    public String getNumeroTelefono() {
        return NUMERODECUENTA;
    }
    public double getSaldo() {
        return SALDO;
    }
    public String getRestaurante() {
        return TITULAR;
    }
}
