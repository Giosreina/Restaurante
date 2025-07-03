package com.example.Patrones.ChainOfResponsability;

import com.example.Patrones.Visitor.*;

public interface Encargado {
    public void setNext(Encargado next);
    public void limpiar(ElementoRestaurante elementoRestaurante);
}
