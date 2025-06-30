package com.example.Logica;
import java.util.Date;
import com.example.Patrones.Visitor.*;

public class Factura {
    private int id;
    private String cliente;
    private String distribuidor;
    private Pedido compras;
    private Date FECHA = new Date();
    private boolean estado = false; // false = pendiente, true = pagada
    private Visitor v = new VisitorImpresion();

    public Factura(int id, String cliente, String distribuidor, Pedido compras) {
        this.id = id;
        this.cliente = cliente;
        this.distribuidor = distribuidor;
        this.compras = compras;
    }
    public double getPrecio() {
        return v.visitarPedido(compras);
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
    
}
