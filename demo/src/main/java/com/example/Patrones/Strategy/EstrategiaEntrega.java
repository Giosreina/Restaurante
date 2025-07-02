package com.example.Patrones.Strategy;

import com.example.Logica.Pedido;
import com.example.Patrones.Observer.Observer.Cocina;

public abstract class EstrategiaEntrega {
    private Cocina cocina;
    public EstrategiaEntrega(Cocina cocina){
        this.cocina = cocina;
        cocina.setEstrategiaEntrega(this);
    }
    public abstract String entregar(Pedido pedido);
}
