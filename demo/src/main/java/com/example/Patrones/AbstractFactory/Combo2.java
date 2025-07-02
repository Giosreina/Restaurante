package com.example.Patrones.AbstractFactory;

import com.example.Logica.Pedido;
import com.example.Patrones.Builder.BatidoBuilder;
import com.example.Patrones.Builder.BatidoTropicalBuilder;
import com.example.Patrones.Decorator.AdicionAbstract;
import com.example.Patrones.Decorator.AdicionGuacamole;

public class Combo2 extends CombosFactory{

    @Override
    public BatidoBuilder crearBatido() {
        return new BatidoTropicalBuilder();
    }

    @Override
    public AdicionAbstract crearAdicion(Pedido pedido) {
        return new AdicionGuacamole(pedido);
    }
    
}
