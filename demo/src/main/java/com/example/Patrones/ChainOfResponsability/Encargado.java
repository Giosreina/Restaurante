package com.example.Patrones.ChainOfResponsability;

import com.example.Logica.Pedido;

public interface Encargado {
    public void setNext(Encargado next);
    public void actualizar(Pedido comida);
}
