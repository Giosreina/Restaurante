package com.example.Patrones.Singleton;

import com.example.Patrones.Observer.Cocina;
import com.example.Patrones.Observer.Personal;
import com.example.Patrones.Singleton.Cajero;

import com.example.Logica.Pedido;
import com.example.Patrones.Memento.Caja;
import com.example.Patrones.Bridge.*;
import com.example.Patrones.Prototype.*;

public class Cajero extends Personal {

    private static Cajero instancia;
    private String cedula;
    private Caja caja = new Caja();
    private Pago pago;
    private Pedido compras;
    private TurnoPrototype turnoCajero;
    private Cocina cocina;

    private Cajero(String nombre, Caja caja, Cocina cocina) {
        super(nombre);
        this.cedula = cedula;
        this.caja = caja;
        this.cocina = cocina;
        cocina.setCajero(this);
    }

    public static Cajero getInstancia(String nombre, Caja caja, Cocina cocina) {
        if (instancia == null) {
            instancia = new Cajero(nombre, caja, cocina);
        }
        return instancia;
    }

    public void cobrarFactura(String cliente, Pedido compras, MetodoDePago metodoDePago) {
        pago = new Pago(metodoDePago);
        pago.procesarPago(cliente, compras);
    }

    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
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

    public void actualizar(Pedido pedido) {
        this.compras = pedido;
    }

    public void realizarTarea() {
    }

    public void asignarTurno(String turno) {
        this.turnoCajero = new HorariosDisponibles().obtenerTurno(turno);
    }
}
