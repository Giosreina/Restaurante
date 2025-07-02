package com.example.Patrones.Command;
import com.example.Patrones.Observer.Observer.AyudanteDeCocina;
public class AyudanteDeCocinaComando extends Comando{
    private AyudanteDeCocina ayudanteDeCocina;
    
    public AyudanteDeCocinaComando(AyudanteDeCocina ayudanteDeCocina){
        this.ayudanteDeCocina = ayudanteDeCocina;
    }

    public String preparar(){
        return ayudanteDeCocina.realizarTarea();
    }
}
