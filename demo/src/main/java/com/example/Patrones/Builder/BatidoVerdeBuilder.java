package com.example.Patrones.Builder;

import com.example.Logica.Batido;

public class BatidoVerdeBuilder extends BatidoBuilder{
    private String Fruta1, Fruta2, Fruta3;
    private boolean lecheCondensada, azucar;
    
    @Override
    public BatidoBuilder setFruta1() {
        Fruta1 = "Kiwi";
        return this;
    }

    @Override
    public BatidoBuilder setFruta2() {
        Fruta1 = "Manzana Verde";
        return this;
    }

    @Override
    public BatidoBuilder setFruta3() {
        Fruta1 = "Uvas";
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
    public Batido preparar() {
        return new Batido(Fruta1, Fruta2, Fruta3, lecheCondensada, azucar, "BATIDO VERDE", 8000, "Kiwi, manzana verde y uvas con azúcar.");
    }
}
