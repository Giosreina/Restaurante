package com.example.Patrones.Iterator;

public class IteradorLista extends Iterator {
    private Agregado agregado;
    private int posicion;

    public IteradorLista(Agregado agregado) {
        this.agregado = agregado;
        this.posicion = 0;
    }

    @Override
    public void primero() {
        posicion = 0;
    }

    @Override
    public void siguiente() {
        if (!haTerminado()) {
            posicion++;
        }
    }

    @Override
    public boolean haTerminado() {
        return posicion >= agregado.cantidadElementos();
    }

    @Override
    public Object actual() {
        if (haTerminado()) {
            return null;
        }
        return agregado.obtenerElemento(posicion);
    }
    public int getPosicion() {
        return posicion;
    }
}
