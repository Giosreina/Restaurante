package com.example.Patrones.Singleton;

import com.example.Logica.CuentaPago;

public class CuentaRestaurante extends CuentaPago{
    private static CuentaRestaurante instancia;

    private CuentaRestaurante() {
        super("123445567889","Juan Sierra");
    }
    public static CuentaRestaurante getInstancia() {
        if (instancia == null) {
            instancia = new CuentaRestaurante();
        }
        return instancia;
    }
}
