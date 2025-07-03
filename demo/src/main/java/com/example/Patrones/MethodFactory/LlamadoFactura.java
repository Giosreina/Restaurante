package com.example.Patrones.MethodFactory;
import com.example.Logica.Factura;
import com.example.Logica.Pedido;

public class LlamadoFactura extends Fabricas {

    @Override
    public Factura crearFactura(String cliente,  Pedido compras) {
        return new Factura(cliente, compras);
    }
    
}
