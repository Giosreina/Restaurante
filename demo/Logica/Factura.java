package com.example.Logica;
import java.util.Date;


public class Factura {
    private static int contador = 0;
    private int id;
    private String cliente;
    private String distribuidor;
    private Pedido compras;
    private Date FECHA = new Date();
    private boolean estado = false; // false = pendiente, true = pagada

    public Factura(String cliente, Pedido compras) {
        this.id = contador++;
        this.cliente = cliente;
        this.distribuidor = "RESTAURANTE TACCOS LOS COMPAS";
        this.compras = compras;
    }
    public double getPrecio() {
        return compras.getPrecio();
    }
    public int getId() {
        return id;
    }
    public String getCliente() {
        return cliente;
    }
    public String getDistribuidor() {
        return distribuidor;
    }
    public Pedido getCompras() {
        return compras;
    }
    public Date getFecha() {
        return FECHA;
    }
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Factura{" + "id=" + id + ", cliente=" + cliente + ", distribuidor=" + distribuidor + ", compras=" + compras.getDescripcion() + ", FECHA=" + FECHA + '}';
    }
}
