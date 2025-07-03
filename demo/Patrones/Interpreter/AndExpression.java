package com.example.Patrones.Interpreter;

import com.example.Patrones.Visitor.Inventario;

public class AndExpression implements Expression {
    private Expression expr1;
    private Expression expr2;

    public AndExpression(Expression expr1, Expression expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    @Override
    public boolean interpret(Inventario inventario) {
        return expr1.interpret(inventario) && expr2.interpret(inventario);
    }
}
