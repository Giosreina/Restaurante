package com.example.Patrones.Observer;
import com.example.Logica.Alimento;
import com.example.Logica.Pedido;
import com.example.Patrones.Prototype.HorariosDisponibles;
import com.example.Patrones.Prototype.*;
import com.example.Utilities.IOTerminal;
import java.util.ArrayList;

public class AyudanteDeCocina extends Personal {
    
    private String condicion;
    private ArrayList<Alimento> alimentosPorPreparar = new ArrayList<>();
    private TurnoPrototype turnoCocinero;
    private Cocina cocina;
    private IOTerminal salida = new IOTerminal();

    public AyudanteDeCocina(String nombre, String condicion, Cocina cocina) {
        super(nombre);
        this.condicion = condicion;
        this.cocina = cocina;
        this.cocina.añadirEmpleado(this);
    }

    @Override
    public void actualizar(Pedido pedido) {
        for (Alimento alimento : pedido.getPedido()) {
            if (alimento.getTipoComida().equals(condicion)) {
                alimentosPorPreparar.add(alimento);
            }
        }
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void realizarTarea() {
        for (Alimento alimento : alimentosPorPreparar) {
            alimento.setEstado(true);
            salida.imprimir("El ayudante de cocina " + super.nombre + " esta preparando " + alimento.getNombre());
            if (alimento.getPedido().isEstado()) {
                cocina.entregarPedido(alimento.getPedido());
            }
        }
        alimentosPorPreparar.clear();
    }

    @Override
    public void asignarTurno(String turno) {
        this.turnoCocinero = new HorariosDisponibles().obtenerTurno(turno);
    }

    public ArrayList<Alimento> getAlimentosPorPreparar() {
        return alimentosPorPreparar;
    }
}
