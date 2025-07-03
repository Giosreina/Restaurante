package com.example.Patrones.Bridge;

import com.example.Logica.Pedido;
import com.example.Patrones.Mediator.MediadorRestaurante;

public class PagoEnEfectivo extends MetodoDePago {

    private MediadorRestaurante mediador;

    public PagoEnEfectivo(MediadorRestaurante mediador) {
        this.mediador = mediador;
    }

    @Override
    public void procesarPago(String cliente, Pedido compras) {
        mediador.generarFactura(cliente, compras);
        mediador.pagarFactura();
    }

    public void setMediador(MediadorRestaurante mediador) {
        this.mediador = mediador;
    }
}
