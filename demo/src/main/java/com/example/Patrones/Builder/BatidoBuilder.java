package com.example.Patrones.Builder;

import com.example.Logica.Batido;
import com.example.Patrones.Iterator.Agregado;

public abstract class BatidoBuilder {
    public abstract BatidoBuilder setFruta1();
    public abstract BatidoBuilder setFruta2();
    public abstract BatidoBuilder setFruta3();
    public abstract BatidoBuilder setLecheCondensada();
    public abstract BatidoBuilder setAzucar();
    public abstract Batido preparar(Agregado pedido);
}
