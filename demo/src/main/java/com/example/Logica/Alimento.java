package com.example.Logica;

public class Alimento {
    private String nombre;
    private double precio;
    private String tipoComida;
    private String descripcion;
    private boolean estado; //preparado(true), no preparado(false)
    private Pedido pedido;

    public Alimento(String nombre, double precio, String tipoComida, String descripcion, Pedido pedido) {
        this.nombre = nombre;
        this.precio = precio;
        this.tipoComida = tipoComida;
        this.descripcion = descripcion;
        estado = false;
        this.pedido = (Pedido) pedido;
        pedido.agregarElemento(this);
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
    public String getTipoComida() {
        return tipoComida;
    }
    public String getDescripcion() {
        return descripcion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
        pedido.actualizarEstado();
    }

    public Pedido getPedido() {
        return this.pedido;
    }

    public void setPedido(Pedido  pedido) {
        this.pedido = pedido;
    }
    
}
