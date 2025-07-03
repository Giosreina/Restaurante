package com.example.Patrones.Interpreter;

import com.example.Patrones.Visitor.Inventario;

public interface Expression {
    boolean interpret(Inventario inventario);
}
