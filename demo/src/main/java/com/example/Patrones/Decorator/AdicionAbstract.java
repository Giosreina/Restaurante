package com.example.Patrones.Decorator;

import com.example.Logica.Pedido;
import com.example.Patrones.Iterator.Agregado;

public abstract class AdicionAbstract extends Agregado{
    protected Pedido pedido;
    
    public AdicionAbstract(Pedido pedido){
        this.pedido = pedido;
    }
}
