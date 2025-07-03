package com.example.Patrones.Visitor;

import com.example.Patrones.Iterator.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class Almacen extends Agregado {

    private Map<String, Ingrediente> ingredientes;

    public Almacen() {
        this.ingredientes = new LinkedHashMap<>(); // ← importante
    }

    public Iterator crearIterator() {
        return new IteradorLista(this);
    }

    public int cantidadElementos() {
        return ingredientes.size();
    }

    public Object obtenerElemento(int indice) {
        if (indice < 0 || indice >= ingredientes.size()) {
            return null;
        }
        return ingredientes.values().toArray()[indice];
    }

    public void agregarElemento(Object comida) {
        if (comida instanceof Ingrediente ingrediente) {
            ingredientes.put(ingrediente.getNombre(), ingrediente);
        }
    }

    public void eliminarElemento(Object comida) {
        if (comida instanceof Ingrediente ingrediente) {
            ingredientes.remove(ingrediente.getNombre());
        }
    }

    @Override
    public void agregarElemento() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
