package com.example.Patrones.Mediator;

import com.example.Logica.Pedido;
import com.example.Patrones.Memento.CajaPasada;
import java.util.Date;
import java.util.Map;

public interface MediadorRestaurante {
    void generarFactura(String cliente, Pedido compras);
    void pagarFactura();
    Map<Date, CajaPasada> getHistorial();
}