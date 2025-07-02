package com.example.Patrones.AbstractFactory;

import com.example.Logica.Pedido;
import com.example.Patrones.Builder.BatidoBuilder;
import com.example.Patrones.Builder.BatidoVerdeBuilder;
import com.example.Patrones.Decorator.AdicionAbstract;
import com.example.Patrones.Decorator.AdicionPapaFrita;

public class Combo4 extends CombosFactory{

    @Override
    public BatidoBuilder crearBatido() {
        return new BatidoVerdeBuilder();
    }

    @Override
    public AdicionAbstract crearAdicion(Pedido pedido) {
        return new AdicionPapaFrita(pedido);
    }
    
}
