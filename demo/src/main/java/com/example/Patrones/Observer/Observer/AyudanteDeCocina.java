package com.example.Patrones.Observer.Observer;
import com.example.Logica.Pedido;
public class AyudanteDeCocina extends Personal {
    private boolean disponibilidad;
    private Pedido pedido;

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
}
