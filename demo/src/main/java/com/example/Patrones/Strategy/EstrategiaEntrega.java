package com.example.Patrones.Strategy;

import com.example.Logica.Pedido;
import com.example.Patrones.Bridge.MetodoDePago;
import com.example.Patrones.Bridge.PagoEnEfectivo;
import com.example.Patrones.Bridge.PagoPorNequi;
import com.example.Patrones.Bridge.PagoPorTarjeta;
import com.example.Patrones.Mediator.MediadorRestaurante;
import com.example.Patrones.Observer.Observer.Cocina;
import com.example.Utilities.IOTerminal;

public abstract class EstrategiaEntrega {

    protected Cocina cocina;
    protected IOTerminal terminal = new IOTerminal();
    protected MediadorRestaurante mediador = null;

    public EstrategiaEntrega(Cocina cocina, MediadorRestaurante mediador) {
        this.mediador = mediador;
        // Verifica que el mediador no sea nulo
        if (mediador == null) {
            throw new IllegalArgumentException("El mediador no puede ser nulo");
        }
        this.cocina = cocina;
        cocina.setEstrategiaEntrega(this);
    }

    public MetodoDePago metodoPago() {
        switch (terminal.recibir()) {
            case "EFECTIVO":
            //PRUEBA DE QUE EL MEDIADOR NO LLEGA AL SWITCH
            System.out.println(getMediador());
                return new PagoEnEfectivo(this.mediador);
            case "NEQUI":
                return new PagoPorNequi();
            case "TARJETA":
                return new PagoPorTarjeta();
            default:
                throw new AssertionError();
        }
    }

    public abstract String entregar(Pedido pedido);

    public MediadorRestaurante getMediador() {
        return this.mediador;
    }
    
}
