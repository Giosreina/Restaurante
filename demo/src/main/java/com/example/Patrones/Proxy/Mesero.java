package com.example.Patrones.Proxy;

import com.example.Logica.Pedido;
import com.example.Patrones.Observer.Cocina;
import com.example.Patrones.Observer.Personal;
import com.example.Patrones.Prototype.HorariosDisponibles;
import com.example.Patrones.Prototype.TurnoPrototype;
import com.example.Utilities.IOTerminal;

public class Mesero extends Personal {

    private TurnoPrototype turnoMesero;
    private Cocina cocina;
    private Pedido pedidoActual;
    private IOTerminal salida = new IOTerminal();

    public Mesero(String nombre, Cocina cocina) {
        super(nombre);
        this.cocina = cocina;
    }

    public void tomarPedido(Pedido pedido) {
        this.pedidoActual = pedido;
        realizarTarea();
    }

    @Override
    public void actualizar(Pedido pedido) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void realizarTarea() {
        if (pedidoActual != null) {
            if (!cocina.getPedidos().contains(pedidoActual)) {
                cocina.añadirPedidos(pedidoActual);
                pedidoActual = null;
                salida.imprimir("El mesero " + nombre + " ha enviado el pedido a la cocina");
            } else {
                salida.imprimir("El pedido ya está siendo preparado");
            }
        } else {
            salida.imprimir("No hay pedido existente");
        }
    }

    @Override
    public void asignarTurno(String turno) {
        HorariosDisponibles horariosDisponibles = new HorariosDisponibles();
        turnoMesero = horariosDisponibles.obtenerTurno(turno);
    }
}
