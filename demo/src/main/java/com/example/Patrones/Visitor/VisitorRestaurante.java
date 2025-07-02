package com.example.Patrones.Visitor;

public interface VisitorRestaurante {
    String visitar(Ingrediente ingrediente);
    String visitar(Equipo equipo);
}
