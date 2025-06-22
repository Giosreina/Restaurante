package com.example.Patrones.Memento;

import com.example.Logica.Factura;

import com.example.Patrones.Bridge.*;

public class Caja{
    private double dinero = 0.0;
    private Factura factura;
    private MetodoDePago metodoDePago;
    private Pago pago;

    public void setFactura(Factura factura) {
        this.factura = factura;
    }
    public void pagarFactura() {
        dinero += factura.getPrecio();
        factura.setEstado(true);
    }
    public double getDinero() {
        return dinero;
    }
    public CajaPasada saveCaja(){
        return new CajaPasada(this);
    }
    public Factura getFactura() {
        return factura;
    }
    public void restoreCaja(CajaPasada cajaPasada) {
        this.dinero = cajaPasada.getCaja().getDinero();
        this.factura = cajaPasada.getCaja().getFactura();
    }
}