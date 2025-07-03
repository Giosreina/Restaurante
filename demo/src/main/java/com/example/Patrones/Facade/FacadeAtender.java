package com.example.Patrones.Facade;

import com.example.Logica.Pedido;
import com.example.Patrones.AbstractFactory.Combo1;
import com.example.Patrones.AbstractFactory.Combo2;
import com.example.Patrones.AbstractFactory.Combo3;
import com.example.Patrones.AbstractFactory.CombosFactory;
import com.example.Patrones.Builder.BatidoBuilder;
import com.example.Patrones.Builder.BatidoCitricoBuilder;
import com.example.Patrones.Builder.BatidoRojoBuilder;
import com.example.Patrones.Builder.BatidoTropicalBuilder;
import com.example.Patrones.Builder.BatidoVerdeBuilder;
import com.example.Patrones.Decorator.AdicionGuacamole;
import com.example.Patrones.Decorator.AdicionMazorcaGratinada;
import com.example.Patrones.Decorator.AdicionPapaFrita;
import com.example.Patrones.Facade.FacadeAbstract;
import com.example.Patrones.Flyweight.Combo;
import com.example.Patrones.Flyweight.CreadorCombo;
import com.example.Patrones.Mediator.MediadorRestaurante;
import com.example.Patrones.Mediator.MediadorRestauranteConcreto;
import com.example.Patrones.Memento.Caja;
import com.example.Patrones.Memento.CajaPasada;
import com.example.Patrones.Memento.HistorialDeCajas;
import com.example.Patrones.Observer.AyudanteDeCocina;
import com.example.Patrones.Observer.Cocina;
import com.example.Patrones.Observer.Cocinero;
import com.example.Patrones.Observer.Personal;
import com.example.Patrones.Proxy.Mesero;
import com.example.Patrones.Singleton.Cajero;
import com.example.Patrones.State.EstadoCerrado;
import com.example.Patrones.State.RestauranteContext;
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
    private RestauranteContext estado;

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
        this.estado = new RestauranteContext();
    }

    @Override
    public void atenderCliente() {
        while (estado.isEstado()) {
            cocineros.agregarPersonal(cocinero);
            cocineros.agregarPersonal(ayudanteDeCocina);

            terminal.imprimir("Nombre del cliente:");
            String nombre = terminal.recibir();

            // Validar método de entrega
            String metodo = "";
            while (true) {
                terminal.imprimir("Método de entrega:\n- SITIO\n- DOMICILIO\n- RAPPI");
                metodo = terminal.recibir().toUpperCase();
                if (metodo.equals("SITIO") || metodo.equals("DOMICILIO") || metodo.equals("RAPPI")) break;
                terminal.imprimir("❌ Método inválido. Intente de nuevo.");
            }

            Pedido pedido = new Pedido(nombre, metodo);

            // Flyweight
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
                    String respuesta = terminal.recibir().toUpperCase();
                    agregarMas = respuesta.equals("SI");
                }

                // Builder de batidos
                int batido = 0;
                while (true) {
                    terminal.imprimir("Seleccione tipo de batido:\n1. Rojo\n2. Verde\n3. Cítrico\n4. Tropical");
                    try {
                        batido = Integer.parseInt(terminal.recibir());
                        if (batido >= 1 && batido <= 4) break;
                        else terminal.imprimir("❌ Opción fuera de rango.");
                    } catch (NumberFormatException e) {
                        terminal.imprimir("❌ Entrada inválida. Debe ser un número.");
                    }
                }

                BatidoBuilder builder = switch (batido) {
                    case 1 -> new BatidoRojoBuilder();
                    case 2 -> new BatidoVerdeBuilder();
                    case 3 -> new BatidoCitricoBuilder();
                    case 4 -> new BatidoTropicalBuilder();
                    default -> new BatidoRojoBuilder(); // nunca llega aquí, por seguridad
                };

                builder.setFruta1().setFruta2().setLecheCondensada().setAzucar();
                builder.preparar(pedido);

                // Decorator
                terminal.imprimir("Seleccione adiciones:\n1. Guacamole\n2. Mazorca\n3. Papas Fritas\n(Escriba separados por coma, ej: 1,3)");
                String[] adiciones = terminal.recibir().split(",");
                for (String a : adiciones) {
                    switch (a.trim()) {
                        case "1" -> new AdicionGuacamole(pedido).agregarElemento();
                        case "2" -> new AdicionMazorcaGratinada(pedido).agregarElemento();
                        case "3" -> new AdicionPapaFrita(pedido).agregarElemento();
                        default -> terminal.imprimir("⚠️ Adición desconocida: " + a.trim());
                    }
                }

            } else {
                // Combos predeterminados
                int opcion = 0;
                while (true) {
                    terminal.imprimir("Seleccione un combo:\n1. Combo1\n2. Combo2\n3. Combo3");
                    try {
                        opcion = Integer.parseInt(terminal.recibir());
                        if (opcion >= 1 && opcion <= 3) break;
                        else terminal.imprimir("❌ Opción fuera de rango.");
                    } catch (NumberFormatException e) {
                        terminal.imprimir("❌ Entrada inválida. Debe ser un número.");
                    }
                }

                CombosFactory comboSeleccionado = switch (opcion) {
                    case 1 -> new Combo1();
                    case 2 -> new Combo2();
                    case 3 -> new Combo3();
                    default -> new Combo1(); // nunca llega aquí
                };

                comboSeleccionado.crearAdicion(pedido).agregarElemento();
                comboSeleccionado.crearBatido().preparar(pedido);
            }

            mesero.tomarPedido(pedido);
            terminal.imprimir(pedido.getDescripcion());
            cocineros.realizarTarea();

            // Cierre del restaurante
            terminal.imprimir("¿Desea cerrar el restaurante? (SI / NO)");
            String cerrar = terminal.recibir().toUpperCase();
            if (cerrar.equals("SI")) {
                estado.setEstado(new EstadoCerrado());
                estado.ejecutarEstado();
                terminal.imprimir("💵 La caja terminó con $" + caja.getDinero());
                for (CajaPasada cp : mediador.getHistorial().values()) {
                    terminal.imprimir(cp.getCaja().getFactura().toString());
                }
            }
        }
    }
}
