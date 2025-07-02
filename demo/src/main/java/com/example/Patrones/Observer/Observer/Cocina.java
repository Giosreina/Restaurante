package com.example.Patrones.Observer.Observer;

import java.util.ArrayList;
import com.example.Logica.Pedido;
import com.example.Patrones.Strategy.EntregaDomicilio;
import com.example.Patrones.Strategy.EntregaRappi;
import com.example.Patrones.Strategy.EntregaSitio;
import com.example.Patrones.Strategy.EstrategiaEntrega;

public class Cocina {

    private ArrayList<Personal> empleados = new ArrayList<>();
    private ArrayList<Pedido> pedidos = new ArrayList<>();
    private EstrategiaEntrega estrategiaEntrega;

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

    public String entregarPedido(Pedido pedido) {
        switch (pedido.getMetodoEntrega()) {
            case "SITIO":
                estrategiaEntrega = new EntregaSitio(this);
                break;
            case "DOMICILIO":
                estrategiaEntrega = new EntregaDomicilio(this);
                break;
            case "RAPPI":
                estrategiaEntrega = new EntregaRappi(this);
                break;
            default:
                throw new AssertionError("Método de entrega no válido: " + pedido.getMetodoEntrega());
        }

        String resultado = estrategiaEntrega.entregar(pedido);
        pedidos.remove(pedido);
        return resultado;
    }

    public void setEstrategiaEntrega(EstrategiaEntrega estrategiaEntrega) {
        this.estrategiaEntrega = estrategiaEntrega;
    }
}
