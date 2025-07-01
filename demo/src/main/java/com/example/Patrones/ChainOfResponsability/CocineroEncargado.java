package com.example.Patrones.ChainOfResponsability;

import com.example.Logica.Comida;
import com.example.Logica.Persona;

public abstract class CocineroEncargado extends Persona implements Encargado{
    private Encargado next;
    private String nombre;
    private String condicion;
    public CocineroEncargado (String nombre, String condicion) {
        super(nombre);
        this.condicion = condicion;
    }
    public void setNext(Encargado next){
        this.next = next;
    }
    public String procesarSolicitud(Comida comida){
        String mensaje = "";

        if(comida.getTipoComida().equals(condicion)) {
            mensaje = "El cocinero encargado está procesando la solicitud de comida: " + comida.getNombre()+"\n"+ "Detalles de la comida: " + comida.getDescripcion() + " - Precio: " + comida.getPrecio();
        }
        else if (next != null) {
            next.procesarSolicitud(comida);
        } else {
            mensaje = "No hay encargado disponible para procesar la solicitud de comida: " + comida.getNombre();
        }
        return mensaje;
    }
    public String getNombre() {
        return nombre;
    }
}
