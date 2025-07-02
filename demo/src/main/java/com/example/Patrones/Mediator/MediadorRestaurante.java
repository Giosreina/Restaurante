package com.example.Patrones.Mediator;

import com.example.Logica.Pedido;

public interface MediadorRestaurante {
    void generarFactura(int id, String cliente, String distribuidor, Pedido compras);
    void pagarFactura();
}