package com.example.Logica;

import java.util.List;

public class Batido extends Alimento{
    private List<String> frutas;
    private boolean lecheCondensada, azucar;

    public Batido(List<String> frutas, boolean lecheCondensada, boolean azucar, String nombre, double precio, String descripcion, Pedido pedido) {
        super(nombre, precio, "BEBIDA", descripcion, pedido);
        this.frutas = frutas;
        this.lecheCondensada = lecheCondensada;
        this.azucar = azucar;
    }

    public Batido(Pedido pedido) {
        super("Batido personalizado", 10000.0, "BEBIDA", "Batido personalizado para ti my baby", pedido);
    }

    public void setFrutas(List<String> frutas) {
        this.frutas = frutas;
    }

    public List<String> getFrutas() {
        return frutas;
    }

    public boolean isLecheCondensada() {
        return lecheCondensada;
    }

    public void setLecheCondensada(boolean lecheCondensada) {
        this.lecheCondensada = lecheCondensada;
    }

    public boolean isAzucar() {
        return azucar;
    }

    public void setAzucar(boolean azucar) {
        this.azucar = azucar;
    }
}
