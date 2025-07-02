package com.example.Patrones.Visitor;

public class Equipo implements ElementoRestaurante {
    private String tipo;
    private int horasUso;

    public Equipo(String tipo, int horasUso) {
        this.tipo = tipo;
        this.horasUso = horasUso;
    }

    public String getTipo() { return tipo; }
    public int getHorasUso() { return horasUso; }

    @Override
    public void aceptar(VisitorRestaurante visitor) {
        visitor.visitar(this);
    }
}

