package com.example.Patrones.State;

public class EstadoAbierto implements EstadoRestaurante {
    public String manejar() {
        return "El restaurante está abierto. Se atienden clientes.";
    }
}