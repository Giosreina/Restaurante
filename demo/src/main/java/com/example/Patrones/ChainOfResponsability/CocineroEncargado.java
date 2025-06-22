package com.example.Patrones.ChainOfResponsability;

import com.example.Logica.Comida;
import com.example.Utilities.SalidaTerminal;

public abstract class CocineroEncargado implements Encargado{
    private Encargado next;
    private String nombre;
    private String condicion;
    public void setNext(Encargado next){
        this.next = next;
    }
    public void procesarSolicitud(Comida comida){
        if(comida.getTipoComida().equals(condicion)) {
            SalidaTerminal.imprimir("El cocinero encargado está procesando la solicitud de comida: " + comida.getNombre());
            SalidaTerminal.imprimir("Detalles de la comida: " + comida.getDescripcion() + " - Precio: " + comida.getPrecio());
        }
        else if (next != null) {
            next.procesarSolicitud(comida);
        } else {
            System.out.println("No hay encargado disponible para procesar la solicitud de comida: " + comida.getNombre());
        }
    }
}
