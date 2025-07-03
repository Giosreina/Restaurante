package com.example.Patrones.Facade;

import com.example.Patrones.Interpreter.*;
import com.example.Patrones.Visitor.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FachadaInventarioYAlmacen {

    private Inventario inventario;
    private Almacen almacen;

    public FachadaInventarioYAlmacen() {
        this.inventario = new Inventario();
        this.almacen = new Almacen();
        cargarDatosIniciales();
    }

    // ===================== Datos iniciales =====================
    private void cargarDatosIniciales() {
        inventario.agregarElemento(new Equipo("LICUADORA", 150));
        inventario.agregarElemento(new Equipo("CUCHILLO", 80));
        inventario.agregarElemento(new Equipo("FREIDORA", 1200)); // requiere mantenimiento

        almacen.agregarElemento(new Ingrediente("TOMATE", false, "VEGETAL"));
        almacen.agregarElemento(new Ingrediente("QUESO", true, "LACTEO"));    // caducado
        almacen.agregarElemento(new Ingrediente("LECHUGA", false, "VEGETAL"));
    }

    // ===================== Interpreter para Inventario =========================

    public boolean evaluarConsultaEquipos(String consulta) {
        Expression expr = construirExpresionEquipos(consulta);
        return expr != null && expr.interpret(inventario);
    }

    private Expression construirExpresionEquipos(String consulta) {
        String[] tokens = consulta.toUpperCase().split(" ");
        Stack<Expression> stack = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];

            if (token.equals("AND") || token.equals("OR")) {
                if (stack.size() < 1 || i + 1 >= tokens.length) return null;

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

    // ===================== Visitor =========================

    public List<String> inspeccionarInventarioYAlmacen() {
        List<String> resultados = new ArrayList<>();
        Inspector inspector = new Inspector();

        for (int i = 0; i < inventario.cantidadElementos(); i++) {
            Object obj = inventario.obtenerElemento(i);
            if (obj instanceof Equipo equipo) {
                resultados.add(equipo.aceptar(inspector));
            }
        }

        for (int i = 0; i < almacen.cantidadElementos(); i++) {
            Object obj = almacen.obtenerElemento(i);
            if (obj instanceof Ingrediente ingrediente) {
                resultados.add(ingrediente.aceptar(inspector));
            }
        }

        return resultados;
    }

    // ===================== Acceso directo =========================

    public Inventario getInventario() {
        return inventario;
    }

    public Almacen getAlmacen() {
        return almacen;
    }
}
