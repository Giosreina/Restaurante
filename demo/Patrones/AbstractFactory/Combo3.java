package com.example.Patrones.AbstractFactory;

import com.example.Logica.Pedido;
import com.example.Patrones.Builder.BatidoBuilder;
import com.example.Patrones.Builder.BatidoCitricoBuilder;
import com.example.Patrones.Decorator.AdicionAbstract;
import com.example.Patrones.Decorator.AdicionMazorcaGratinada;

public class Combo3 extends CombosFactory{

    @Override
    public BatidoBuilder crearBatido() {
        return new BatidoCitricoBuilder();
    }

    @Override
    public AdicionAbstract crearAdicion(Pedido pedido) {
        return new AdicionMazorcaGratinada(pedido);
    }
    
}
