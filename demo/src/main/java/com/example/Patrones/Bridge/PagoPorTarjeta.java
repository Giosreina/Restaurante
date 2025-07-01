package com.example.Patrones.Bridge;

import com.example.Patrones.MethodFactory.Fabricas;
import com.example.Patrones.MethodFactory.LlamadoFactura;
import com.example.Patrones.Singleton.CuentaRestaurante;
import com.example.Logica.Pedido;
import com.example.Patrones.Memento.HistorialDeCajas;

public class PagoPorTarjeta extends MetodoDePago {
    private CuentaRestaurante cuentaRestaurante;
    private Fabricas fabrica = new LlamadoFactura();

    @Override
    public void procesarPago(int id, String cliente, String distribuidor, Pedido compras, HistorialDeCajas historial) {
        if (cuentaRestaurante == null) {
            cuentaRestaurante = CuentaRestaurante.getInstancia();
        }
        cuentaRestaurante.meterDinero(fabrica.crearFactura(id, cliente, distribuidor, compras).getPrecio());
    }
}
