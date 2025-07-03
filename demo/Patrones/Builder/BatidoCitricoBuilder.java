package com.example.Patrones.Builder;

import com.example.Logica.Batido;
import com.example.Logica.Pedido;
import com.example.Patrones.Iterator.Agregado;
import java.util.ArrayList;
import java.util.List;

public class BatidoCitricoBuilder extends BatidoBuilder {

    private List<String> frutas;
    private boolean lecheCondensada, azucar;

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
    public BatidoBuilder setFrutas() {
        frutas = new ArrayList<>();
        frutas.add("Papaya");
        frutas.add("Maracuya");
        frutas.add("Naranja");
        return this;
    }

    @Override
    public Batido preparar(Agregado pedido) {
        return new Batido(frutas, lecheCondensada, azucar, "BATIDO CITRICO", 9500, "Papaya, naranja y maracuyá con leche condensada.", (Pedido) pedido);
    }

}
