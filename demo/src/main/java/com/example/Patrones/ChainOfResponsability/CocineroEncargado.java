package com.example.Patrones.ChainOfResponsability;

import com.example.Logica.Alimento;
import com.example.Logica.Pedido;
import com.example.Patrones.Observer.Observer.Cocina;
import com.example.Patrones.Observer.Observer.Personal;
import com.example.Patrones.Prototype.*;
import com.example.Utilities.SalidaTerminal;
import java.util.ArrayList;

public class CocineroEncargado extends Personal implements Encargado {

    private Encargado next;
    private String condicion;
    private ArrayList<Alimento> alimentosPorPreparar = new ArrayList<>();
    private TurnoPrototype turnoCocinero;
    private Cocina cocina;
    private SalidaTerminal salida = new SalidaTerminal();

    public CocineroEncargado(String nombre, String condicion, Cocina cocina) {
        super(nombre);
        this.condicion = condicion;
        this.cocina = cocina;
        this.cocina.añadirEmpleado(this);
    }

    @Override
    public void setNext(Encargado next) {
        this.next = next;
    }

    @Override
    public void actualizar(Pedido pedido) {
        for (Alimento alimento : pedido.getPedido()) {
            if (alimento.getTipoComida().equals(condicion)) {
                alimentosPorPreparar.add(alimento);
            }
        }
        if (next != null) {
            next.actualizar(pedido);
        }
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void realizarTarea() {
        for (Alimento alimento : alimentosPorPreparar) {
            salida.imprimir(cocinarProducto(alimento));
        }
        alimentosPorPreparar.clear();
    }

    public String cocinarProducto(Alimento alimento) {
        alimento.setEstado(true);
        if (alimento.getPedido().isEstado()) {
            cocina.entregarPedido(alimento.getPedido());
        }
        return "El cocinero " + super.nombre + " esta preparando " + alimento.getNombre();
    }

    @Override
    public void asignarTurno(String turno) {
        this.turnoCocinero = new HorariosDisponibles().obtenerTurno(turno);
    }

    public ArrayList<Alimento> getAlimentosPorPreparar() {
        return alimentosPorPreparar;
    }
}
