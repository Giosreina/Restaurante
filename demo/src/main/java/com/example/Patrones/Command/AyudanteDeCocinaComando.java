package com.example.Patrones.Command;
import com.example.Patrones.Observer.Observer.AyudanteDeCocina;
public class AyudanteDeCocinaComando extends Comando{
    private AyudanteDeCocina ayudanteDeCocina;
    
    public AyudanteDeCocinaComando(AyudanteDeCocina ayudanteDeCocina){
        this.ayudanteDeCocina = ayudanteDeCocina;
    }

    public void preparar(){
        ayudanteDeCocina.realizarTarea();
    }
}
