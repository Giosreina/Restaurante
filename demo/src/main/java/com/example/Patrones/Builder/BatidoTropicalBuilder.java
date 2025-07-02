package com.example.Patrones.Builder;

import com.example.Logica.Batido;
import com.example.Logica.Pedido;
import com.example.Patrones.Iterator.Agregado;

public class BatidoTropicalBuilder extends BatidoBuilder{
    private String Fruta1, Fruta2, Fruta3;
    private boolean lecheCondensada, azucar;
    
    @Override
    public BatidoBuilder setFruta1() {
        Fruta1 = "Mango";
        return this;
    }

    @Override
    public BatidoBuilder setFruta2() {
        Fruta1 = "Piña";
        return this;
    }

    @Override
    public BatidoBuilder setFruta3() {
        Fruta1 = "Banano";
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
        return new Batido(Fruta1, Fruta2, Fruta3, lecheCondensada, azucar, "BATIDO TROPICAL", 9000, "Mango, piña y banano con leche condensada.", (Pedido) pedido);
    }
}