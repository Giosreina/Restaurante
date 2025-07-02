package com.example.Patrones.Observer.Observer;
import com.example.Logica.Pedido;
import com.example.Patrones.Prototype.*;

public class Cocinero extends Personal {
    private boolean disponibilidad = true;
    private Pedido pedido;
    private TurnoPrototype turnoCocinero;

    public Cocinero(String nombre) {
        super(nombre);
    }

    public void actualizar(Pedido pedido) {
        if (disponibilidad) {
            if (pedido.getTipoComida().equals("COMIDA")) {
                this.pedido = pedido;
                disponibilidad = false;
            }
        }
    }

    public String realizarTarea() {
        disponibilidad = true; // Reset availability after preparing
        return "preparando " + pedido.getTipoComida();
    }
    public void asignarTurno(String turno){
        HorariosDisponibles horariosDisponibles = new HorariosDisponibles();
        turnoCocinero = horariosDisponibles.obtenerTurno(turno);
    }
}
