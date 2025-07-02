package com.example.Patrones.Flyweight;

import com.example.Logica.Alimento;
import com.example.Logica.Pedido;
import com.example.Patrones.Iterator.Agregado;

public class Combo {

    private Pedido comidas;
    private CreadorCombo creador;
    private double descuento;

    public void añadirComida(String nombre, double precio, String tipoComida, String descripcion, Pedido pedido) {
        comidas.agregarElemento(creador.crearComida(nombre, precio, tipoComida, descripcion, pedido));
    }

    public double getPrecio() {
        return comidas.getPrecio() * descuento;
    }

    public void eliminarComida(Alimento comida) {
        comidas.eliminarElemento(comida);
    }
}
