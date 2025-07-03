package com.example.Patrones.Interpreter;

import com.example.Patrones.Visitor.Inventario;
import com.example.Patrones.Visitor.Equipo;

public class EquipoExpression implements Expression {
    private String nombreEquipo;

    public EquipoExpression(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo.toUpperCase();
    }

    @Override
    public boolean interpret(Inventario inventario) {
        for (int i = 0; i < inventario.cantidadElementos(); i++) {
            Object obj = inventario.obtenerElemento(i);
            if (obj instanceof Equipo) {
                Equipo equipo = (Equipo) obj;
                if (equipo.getTipo().toUpperCase().equals(nombreEquipo)) {
                    return true;
                }
            }
        }
        return false;
    }
}
