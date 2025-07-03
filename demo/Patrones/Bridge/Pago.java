package com.example.Patrones.Bridge;

import com.example.Logica.Pedido;

public class Pago {

    private MetodoDePago metodoDePago;

    public Pago(MetodoDePago metodoDePago) {
        this.metodoDePago = metodoDePago;
    }

    public void procesarPago(String cliente, Pedido compras) {
        metodoDePago.procesarPago(cliente, compras);
    }
}
