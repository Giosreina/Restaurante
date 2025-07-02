package com.example.Patrones.Decorator;

import com.example.Logica.Alimento;
import com.example.Patrones.Iterator.Agregado;
import com.example.Patrones.Iterator.Iterator;

public class AdicionGuacamole extends AdicionAbstract{
    
    public AdicionGuacamole(Agregado pedido) {
        super(pedido);
    }
    
    @Override
    public void agregarElemento(Object comida) {
        
    }

    @Override
    public int cantidadElementos() {
        return pedido.cantidadElementos() + 1;
    }

    @Override
    public Object obtenerElemento(int indice) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminarElemento(Object comida) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public Iterator crearIterator() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void agregarElemento() {
        pedido.agregarElemento(new Alimento("Guacamole", 3500, "COMIDA", "Aguacate, tomate, cebolla y limon"));
    }
}
