package com.example.Patrones.Mediator;

import com.example.Logica.Pedido;
import com.example.Patrones.Memento.Caja;
import com.example.Patrones.Memento.HistorialDeCajas;
import com.example.Patrones.MethodFactory.*;


public class MediadorRestauranteConcreto implements Mediador {
    private Caja caja;
    private HistorialDeCajas historial;
    private Fabricas fabrica = new LlamadoFactura();

    public MediadorRestauranteConcreto(Caja caja, HistorialDeCajas historial) {
        this.caja = caja;
        this.historial = historial;
    }


    @Override
    public void generarFactura(int id, String cliente, String distribuidor, Pedido pedidoActual) {
        caja.setFactura(fabrica.crearFactura(id, cliente, distribuidor, pedidoActual));
    }

    @Override
    public void pagarFactura() {
        if (caja.getFactura() == null) {
            return;
        }
        caja.pagarFactura();
        historial.addCaja(caja);
    }
}