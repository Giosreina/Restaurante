package com.example.Patrones.Bridge;

import com.example.Logica.Pedido;

public abstract class MetodoDePago {
    public abstract void procesarPago(int id, String cliente, String distribuidor, Pedido compras);
}