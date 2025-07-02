package com.example.Patrones.Decorator;

import com.example.Logica.Alimento;
import com.example.Patrones.Iterator.Agregado;
import com.example.Patrones.Iterator.Iterator;

public class AdicionMazorcaGratinada extends AdicionAbstract{
    
    public AdicionMazorcaGratinada(Agregado pedido) {
        super(pedido);
    }
    
    @Override
    public void agregarElemento(Object comida) {
        pedido.agregarElemento(new Alimento("Mazorca Gratinada", 4000, "COMIDA", "Maiz dulce desgranado, mantequilla y queso rallado"));
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
}
