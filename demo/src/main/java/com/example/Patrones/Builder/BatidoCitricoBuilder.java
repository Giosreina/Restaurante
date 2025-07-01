package com.example.Patrones.Builder;

import com.example.Logica.Batido;

public class BatidoCitricoBuilder extends BatidoBuilder{
    private String Fruta1, Fruta2, Fruta3;
    private boolean lecheCondensada, azucar;
    
    @Override
    public BatidoBuilder setFruta1() {
        Fruta1 = "Papaya";
        return this;
    }

    @Override
    public BatidoBuilder setFruta2() {
        Fruta1 = "Naranja";
        return this;
    }

    @Override
    public BatidoBuilder setFruta3() {
        Fruta1 = "Maracuya";
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
    public Batido preparar() {
        return new Batido(Fruta1, Fruta2, Fruta3, lecheCondensada, azucar, "BATIDO CITRICO", 9500, "Papaya, naranja y maracuyá con leche condensada.");
    }
}
