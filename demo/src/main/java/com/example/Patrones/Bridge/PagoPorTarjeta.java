package com.example.Patrones.Bridge;

import com.example.Patrones.MethodFactory.Fabricas;
import com.example.Patrones.MethodFactory.LlamadoFactura;
import com.example.Patrones.Singleton.CuentaRestaurante;
import com.example.Logica.Pedido;
import com.example.Patrones.MethodFactory.*;

public class PagoPorTarjeta extends MetodoDePago {

    private CuentaRestaurante cuentaRestaurante;
    private Fabricas fabrica = new LlamadoFactura();

    @Override
    public void procesarPago(String cliente, Pedido compras) {
        if (cuentaRestaurante == null) {
            cuentaRestaurante = CuentaRestaurante.getInstancia();
        }
        cuentaRestaurante.recibirDinero(fabrica.crearFactura(cliente, compras).getPrecio());
    }
}
