package com.example.Patrones.Strategy;

import com.example.Logica.Pedido;
import com.example.Patrones.Observer.Observer.Cocina;

public class EntregaDomicilio extends EstrategiaEntrega{

    public EntregaDomicilio(Cocina cocina) {
        super(cocina);
    }

    @Override
    public String entregar(Pedido pedido) {
        return "Llevando el pedido de "+pedido.getNombre()+" a su direccion";
    }
    
}
