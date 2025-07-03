package com.example.Patrones.Facade;

import com.example.Logica.Pedido;
import com.example.Patrones.AbstractFactory.*;
import com.example.Patrones.Builder.*;
import com.example.Patrones.Decorator.*;
import com.example.Patrones.Flyweight.Combo;
import com.example.Patrones.Flyweight.CreadorCombo;
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
    }

    @Override
    public void atenderCliente() {
        // Registrar personal
        cocineros.agregarPersonal(cocinero);
        cocineros.agregarPersonal(ayudanteDeCocina);

        // Solicitar datos del cliente
        terminal.imprimir("Nombre del cliente:");
        String nombre = terminal.recibir();

        terminal.imprimir("Método de entrega:\n- SITIO\n- DOMICILIO\n- RAPPI");
        String metodo = terminal.recibir().toUpperCase();

        Pedido pedido = new Pedido(nombre, metodo);

        // Flyweight: crear combo personalizado reutilizando instancias de Alimento
        terminal.imprimir("¿Deseas crear un combo personalizado? (SI / NO)");
        String personalizar = terminal.recibir().toUpperCase();

        if (personalizar.equals("SI")) {
            CreadorCombo creador = new CreadorCombo();
            Combo combo = new Combo();
            combo.setCreador(creador);
            combo.setComidas(pedido);
            combo.setDescuento(1.0);

            boolean agregarMas = true;
            while (agregarMas) {
                terminal.imprimir("Nombre del alimento:");
                String nombreComida = terminal.recibir();

                combo.añadirComida(nombreComida, 5000, "COMIDA", "TACO TIPICO", pedido);

                terminal.imprimir("¿Agregar otro alimento? (SI / NO)");
                agregarMas = terminal.recibir().equalsIgnoreCase("SI");
            }

            // Builder: seleccionar tipo de batido
            terminal.imprimir("Seleccione tipo de batido:\n1. Rojo\n2. Verde\n3. Cítrico\n4. Tropical");
            int batido = Integer.parseInt(terminal.recibir());
            BatidoBuilder builder;
            switch (batido) {
                case 1 ->
                    builder = new BatidoRojoBuilder();
                case 2 ->
                    builder = new BatidoVerdeBuilder();
                case 3 ->
                    builder = new BatidoCitricoBuilder();
                case 4 ->
                    builder = new BatidoTropicalBuilder();
                default ->
                    builder = new BatidoRojoBuilder();
            }
            builder.setFruta1().setFruta2().setLecheCondensada().setAzucar();
            builder.preparar(pedido);

            // Decorator: añadir múltiples adiciones
            terminal.imprimir("Seleccione adiciones:\n1. Guacamole\n2. Mazorca\n3. Papas Fritas\n(Escriba separados por coma, ej: 1,3)");
            String[] adiciones = terminal.recibir().split(",");
            for (String a : adiciones) {
                switch (a.trim()) {
                    case "1" ->
                        new AdicionGuacamole(pedido).agregarElemento();
                    case "2" ->
                        new AdicionMazorcaGratinada(pedido).agregarElemento();
                    case "3" ->
                        new AdicionPapaFrita(pedido).agregarElemento();
                }
            }

        } else {
            // Mostrar opciones de combos
            terminal.imprimir("Seleccione un combo:\n1. Combo1\n2. Combo2\n3. Combo3");
            int opcion = Integer.parseInt(terminal.recibir());
            CombosFactory comboSeleccionado;

            switch (opcion) {
                case 1 ->
                    comboSeleccionado = new Combo1();
                case 2 ->
                    comboSeleccionado = new Combo2();
                case 3 ->
                    comboSeleccionado = new Combo3();
                default -> {
                    terminal.imprimir("Opción no válida. Se usará Combo1 por defecto.");
                    comboSeleccionado = new Combo1();
                }
            }

            // Crear pedido usando Abstract Factory
            comboSeleccionado.crearAdicion(pedido).agregarElemento();
            comboSeleccionado.crearBatido().preparar(pedido);
        }

        // Tomar el pedido
        mesero.tomarPedido(pedido);
        terminal.imprimir(pedido.getDescripcion());

        // Cocineros realizan su trabajo
        cocineros.realizarTarea();

        // Entregar el pedido
        cocina.entregarPedido(pedido);
    }
}
