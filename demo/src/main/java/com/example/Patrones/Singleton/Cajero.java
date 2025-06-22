package com.example.Patrones.Singleton;
import com.example.Patrones.MethodFactory.*;
import com.example.Patrones.Singleton.Cajero;

import com.example.Logica.Factura;
import com.example.Logica.Pedido;

import com.example.Patrones.Memento.Caja;
import com.example.Patrones.Memento.HistorialDeCajas;

public class Cajero {
    private static Cajero instancia;
    private String nombre;
    private String cedula;
    private String id;
    private Fabricas fabrica = new LlamadoFactura();
    private Caja caja = new Caja();
    private HistorialDeCajas historial;

    private Cajero(String nombre, String cedula, String id, HistorialDeCajas historial) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.id = id;
        this.historial = historial;
    }
    public static Cajero getInstancia(String nombre, String cedula, String id, HistorialDeCajas historial) {
        if (instancia == null) {
            instancia = new Cajero(nombre, cedula, id, historial);
        }
        return instancia;
    }
    public double cobrarFactura(int id, String cliente, String distribuidor, Pedido compras) {
        caja.setFactura(fabrica.crearFactura(id, cliente, distribuidor, compras));
        caja.pagarFactura();
        historial.addCaja(caja);
        return caja.getDinero();
    }
    public String getNombre() {
        return nombre;
    }
    public String getCedula() {
        return cedula;
    }
    public String getId() {
        return id;
    }
    public double getDinero() {
        return caja.getDinero();
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public void setId(String id) {
        this.id = id;
    }
}
