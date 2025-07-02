package com.example.Patrones.Visitor;

public class Ingrediente implements ElementoRestaurante {
    private String nombre;
    private boolean caducado;

    public Ingrediente(String nombre, boolean caducado) {
        this.nombre = nombre;
        this.caducado = caducado;
    }

    public String getNombre() { return nombre; }
    public boolean estaCaducado() { return caducado; }

    @Override
    public void aceptar(VisitorRestaurante visitor) {
        visitor.visitar(this);
    }
}

