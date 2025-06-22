package com.example.Patrones.MethodFactory;
import com.example.Logica.Factura;
import com.example.Logica.Pedido;

public abstract class Fabricas {
    public abstract Factura crearFactura(int id, String cliente, String distribuidor, Pedido compras);
}