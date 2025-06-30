package com.example.Patrones.Visitor;
import com.example.Logica.Pedido;
import com.example.Patrones.Memento.*;

public class VisitorImpresion implements Visitor {
    @Override
    public CajaPasada visitarCaja(Caja caja) {
        return caja.saveCaja();
    }

    @Override
    public double visitarPedido(Pedido pedido) {
        return pedido.getPrecio();
    }
}
