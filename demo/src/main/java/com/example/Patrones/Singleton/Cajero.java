package com.example.Patrones.Singleton;
import com.example.Patrones.Singleton.Cajero;


import com.example.Logica.Pedido;
import com.example.Patrones.Memento.Caja;
import com.example.Patrones.Bridge.*;
import com.example.Patrones.Observer.Observer.*;
import com.example.Patrones.Prototype.*;


public class Cajero extends Personal {
    private static Cajero instancia;
    private String cedula;
    private String id;
    private Caja caja = new Caja();
    private Pago pago;
    private Pedido compras;
    private TurnoPrototype turnoCajero;

    private Cajero(String nombre, String cedula, String id, Caja caja) {
        super(nombre);
        this.cedula = cedula;
        this.id = id;
        this.caja = caja;
    }
    public static Cajero getInstancia(String nombre, String cedula, String id, Caja caja) {
        if (instancia == null) {
            instancia = new Cajero(nombre, cedula, id, caja);
        }
        return instancia;
    }
    public void cobrarFactura(int id, String cliente, String distribuidor, Pedido compras, MetodoDePago metodoDePago) {
        pago = new Pago(metodoDePago);
        pago.procesarPago(id, cliente, distribuidor, compras);
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
    public void actualizar(Pedido pedido){
        this.compras = pedido;
    }
    public String realizarTarea(){
        return "cobrando";
    }
    public void asignarTurno(String turno){
        this.turnoCajero = new HorariosDisponibles().obtenerTurno(turno);
    }
}
