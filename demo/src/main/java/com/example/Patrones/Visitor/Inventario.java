package com.example.Patrones.Visitor;

import com.example.Patrones.Iterator.*;
import java.util.Map;

public class Inventario extends Agregado{

    private Map<String, Equipo> equipos;

    public Iterator crearIterator(){
        return new IteradorLista(this);
    }

    public int cantidadElementos(){
        return equipos.size();
    }
    public Object obtenerElemento(int indice){
        if (indice < 0 || indice >= equipos.size()) {
            return null;
        }
        return equipos.values().toArray()[indice]; 
    }

    public void agregarElemento(Object herramienta){
        if (herramienta instanceof Equipo) {
            Equipo equipo = (Equipo) herramienta;
            equipos.put(equipo.getTipo(), equipo);
        }
    }

    public void eliminarElemento(Object herramienta){
        if (herramienta instanceof Equipo) {
            Equipo equipo = (Equipo) herramienta;
            equipos.put(equipo.getTipo(), equipo);
        }
    }    

    @Override
    public void agregarElemento() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

