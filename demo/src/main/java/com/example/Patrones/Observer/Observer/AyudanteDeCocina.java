package com.example.Patrones.Observer.Observer;
import com.example.Logica.Pedido;
import com.example.Patrones.Prototype.HorariosDisponibles;
import com.example.Patrones.Prototype.*;

public class AyudanteDeCocina extends Personal {
    private boolean disponibilidad;
    private Pedido pedido;
    private TurnoPrototype turnoAyudante;

    public AyudanteDeCocina(String nombre) {
        super(nombre);
    }

    public void actualizar(Pedido pedido) {
        if (disponibilidad) {
            if (pedido.getTipoComida().equals("BEBIDA")) {
                this.pedido = pedido;
                disponibilidad = false;
            }
        }
    }

    public String preparar() {
        return "preparando " + pedido.getTipoComida();
    }

    public void asignarTurno(String turno){
        HorariosDisponibles horariosDisponibles = new HorariosDisponibles();
        turnoAyudante = horariosDisponibles.obtenerTurno(turno);
    }
}
