package com.example.Patrones.Facade;

import com.example.Patrones.Interpreter.*;
import com.example.Patrones.Visitor.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import com.example.Utilities.IOTerminal;

public class FacadeInventarioYAlmacen extends FacadeAbstract {

    private Inventario inventario;
    private Almacen almacen;
    private final IOTerminal terminal;

    public FacadeInventarioYAlmacen() {
        this.inventario = new Inventario();
        this.almacen = new Almacen();
        this.terminal = new IOTerminal();
    }

    // ===================== Métodos públicos =====================
    public void buscarEquiposPorConsulta(String consulta) {
        Expression expr = construirExpresionEquipos(consulta);
        if (expr == null) {
            terminal.imprimir("❌ Consulta inválida.");
            return;
        }

        boolean resultado = expr.interpret(inventario);
        terminal.imprimir("🔎 Resultado de la consulta: " + (resultado ? "Sí cumple" : "No cumple"));
    }

    public void inspeccionarTodo() {
        Inspector inspector = new Inspector();
        terminal.imprimir("📦 Resultados de inspección:");

        for (int i = 0; i < inventario.cantidadElementos(); i++) {
            Object obj = inventario.obtenerElemento(i);
            if (obj instanceof Equipo equipo) {
                terminal.imprimir(equipo.aceptar(inspector));
            }
        }

        for (int i = 0; i < almacen.cantidadElementos(); i++) {
            Object obj = almacen.obtenerElemento(i);
            if (obj instanceof Ingrediente ingrediente) {
                terminal.imprimir(ingrediente.aceptar(inspector));
            }
        }
    }

    public void mostrarContenidoAlmacen() {
        terminal.imprimir("🥬 Ingredientes en almacén:");
        System.out.println("a");
        for (int i = 0; i < almacen.cantidadElementos(); i++) {
            System.out.println("b");
            terminal.imprimir(" - " + almacen.obtenerElemento(i).toString());
        }
        System.out.println("c");
    }

    // ===================== Interpreter =====================
    private Expression construirExpresionEquipos(String consulta) {
        String[] tokens = consulta.toUpperCase().split(" ");
        Stack<Expression> stack = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];

            if (token.equals("AND") || token.equals("OR")) {
                if (stack.size() < 1 || i + 1 >= tokens.length) {
                    return null;
                }

                Expression izquierda = stack.pop();
                Expression derecha = new EquipoExpression(tokens[++i]);

                if (token.equals("AND")) {
                    stack.push(new AndExpression(izquierda, derecha));
                } else {
                    stack.push(new OrExpression(izquierda, derecha));
                }
            } else {
                stack.push(new EquipoExpression(token));
            }
        }

        return stack.isEmpty() ? null : stack.pop();
    }

    // ===================== Implementación fachada =====================
    @Override
    public void atenderCliente() {
        terminal.imprimir("""
            ==== Menú de Inventario y Almacén ====
            1. Ver todo el contenido
            2. Buscar equipos (consulta con AND/OR)
            3. Ejecutar inspección
            4. Agregar elemento al almacen
            Seleccione una opción:
        """);

        String opcion = terminal.recibir();

        switch (opcion) {
            case "1" ->
                mostrarContenidoAlmacen();
            case "2" -> {
                terminal.imprimir("Ingrese la consulta (Ej: LICUADORA OR FREIDORA):");
                buscarEquiposPorConsulta(terminal.recibir());
            }
            case "3" ->
                inspeccionarTodo();
            case "4" -> {
                while (true) {
                    terminal.imprimir("Deseas agregar un elemento?(SI/NO)");
                    if (terminal.recibir().equals("NO")) {
                        break;
                    }
                    almacen.agregarElemento(new Ingrediente(terminal.recibir(), false, "comida"));
                    System.out.println(almacen.obtenerElemento(0));

                }
            }
            default ->
                terminal.imprimir("⚠️ Opción no válida.");
        }
    }

    // ===================== Accesores =====================
    public Inventario getInventario() {
        return inventario;
    }

    public Almacen getAlmacen() {
        return almacen;
    }
}
