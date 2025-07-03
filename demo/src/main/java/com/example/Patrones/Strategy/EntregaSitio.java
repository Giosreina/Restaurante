package com.example.Patrones.Strategy;

import com.example.Logica.Pedido;
import com.example.Patrones.Mediator.MediadorRestaurante;
import com.example.Patrones.Observer.Cocina;
import com.example.Patrones.TemplateMethod.EntregaTemplate;

public class EntregaSitio extends EstrategiaEntrega {
    private final EntregaTemplate template;

    public EntregaSitio(Cocina cocina, MediadorRestaurante mediador) {
        super(cocina, mediador);
        this.template = new EntregaTemplate(cocina, mediador) {
            @Override
            protected String entregarPedido(Pedido pedido) {
                return "Entregando el pedido de " + pedido.getNombre() + " a la mesa.";
            }
        };
    }

    @Override
    public String entregar(Pedido pedido) {
        return template.procesarEntrega(pedido);
    }
}