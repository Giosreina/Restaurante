package com.example.Patrones.AbstractFactory;

import com.example.Logica.Pedido;
import com.example.Patrones.Builder.BatidoBuilder;
import com.example.Patrones.Builder.BatidoRojoBuilder;
import com.example.Patrones.Decorator.AdicionAbstract;
import com.example.Patrones.Decorator.AdicionPapaFrita;

public class Combo1 extends CombosFactory{

    @Override
    public BatidoBuilder crearBatido() {
        return new BatidoRojoBuilder();
    }

    @Override
    public AdicionAbstract crearAdicion(Pedido pedido) {
        return new AdicionPapaFrita(pedido);
    }
    
}
