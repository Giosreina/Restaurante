package com.example;

import com.example.Patrones.Facade.FacadeAbstract;
import com.example.Patrones.Facade.FacadeAtender;

public class Main {
    public static void main(String[] args) {
        FacadeAbstract facadeAtender = new FacadeAtender();
        facadeAtender.atenderCliente();
    }
}