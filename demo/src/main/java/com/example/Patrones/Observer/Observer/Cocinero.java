package com.example.Patrones.Observer.Observer;
import com.example.Logica.Pedido;
public class Cocinero extends Personal {
    private boolean disponibilidad = true;
    private Pedido pedido;

    public void actualizar(Pedido pedido) {
        if (disponibilidad) {
            if (pedido.getTipoComida().equals("COMIDA")) {
                this.pedido = pedido;
                disponibilidad = false;
            }
        }
    }

    public String preparar() {
        disponibilidad = true; // Reset availability after preparing
        return "preparando " + pedido.getTipoComida();
    }
}
