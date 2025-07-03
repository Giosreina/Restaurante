package com.example.Patrones.Builder;

import com.example.Logica.Batido;
import com.example.Logica.Pedido;
import com.example.Patrones.Iterator.Agregado;
import java.util.ArrayList;
import java.util.List;

public class BatidoTropicalBuilder extends BatidoBuilder{
    private List<String> frutas;
    private boolean lecheCondensada, azucar;
    
    @Override
    public BatidoBuilder setFrutas() {
        frutas = new ArrayList<>();
        frutas.add("Mango");
        frutas.add("Piña");
        frutas.add("Banano");
        return this;
    }

    @Override
    public BatidoBuilder setLecheCondensada() {
        lecheCondensada = true;
        return this;
    }

    @Override
    public BatidoBuilder setAzucar() {
        azucar = false;
        return this;
    }

    @Override
    public Batido preparar(Agregado pedido) {
        return new Batido(frutas, lecheCondensada, azucar, "BATIDO TROPICAL", 9000, "Mango, piña y banano con leche condensada.", (Pedido) pedido);
    }
}