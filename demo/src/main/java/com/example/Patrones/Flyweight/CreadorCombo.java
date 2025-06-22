package com.example.Patrones.Flyweight;

import java.util.HashMap;
import java.util.Map;
import com.example.Logica.Comida;

public class CreadorCombo {
    private Map<String,Comida> recetas = new HashMap<>();
    public Comida crearComida(String nombre, double precio, String tipoComida, String descripcion){
        Comida comparador = recetas.get(nombre);
        if(comparador == null){
            comparador = new Comida(nombre, precio, tipoComida,descripcion);
            recetas.put(nombre, comparador);
        }
        return comparador;
    }
}