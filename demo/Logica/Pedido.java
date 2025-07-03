package com.example.Logica;

import java.util.ArrayList;
import com.example.Patrones.Iterator.*;

public class Pedido extends Agregado {

    private ArrayList<Alimento> comidas = new ArrayList<>();
    private String nombre;
    private double precio;
    private String descripcion;
    private String tipoComida;
    private boolean estado; //preparado(true), no preparado(false)
    private String metodoEntrega; //En restaurante, domicilio restaurante o domicilio por terceros

    public Pedido(String nombre, String metodoEntrega) {
        this.nombre = nombre;
        this.metodoEntrega = metodoEntrega;
        metodoEntrega = "RESTAURANTE";
        estado = false;
    }

    public ArrayList<Alimento> getPedido() {
        return comidas;
    }

    @Override
    public void agregarElemento(Object comida) {
        if (comida instanceof Alimento) {
            comidas.add((Alimento) comida);
        }
    }

    @Override
    public void eliminarElemento(Object comida) {
        if (comida instanceof Alimento) {
            this.comidas.remove((Alimento) comida);
        }
    }

    public String getDescripcion() {
        descripcion = "Plato: " + nombre + "\n";
        Iterator iterador = crearIterator();
        for (iterador.getPosicion(); iterador.getPosicion() < comidas.size(); iterador.siguiente()) {
            if (iterador.actual() instanceof Alimento) {
                Alimento comida = (Alimento) iterador.actual();
                descripcion += comida.getNombre() + "\n";
            }
        }
        return descripcion;
    }

    public double getPrecio() {
        precio = 0;
        Iterator iterador = crearIterator();
        for (iterador.getPosicion(); iterador.getPosicion() < comidas.size(); iterador.siguiente()) {
            if (iterador.actual() instanceof Alimento) {
                Alimento comida = (Alimento) iterador.actual();
                precio += comida.getPrecio();
            }
        }
        return precio;
    }

    public String getTipoComida() {
        return tipoComida;
    }
    // Métodos de agregado para la implementación del patrón Iterator

    @Override
    public Iterator crearIterator() {
        return new IteradorLista(this);
    }

    @Override
    public int cantidadElementos() {
        return comidas.size();
    }

    @Override
    public Alimento obtenerElemento(int indice) {
        if (indice < 0 || indice >= comidas.size()) {
            return null; // Manejo de índice fuera de rango
        }
        return comidas.get(indice);
    }

    @Override
    public void agregarElemento() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void actualizarEstado() {
        int contador = 0;
        for (Alimento alimento : comidas) {
            if (alimento.isEstado()) {
                contador++;
            }
        }
        if (contador == comidas.size()) {
            this.estado = true;
        }
    }

    public boolean isEstado() {
        return estado;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMetodoEntrega() {
        return metodoEntrega;
    }

    
}
