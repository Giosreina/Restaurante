package com.example.Patrones.Bridge;

import com.example.Logica.Pedido;

public class Pago {
    private MetodoDePago metodoDePago;

    public Pago(MetodoDePago metodoDePago) {
        this.metodoDePago = metodoDePago;
    }

    public void procesarPago(int id, String cliente, String distribuidor, Pedido compras) {
        metodoDePago.procesarPago(id, cliente, distribuidor, compras);
    }
}

