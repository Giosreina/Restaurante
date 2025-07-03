package com.example;

import com.example.Patrones.Facade.FacadeAbstract;
import com.example.Patrones.Facade.FacadeAtender;
import com.example.Patrones.Facade.FacadeInventarioYAlmacen;

public class Main {
    public static void main(String[] args) {
        FacadeAbstract facadeAtender = new FacadeAtender();
        facadeAtender.atenderCliente();
        
        //FacadeAbstract facadeInventarioYAlmacen = new FacadeInventarioYAlmacen();
        //facadeInventarioYAlmacen.atenderCliente();
    }
}