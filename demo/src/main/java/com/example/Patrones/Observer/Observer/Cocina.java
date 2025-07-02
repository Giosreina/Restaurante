package com.example.Patrones.Observer.Observer;
import java.util.ArrayList;
import com.example.Logica.Pedido;

public class Cocina{
    private ArrayList<Personal> empleados = new ArrayList<>();
    private ArrayList<Pedido> pedidos = new ArrayList<>();

    public void añadirEmpleado(Personal empleado){
        empleados.add(empleado);
    }
    public void añadirPedidos(Pedido pedido){
        pedidos.add(pedido);
        notificar();
    }
    public void notificar(){
        for(Personal personal : empleados){
            personal.actualizar(pedidos.get(pedidos.size()-1));
        }
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }
}    
