package com.example;

import com.example.Logica.Pedido;
import com.example.Patrones.AbstractFactory.Combo1;
import com.example.Patrones.AbstractFactory.CombosFactory;
import com.example.Patrones.Mediator.MediadorRestaurante;
import com.example.Patrones.Mediator.MediadorRestauranteConcreto;
import com.example.Patrones.Memento.Caja;
import com.example.Patrones.Memento.HistorialDeCajas;
import com.example.Patrones.Observer.Observer.AyudanteDeCocina;
import com.example.Patrones.Observer.Observer.Cocina;
import com.example.Patrones.Observer.Observer.Cocinero;
import com.example.Patrones.Observer.Observer.Personal;
import com.example.Patrones.Proxy.Mesero;
import com.example.Patrones.Singleton.Cajero;
import com.example.Patrones.Strategy.EntregaSitio;
import com.example.Patrones.Strategy.EstrategiaEntrega;
import com.example.Patrones.composite.GrupoPersonal;
import com.example.Utilities.IOTerminal;

public class Main {
    public static void main(String[] args) {
        IOTerminal terminal = new IOTerminal();
        
        Caja caja = new Caja();
        MediadorRestaurante mediador = new MediadorRestauranteConcreto(caja, new HistorialDeCajas());
        Cocina cocina = new Cocina();
        GrupoPersonal cocineros = new GrupoPersonal("cocineros");
        
        Cajero cajero = Cajero.getInstancia("Julioh Varon Belandya", caja, cocina);
        
        Personal cocinero = new Cocinero("Juan", "COMIDA", cocina);
        Personal ayudanteDeCocina = new AyudanteDeCocina("Sara", "BEBIDA", cocina);
        
        cocineros.agregarPersonal(cocinero);
        cocineros.agregarPersonal(ayudanteDeCocina);
        
        Mesero mesero = new Mesero("Carlos", cocina);
        EstrategiaEntrega entrega = new EntregaSitio(cocina, mediador);
        System.out.println(entrega.getMediador());
        
        terminal.imprimir("Nombre y metodo de envio porfa");
        Pedido pedido = new Pedido(terminal.recibir(), terminal.recibir());
        CombosFactory combo1 = new Combo1();
        combo1.crearAdicion(pedido).agregarElemento();
        combo1.crearBatido().preparar(pedido);
        
        mesero.tomarPedido(pedido);
        
        terminal.imprimir(pedido.getDescripcion());
        cocineros.realizarTarea();
        
        terminal.imprimir(Double.toString(caja.getDinero()));
        
    }
}