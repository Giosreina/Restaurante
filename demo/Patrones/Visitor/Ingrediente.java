package com.example.Patrones.Visitor;

public class Ingrediente implements ElementoRestaurante {
    private String nombre;
    private boolean caducado;
    private String tipo;

    public Ingrediente(String nombre, boolean caducado, String tipo) {
        this.nombre = nombre;
        this.caducado = caducado;
        this.tipo = tipo;
    }

    public String getNombre() { return nombre; }
    public boolean estaCaducado() { return caducado; }
    public String getTipo() { return tipo; }
    @Override
    public String aceptar(VisitorRestaurante visitor) {
        return visitor.visitar(this);
    }

    @Override
    public String toString() {
        return "Ingrediente{" + "nombre=" + nombre + '}';
    }
    
}

