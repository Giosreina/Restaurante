package com.example;

import com.example.Logica.Pedido;
import com.example.Patrones.AbstractFactory.Combo1;
import com.example.Patrones.AbstractFactory.CombosFactory;
import com.example.Patrones.ChainOfResponsability.CocineroEncargado;
import com.example.Patrones.Observer.Observer.Cocina;
import com.example.Patrones.Proxy.Mesero;
import com.example.Patrones.Strategy.EntregaSitio;
import com.example.Patrones.Strategy.EstrategiaEntrega;
import com.example.Patrones.composite.GrupoPersonal;
import com.example.Utilities.SalidaTerminal;

public class Main {
    public static void main(String[] args) {
        SalidaTerminal salida = new SalidaTerminal();
        Cocina cocina = new Cocina();
        GrupoPersonal cocineros = new GrupoPersonal("cocineros");
        
        
        CocineroEncargado cocinero = new CocineroEncargado("Juan", "COMIDA", cocina);
        CocineroEncargado ayudanteDeCocina = new CocineroEncargado("Sara", "BEBIDA", cocina);
        cocinero.setNext(ayudanteDeCocina);
        
        cocineros.agregarPersonal(cocinero);
        cocineros.agregarPersonal(ayudanteDeCocina);
        
        Mesero mesero = new Mesero("Carlos", cocina);
        EstrategiaEntrega entrega = new EntregaSitio(cocina);
        
        Pedido pedido = new Pedido("Scar", "RAPPI");
        CombosFactory combo1 = new Combo1();
        combo1.crearAdicion(pedido).agregarElemento();
        combo1.crearBatido().preparar(pedido);
        
        mesero.tomarPedido(pedido);
        
        salida.imprimir(pedido.getDescripcion());
        cocineros.realizarTarea();
    }
}