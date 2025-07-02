package com.example.Patrones.Strategy;

import com.example.Logica.Pedido;
import com.example.Patrones.Observer.Observer.Cocina;

public class EntregaRappi extends EstrategiaEntrega{

    public EntregaRappi(Cocina cocina) {
        super(cocina);
    }

    @Override
    public String entregar(Pedido pedido) {
        return "Entregando el pedido de "+pedido.getNombre()+" al repartidor de Rappi";
    }
    
}
