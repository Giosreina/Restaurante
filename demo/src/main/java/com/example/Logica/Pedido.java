package com.example.Logica;
import java.util.ArrayList;
import java.util.List;
import com.example.Patrones.Iterator.*;

public class Pedido extends Agregado {
    private List<Comida> comidas = new ArrayList<>(); 
    private String nombre;
    private double precio;
    private String descripcion;
    private String tipoComida;

    public Pedido(String nombre) {
        this.nombre = nombre;
    }
    @Override
    public void agregarElemento(Object comida) {
        if (comida instanceof Comida) {
            this.comidas.add((Comida) comida);
        }
    }

    @Override
    public void eliminarElemento(Object comida) {
        if (comida instanceof Comida) {
            this.comidas.remove((Comida) comida);
        }
    }
    public String getDescripcion() {
        descripcion = "Plato: " + nombre + "\n";
        Iterator iterador = crearIterator();
        for (iterador.getPosicion() ; iterador.getPosicion() < comidas.size(); iterador.siguiente()) {
            if (iterador.actual() instanceof Comida) {
                Comida comida = (Comida) iterador.actual();
                descripcion += comida.getDescripcion() + "\n";
            }
        }
        return descripcion;
    }
    public double getPrecio() {
        precio = 0;
        Iterator iterador = crearIterator();
        for (iterador.getPosicion() ; iterador.getPosicion() < comidas.size(); iterador.siguiente()) {
            if (iterador.actual() instanceof Comida) {
                Comida comida = (Comida) iterador.actual();
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
    public Iterator crearIterator(){
        return new IteradorLista(this);
    }
    @Override
    public int cantidadElementos(){
        return comidas.size();
    }

    @Override
    public Comida obtenerElemento(int indice){
        if (indice < 0 || indice >= comidas.size()) {
            return null; // Manejo de índice fuera de rango
        }
        return comidas.get(indice);
    }
}
