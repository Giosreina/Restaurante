package com.example.Patrones.Builder;

import com.example.Logica.Batido;
import com.example.Patrones.Iterator.Agregado;

public abstract class BatidoBuilder {
    public abstract BatidoBuilder setFrutas();
    public abstract BatidoBuilder setLecheCondensada();
    public abstract BatidoBuilder setAzucar();
    public abstract Batido preparar(Agregado pedido);
}
