package com.example.Patrones.ChainOfResponsability;

import com.example.Patrones.Visitor.*;
import com.example.Patrones.Iterator.Agregado;

public class Limpiador implements Encargado {
    private Encargado next;
    private String condicion;
    private Agregado agregado;

    public Limpiador(String condicion, Agregado agregado) {
        this.condicion = condicion;
        this.agregado = agregado;
    }
    @Override
    public void setNext(Encargado next) {
        this.next = next;
    }

    @Override
    public void limpiar(ElementoRestaurante elementoRestaurante) {
        if (elementoRestaurante.getTipo().equals(condicion)) {
            agregado.eliminarElemento(elementoRestaurante);
        } else if (next != null) {
            next.limpiar(elementoRestaurante);
        }
    }
}