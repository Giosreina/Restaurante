package com.example.Patrones.AbstractFactory;

import com.example.Logica.Pedido;
import com.example.Patrones.Builder.BatidoBuilder;
import com.example.Patrones.Decorator.AdicionAbstract;

public abstract class CombosFactory {
    public abstract BatidoBuilder crearBatido();
    public abstract AdicionAbstract crearAdicion(Pedido pedido);
}
