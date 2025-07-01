package com.example.Patrones.composite;

import com.example.Logica.Pedido;
import com.example.Patrones.Observer.Observer.Personal;
import java.util.ArrayList;

public class GrupoPersonal extends Personal{
    private ArrayList<Personal> grupoPersonal = new ArrayList<>();
    
    public GrupoPersonal(String nombre) {
        super(nombre);
    }
    
    public void agregarPersonal(Personal personal){
        grupoPersonal.add(personal);
    }
    
    @Override
    public void actualizar(Pedido pedido) {
        //
    }

    @Override
    public String preparar() {
        String respuesta = "";
        for(Personal personal : grupoPersonal){
            respuesta += personal.preparar();
        }
        return respuesta;
    }

    @Override
    public void asignarTurno(String turno) {
        for(Personal personal : grupoPersonal){
            personal.asignarTurno(turno);
        }
    }
}
