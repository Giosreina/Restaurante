package com.example.Patrones.Strategy;

import com.example.Logica.Pedido;
import com.example.Patrones.Mediator.MediadorRestaurante;
import com.example.Patrones.Observer.Cocina;

public abstract class EstrategiaEntrega {
    protected Cocina cocina;
    protected MediadorRestaurante mediador;

    public EstrategiaEntrega(Cocina cocina, MediadorRestaurante mediador) {
        this.mediador = mediador;
        if (mediador == null) {
            throw new IllegalArgumentException("El mediador no puede ser nulo");
        }
        this.cocina = cocina;
        cocina.setEstrategiaEntrega(this);
    }

    public abstract String entregar(Pedido pedido);

    public MediadorRestaurante getMediador() {
        return this.mediador;
    }
}
