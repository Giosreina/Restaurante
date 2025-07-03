package com.example.Patrones.Visitor;

public interface ElementoRestaurante {
    String aceptar(VisitorRestaurante visitor);
    String getTipo();
}