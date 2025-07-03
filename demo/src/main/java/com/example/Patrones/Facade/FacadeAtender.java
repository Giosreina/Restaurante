package com.example.Patrones.Facade;

import com.example.Logica.Pedido;
import com.example.Patrones.AbstractFactory.*;
import com.example.Patrones.Mediator.*;
import com.example.Patrones.Memento.*;
import com.example.Patrones.Observer.Observer.*;
import com.example.Patrones.Proxy.Mesero;
import com.example.Patrones.Singleton.Cajero;
import com.example.Patrones.Strategy.*;
import com.example.Patrones.composite.GrupoPersonal;
import com.example.Utilities.IOTerminal;

public class FacadeAtender extends FacadeAbstract {

    private final IOTerminal terminal;
    private final Caja caja;
    private final MediadorRestaurante mediador;
    private final Cocina cocina;
    private final GrupoPersonal cocineros;
    private final Cajero cajero;
    private final Personal cocinero;
    private final Personal ayudanteDeCocina;
    private final Mesero mesero;
    private final EstrategiaEntrega entrega;

    public FacadeAtender() {
        this.terminal = new IOTerminal();
        this.caja = new Caja();
        this.mediador = new MediadorRestauranteConcreto(caja, new HistorialDeCajas());
        this.cocina = new Cocina();
        cocina.setMediador(mediador);
        this.cocineros = new GrupoPersonal("cocineros");
        this.cajero = Cajero.getInstancia("Julioh Varon Belandya", caja, cocina);
        this.cocinero = new Cocinero("Juan", "COMIDA", cocina);
        this.ayudanteDeCocina = new AyudanteDeCocina("Sara", "BEBIDA", cocina);
        this.mesero = new Mesero("Carlos", cocina);
        this.entrega = new EntregaSitio(cocina, mediador);
    }

    @Override
    public void realizarCiclo() {
        // Registrar personal
        cocineros.agregarPersonal(cocinero);
        cocineros.agregarPersonal(ayudanteDeCocina);

        // Solicitar datos del cliente
        terminal.imprimir("Nombre del cliente:");
        String nombre = terminal.recibir();
        terminal.imprimir("Método de entrega:");
        String metodo = terminal.recibir();
        Pedido pedido = new Pedido(nombre, metodo);

        // Mostrar opciones de combos
        terminal.imprimir("Seleccione un combo:\n1. Combo1\n2. Combo2\n3. Combo3");
        int opcion = Integer.parseInt(terminal.recibir());
        CombosFactory comboSeleccionado;

        switch (opcion) {
            case 1:
                comboSeleccionado = new Combo1();
                break;
            case 2:
                comboSeleccionado = new Combo2();
                break;
            case 3:
                comboSeleccionado = new Combo3();
                break;
            default:
                terminal.imprimir("Opción no válida. Se usará Combo1 por defecto.");
                comboSeleccionado = new Combo1();
        }

        // Crear pedido usando Abstract Factory
        comboSeleccionado.crearAdicion(pedido).agregarElemento();
        comboSeleccionado.crearBatido().preparar(pedido);

        // Tomar el pedido y prepararlo
        mesero.tomarPedido(pedido);
        terminal.imprimir(pedido.getDescripcion());

        // Cocineros realizan su trabajo
        cocineros.realizarTarea();
    }
} 