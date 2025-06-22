package com.example.Patrones.Command;
public class CocinaInvocadora {
    private Comando comando;

    public void setComando(Comando comando){
        this.comando = comando;
    }

    public String ejecutarComando(){
        return comando.preparar();
    }
}
