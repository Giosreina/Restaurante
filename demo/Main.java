package com.example;

import com.example.Patrones.Facade.*;

public class Main {
    public static void main(String[] args) {
        FacadeAbstract facadeInventarioYAlmacen = new FacadeInventarioYAlmacen();
        facadeInventarioYAlmacen.atenderCliente();
        
        FacadeAbstract facadeAtender = new FacadeAtender();
        facadeAtender.atenderCliente();
    }
}