package com.example.Patrones.ChainOfResponsability;

import com.example.Logica.Alimento;
import com.example.Logica.Pedido;
import com.example.Patrones.Observer.Observer.Personal;
import com.example.Patrones.Prototype.*;

public abstract class CocineroEncargado extends Personal implements Encargado{
    private Encargado next;
    private String nombre;
    private String condicion;
    private boolean disponibilidad = true; // Indicates if the cook is available
    private Pedido comida;
    private TurnoPrototype turnoCocinero;
    public CocineroEncargado (String nombre, String condicion) {
        super(nombre);
        this.condicion = condicion;
    }
    public void setNext(Encargado next){
        this.next = next;
    }
    public void actualizar(Pedido comida) {
        String mensaje = "";
        this.comida = comida; // Store the food item for later use
        if(comida.getTipoComida().equals(condicion)) {
            mensaje = "El encargado " + nombre + " está procesando la solicitud de comida: " + comida.getDescripcion()+"\n" 
                    + "El cocinero está " + realizarTarea() + "\n";
        }
        else if (next != null) {
            next.actualizar(comida);
        } else {
            mensaje = "No hay encargado disponible para procesar la solicitud de comida: " + comida.getDescripcion();
        }
    }
    public String getNombre() {
        return nombre;
    }
    public String realizarTarea(){
        disponibilidad = true; // Reset availability after preparing
        return "preparando " + comida.getTipoComida();
    }
    public void asignarTurno(String turno){
        this.turnoCocinero = new HorariosDisponibles().obtenerTurno(turno);
    }
}
