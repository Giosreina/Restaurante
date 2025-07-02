package com.example.Patrones.Proxy;

import com.example.Logica.Pedido;
import com.example.Patrones.Observer.Observer.Cocina;
import com.example.Patrones.Observer.Observer.Personal;
import com.example.Patrones.Prototype.HorariosDisponibles;
import com.example.Patrones.Prototype.TurnoPrototype;

public class Mesero extends Personal{
    private TurnoPrototype turnoMesero;
    private Cocina cocina;
    private Pedido pedidoActual;

    public Mesero(String nombre, Cocina cocina) {
        super(nombre);
        this.cocina = cocina;
    }
    
    public void tomarPedido(Pedido pedido){
        this.pedidoActual = pedido;
    }
    
    @Override
    public void actualizar(Pedido pedido) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String realizarTarea() {
        if(pedidoActual != null){
            if(!cocina.getPedidos().contains(pedidoActual)){
                cocina.añadirPedidos(pedidoActual);
                pedidoActual = null;
                return "El mesero "+nombre+" a enviado el pedido a la cocina";
            }
            return "El pedido ya esta siendo preparado";
        }
        return "No hay pedido existente";
    }

    @Override
    public void asignarTurno(String turno) {
        HorariosDisponibles horariosDisponibles = new HorariosDisponibles();
        turnoMesero = horariosDisponibles.obtenerTurno(turno);
    }
}
