package com.example.Patrones.Mediator;

import com.example.Logica.Pedido;

public interface MediadorRestaurante {
    void generarFactura(String cliente, Pedido compras);
    void pagarFactura();
}