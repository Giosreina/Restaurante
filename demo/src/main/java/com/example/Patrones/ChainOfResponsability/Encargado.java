package com.example.Patrones.ChainOfResponsability;

import com.example.Logica.Comida;

public interface Encargado {
    public void setNext(Encargado next);
    public String procesarSolicitud(Comida comida);
}
