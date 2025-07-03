package com.example.Patrones.Mediator;

import java.util.Map;

import com.example.Logica.Pedido;
import com.example.Patrones.Memento.*;
import com.example.Patrones.MethodFactory.*;
import java.util.Date;

public class MediadorRestauranteConcreto implements MediadorRestaurante {
    private Caja caja;
    private Fabricas fabricas = new LlamadoFactura();
    private HistorialDeCajas historial;

    public MediadorRestauranteConcreto(Caja caja, HistorialDeCajas historial) {
        this.caja = caja;
        this.historial = historial;
    }

    @Override
    public void generarFactura(String cliente, Pedido compras) {
        caja.setFactura(fabricas.crearFactura(cliente, compras));
    }

    @Override
    public void pagarFactura() {
        if (caja.getFactura() == null) {
            System.out.println("No hay factura para pagar.");
            return;
        }
        caja.pagarFactura();
        historial.addCaja(caja.clone());
    }

    @Override
    public Map<Date, CajaPasada> getHistorial() {
        return historial.getHistorial();
    }
}