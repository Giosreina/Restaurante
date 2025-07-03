package com.example.Patrones.Prototype;

// Clase concreta de Turno
public class Turno extends TurnoPrototype {
    private String nombre;
    private String horaEntrada;
    private String horaSalida;
    private boolean incluyeDescanso;
    private String uniforme;

    public Turno(String nombre, String horaEntrada, String horaSalida, boolean incluyeDescanso, String uniforme) {
        this.nombre = nombre;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.incluyeDescanso = incluyeDescanso;
        this.uniforme = uniforme;
    }

    @Override
    public TurnoPrototype clonar() {
        return new Turno(nombre, horaEntrada, horaSalida, incluyeDescanso, uniforme);
    }

    public void mostrarDetalles() {
        System.out.println("Turno: " + nombre + ", Entrada: " + horaEntrada + ", Salida: " + horaSalida +
                ", Descanso: " + incluyeDescanso + ", Uniforme: " + uniforme);
    }
}
