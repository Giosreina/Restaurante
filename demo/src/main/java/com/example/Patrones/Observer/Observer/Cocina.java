package com.example.Patrones.Observer.Observer;

import java.util.ArrayList;
import com.example.Logica.Pedido;
import com.example.Patrones.Mediator.MediadorRestaurante;
import com.example.Patrones.Singleton.Cajero;
import com.example.Patrones.Strategy.EntregaDomicilio;
import com.example.Patrones.Strategy.EntregaRappi;
import com.example.Patrones.Strategy.EntregaSitio;
import com.example.Patrones.Strategy.EstrategiaEntrega;
import com.example.Utilities.IOTerminal;

public class Cocina {

    private ArrayList<Personal> empleados = new ArrayList<>();
    private ArrayList<Pedido> pedidos = new ArrayList<>();
    private EstrategiaEntrega estrategiaEntrega;
    private IOTerminal salida = new IOTerminal();
    private Cajero cajero;
    private MediadorRestaurante mediador;

    public void añadirEmpleado(Personal empleado) {
        empleados.add(empleado);
    }

    public void añadirPedidos(Pedido pedido) {
        pedidos.add(pedido);
        notificar();
    }

    public void notificar() {
        for (Personal personal : empleados) {
            personal.actualizar(pedidos.get(pedidos.size() - 1));
        }
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void entregarPedido(Pedido pedido) {
        switch (pedido.getMetodoEntrega()) {
            case "SITIO":
                estrategiaEntrega = new EntregaSitio(this, mediador);
                break;
            case "DOMICILIO":
                estrategiaEntrega = new EntregaDomicilio(this, mediador);
                break;
            case "RAPPI":
                estrategiaEntrega = new EntregaRappi(this, mediador);
                break;
            default:
                throw new AssertionError("Método de entrega no válido: " + pedido.getMetodoEntrega());
        }

        String resultado = estrategiaEntrega.entregar(pedido);
        pedidos.remove(pedido);
        salida.imprimir(resultado);
    }

    public void setEstrategiaEntrega(EstrategiaEntrega estrategiaEntrega) {
        this.estrategiaEntrega = estrategiaEntrega;
    }

    public void setCajero(Cajero cajero) {
        this.cajero = cajero;
    }

    public Cajero getCajero() {
        return cajero;
    }

    public void setMediador(MediadorRestaurante mediador) {
        this.mediador = mediador;
    }
}
