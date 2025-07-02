package com.example.Logica;

public class Batido extends Alimento{
    private String Fruta1, Fruta2, Fruta3;
    private boolean lecheCondensada, azucar;

    public Batido(String Fruta1, String Fruta2, String Fruta3, boolean lecheCondensada, boolean azucar, String nombre, double precio, String descripcion) {
        super(nombre, precio, "BEBIDA", descripcion);
        this.Fruta1 = Fruta1;
        this.Fruta2 = Fruta2;
        this.Fruta3 = Fruta3;
        this.lecheCondensada = lecheCondensada;
        this.azucar = azucar;
    }
}
