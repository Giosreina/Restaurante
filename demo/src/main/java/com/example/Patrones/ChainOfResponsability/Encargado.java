package com.example.Patrones.ChainOfResponsability;

import com.example.Logica.Alimento;

public interface Encargado {
    public void setNext(Encargado next);
    public String procesarSolicitud(Alimento comida);
}
