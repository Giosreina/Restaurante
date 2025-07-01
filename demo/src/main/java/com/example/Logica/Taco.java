package com.example.Logica;

public class Taco extends Comida{
    private String tipoTortilla;
    private String tipoCarne;
    private String vegetales;
    private String tipoPicante;

    public Taco(String tipoTortilla, String tipoCarne, String vegetales, String tipoPicante, String nombre, double precio, String tipoComida, String descripcion) {
        super(nombre, precio, "COMIDA", descripcion);
        this.tipoTortilla = tipoTortilla;
        this.tipoCarne = tipoCarne;
        this.vegetales = vegetales;
        this.tipoPicante = tipoPicante;
    }
}
