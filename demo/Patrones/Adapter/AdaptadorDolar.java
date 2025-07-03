package com.example.Patrones.Adapter;

public class AdaptadorDolar implements ConversorDivisa {
    private ServicioDolar servicio;

    public AdaptadorDolar(ServicioDolar servicio) {
        this.servicio = servicio;
    }

    @Override
    public double convertir(double montoCOP) {
        return montoCOP / servicio.getTasaActual(); // Convierte COP a USD
    }
}
