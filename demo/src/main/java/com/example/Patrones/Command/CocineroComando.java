package com.example.Patrones.Command;
import com.example.Patrones.Observer.Cocinero;
public class CocineroComando extends Comando{
    private Cocinero cocinero;

    public CocineroComando(Cocinero cocinero){
        this.cocinero = cocinero;
    }

    @Override
    public void preparar(){
        cocinero.realizarTarea();
    }
}
