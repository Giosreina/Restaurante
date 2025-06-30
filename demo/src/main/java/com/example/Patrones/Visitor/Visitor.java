package com.example.Patrones.Visitor;

import com.example.Logica.Pedido;
import com.example.Patrones.Memento.*;

public interface Visitor {
    CajaPasada visitarCaja(Caja caja);
    double visitarPedido(Pedido pedido);
} 
    
