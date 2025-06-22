package com.example.Patrones.Bridge;
import com.example.Logica.Pedido;
import com.example.Patrones.MethodFactory.*;
import com.example.Logica.Nequi;

public class PagoPorNequi extends MetodoDePago {
    private Nequi nequi = new Nequi();
    private Fabricas fabrica = new LlamadoFactura();

    @Override
    public void procesarPago(int id, String cliente, String distribuidor, Pedido compras) {
        nequi.meterDinero(fabrica.crearFactura(id, cliente, distribuidor, compras).getPrecio());
    }
}
