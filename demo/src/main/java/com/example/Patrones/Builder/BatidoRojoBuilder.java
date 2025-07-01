package com.example.Patrones.Builder;

import com.example.Logica.Batido;

public class BatidoRojoBuilder extends BatidoBuilder{
    private String Fruta1, Fruta2, Fruta3;
    private boolean lecheCondensada, azucar;
    
    @Override
    public BatidoBuilder setFruta1() {
        Fruta1 = "Fresa";
        return this;
    }

    @Override
    public BatidoBuilder setFruta2() {
        Fruta1 = "Mora";
        return this;
    }

    @Override
    public BatidoBuilder setFruta3() {
        Fruta1 = "Sandia";
        return this;
    }

    @Override
    public BatidoBuilder setLecheCondensada() {
        lecheCondensada = false;
        return this;
    }

    @Override
    public BatidoBuilder setAzucar() {
        azucar = azucar;
        return this;
    }

    @Override
    public Batido preparar() {
        return new Batido(Fruta1, Fruta2, Fruta3, lecheCondensada, azucar, "BATIDO ROJO", 8500, "Fresa, mora y sandía con azúcar.");
    }
}
