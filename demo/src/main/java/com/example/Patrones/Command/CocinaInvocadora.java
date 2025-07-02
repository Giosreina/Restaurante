package com.example.Patrones.Command;
public class CocinaInvocadora {
    private Comando comando;

    public void setComando(Comando comando){
        this.comando = comando;
    }

    public void ejecutarComando(){
        comando.preparar();
    }
}
