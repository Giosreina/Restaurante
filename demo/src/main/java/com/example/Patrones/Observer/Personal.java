package com.example.Patrones.Observer;
import com.example.Logica.Pedido;
import com.example.Logica.Persona;

public abstract class Personal extends Persona{

    public Personal(String nombre) {
        super(nombre);
    }
    public abstract void actualizar(Pedido pedido);
    public abstract void realizarTarea();
    public abstract void asignarTurno(String turno);
}
