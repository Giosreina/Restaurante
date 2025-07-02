package com.example.Patrones.Decorator;

import com.example.Patrones.Iterator.Agregado;

public abstract class AdicionAbstract extends Agregado{
    protected Agregado pedido;
    
    public AdicionAbstract(Agregado pedido){
        this.pedido = pedido;
    }
}
