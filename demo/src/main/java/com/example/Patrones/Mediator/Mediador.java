package com.example.Patrones.Mediator;

import com.example.Logica.Pedido;

public interface Mediador {
    void generarFactura(int id, String cliente, String distribuidor, Pedido pedidoActual);
    void pagarFactura();
}
