package com.example.Patrones.Iterator;

public abstract class Agregado {

    public abstract Iterator crearIterator();

    public abstract int cantidadElementos();

    public abstract Object obtenerElemento(int indice);

    public abstract void agregarElemento(Object comida);

    public abstract void agregarElemento();

    public abstract void eliminarElemento(Object comida);

}
