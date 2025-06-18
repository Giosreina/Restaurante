package Patrones.Flyweight;
import Logica.Comida;
import Logica.Pedido;

public class Combo {
    private Pedido comidas;
    private double precio;
    private CreadorCombo creador;
    private double descuento;

    public void añadirComida(String nombre, double precio, String
        tipoComida, String descripcion){
        comidas.addComida(creador.crearComida(nombre, precio, tipoComida,descripcion));
    }
    public double getPrecio(){
        return comidas.getPrecio() * descuento;
    }
    public void eliminarComida(Comida comida){
        comidas.removeComida(comida);
    }
}
