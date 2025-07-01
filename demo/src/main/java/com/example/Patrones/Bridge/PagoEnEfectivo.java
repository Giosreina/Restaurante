package com.example.Patrones.Bridge;
import com.example.Logica.Pedido;
import com.example.Patrones.Memento.*;
import com.example.Patrones.Mediator.*;

public class PagoEnEfectivo extends MetodoDePago {
    private Mediador mediador;

    public PagoEnEfectivo(Caja caja, Mediador mediador) {
        this.mediador = mediador;
    }

    @Override
    public void procesarPago(int id, String cliente, String distribuidor, Pedido compras, HistorialDeCajas historial) {
        mediador.generarFactura(id, cliente, distribuidor, compras);
        mediador.pagarFactura();
    }
}
