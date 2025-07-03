package com.example.Patrones.TemplateMethod;

import com.example.Logica.Pedido;
import com.example.Patrones.Bridge.*;
import com.example.Patrones.Mediator.MediadorRestaurante;
import com.example.Patrones.Observer.Observer.Cocina;
import com.example.Utilities.IOTerminal;

public abstract class EntregaTemplate {

    protected Cocina cocina;
    protected IOTerminal terminal = new IOTerminal();
    protected MediadorRestaurante mediador;

    public EntregaTemplate(Cocina cocina, MediadorRestaurante mediador) {
        this.cocina = cocina;
        this.mediador = mediador;
    }

    public final String procesarEntrega(Pedido pedido) {
        solicitarPago(pedido);
        return entregarPedido(pedido);
    }

    protected void solicitarPago(Pedido pedido) {
        terminal.imprimir("¿Cómo deseas realizar tu pago? (EFECTIVO / NEQUI / TARJETA)");
        MetodoDePago metodo = obtenerMetodoDePago();
        cocina.getCajero().cobrarFactura(pedido.getNombre(), pedido, metodo);
    }

    protected abstract String entregarPedido(Pedido pedido);

    protected MetodoDePago obtenerMetodoDePago() {
        switch (terminal.recibir().toUpperCase()) {
            case "EFECTIVO":
                return new PagoEnEfectivo(mediador);
            case "NEQUI":
                return new PagoPorNequi();
            case "TARJETA":
                return new PagoPorTarjeta();
            default:
                throw new IllegalArgumentException("Método de pago inválido");
        }
    }
}