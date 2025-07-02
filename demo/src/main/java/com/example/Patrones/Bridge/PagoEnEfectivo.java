package com.example.Patrones.Bridge;
import com.example.Logica.Pedido;
import com.example.Patrones.Mediator.MediadorRestaurante;

public class PagoEnEfectivo extends MetodoDePago {
    private MediadorRestaurante mediador;
    public PagoEnEfectivo(MediadorRestaurante mediador) {
        this.mediador = mediador;
    }

    @Override
    public void procesarPago(int id, String cliente, String distribuidor, Pedido compras) {
        mediador.generarFactura(id, cliente, distribuidor, compras);
        mediador.pagarFactura();
    }
    public void setMediador(MediadorRestaurante mediador) {
        this.mediador = mediador;
    }   
}
