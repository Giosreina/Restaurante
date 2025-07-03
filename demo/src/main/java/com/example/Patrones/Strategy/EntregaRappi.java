package com.example.Patrones.Strategy;

import com.example.Logica.Pedido;
import com.example.Patrones.Mediator.MediadorRestaurante;
import com.example.Patrones.Observer.Observer.Cocina;

public class EntregaRappi extends EstrategiaEntrega {

    public EntregaRappi(Cocina cocina, MediadorRestaurante mediador) {
        super(cocina, mediador);
    }

    @Override
    public String entregar(Pedido pedido) {
        super.terminal.imprimir("Como deseas realizar tu pago");
        cocina.getCajero().cobrarFactura(pedido.getNombre(), pedido, super.metodoPago());
        return "Entregando el pedido de " + pedido.getNombre() + " al repartidor de Rappi";
    }
}
