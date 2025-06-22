package com.example.Patrones.Bridge;
import com.example.Logica.Factura;
import com.example.Logica.Pedido;
import com.example.Patrones.Memento.*;
import com.example.Patrones.MethodFactory.*;

public class PagoEnEfectivo extends MetodoDePago {
    private Caja caja;
    private HistorialDeCajas historial = new HistorialDeCajas();
    private Fabricas fabrica = new LlamadoFactura();
    public PagoEnEfectivo(double monto, Caja caja, Factura factura) {
        this.caja = caja;
        this.caja.setFactura(factura);
    }

    @Override
    public void procesarPago(int id, String cliente, String distribuidor, Pedido compras) {
        caja.setFactura(fabrica.crearFactura(id, cliente, distribuidor, compras));
        caja.pagarFactura();
        historial.addCaja(caja);
    }
}
