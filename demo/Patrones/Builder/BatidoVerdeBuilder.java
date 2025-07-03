 package com.example.Patrones.Builder;

import com.example.Logica.Batido;
import com.example.Logica.Pedido;
import com.example.Patrones.Iterator.Agregado;
import java.util.ArrayList;
import java.util.List;

public class BatidoVerdeBuilder extends BatidoBuilder{
    private List<String> frutas;
    private boolean lecheCondensada, azucar;
    
    @Override
    public BatidoBuilder setFrutas() {
        frutas = new ArrayList<>();
        frutas.add("Manzana Verde");
        frutas.add("Kiwi");
        frutas.add("Uvas");
        return this;
    }

    @Override
    public BatidoBuilder setLecheCondensada() {
        lecheCondensada = false;
        return this;
    }

    @Override
    public BatidoBuilder setAzucar() {
        azucar = true;
        return this;
    }

    @Override
    public Batido preparar(Agregado pedido) {
        return new Batido(frutas, lecheCondensada, azucar, "BATIDO VERDE", 8000, "Kiwi, manzana verde y uvas con azúcar.", (Pedido) pedido);
    }
}
