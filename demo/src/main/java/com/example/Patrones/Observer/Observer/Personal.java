package com.example.Patrones.Observer.Observer;
import com.example.Logica.Pedido;
public abstract class Personal {
    public abstract void actualizar(Pedido pedido);
    public abstract String preparar();
    public abstract void asignarTurno(String turno);
}
