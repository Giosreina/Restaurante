package com.example.Utilities;

import java.util.Scanner;

public class IOTerminal {
    private Scanner sc = new Scanner(System.in);
    
    public static void imprimir(String mensaje) {
        System.out.println(mensaje);
    }
    
    public String recibir(){
        return sc.nextLine();
    }
}
