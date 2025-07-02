package com.example.Patrones.Decorator;

import com.example.Logica.Alimento;
import com.example.Logica.Pedido;
import com.example.Patrones.Iterator.Iterator;

public class AdicionPapaFrita extends AdicionAbstract {

    public AdicionPapaFrita(Pedido pedido) {
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
        new Alimento("Papas Fritas", 5000, "COMIDA", "Porcion de papas fritas", pedido);
    }
}
