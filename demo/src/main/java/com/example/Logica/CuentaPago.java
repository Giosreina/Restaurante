package com.example.Logica;

public abstract class CuentaPago {
    protected String numeroDeCuenta, titularDeCuenta;
    protected double saldo;

    public CuentaPago(String numeroDeCuenta, String titularDeCuenta) {
        this.numeroDeCuenta = numeroDeCuenta;
        this.titularDeCuenta = titularDeCuenta;
        saldo = 0.0;
    }
    
    public void recibirDinero(double monto){
        saldo += monto;
    }

    public String getNumeroDeCuenta() {
        return numeroDeCuenta;
    }

    public String getTitularDeCuenta() {
        return titularDeCuenta;
    }

    public double getSaldo() {
        return saldo;
    }
}
