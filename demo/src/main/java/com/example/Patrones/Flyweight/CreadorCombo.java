package com.example.Patrones.Flyweight;

import java.util.HashMap;
import java.util.Map;
import com.example.Logica.Alimento;
import com.example.Logica.Pedido;

public class CreadorCombo {

    private Map<String, Alimento> recetas = new HashMap<>();

    public Alimento crearComida(String nombre, double precio, String tipoComida, String descripcion, Pedido  pedido) {
        Alimento comparador = recetas.get(nombre);
        if (comparador == null) {
            comparador = new Alimento(nombre, precio, tipoComida, descripcion, pedido);
            recetas.put(nombre, comparador);
        }
        return comparador;
    }
}
