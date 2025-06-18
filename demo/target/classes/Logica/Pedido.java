package Logica;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<Comida> comida = new ArrayList<>(); 
    private String nombre;
    private double precio;
    private String descripcion;

    public Pedido(String nombre, double precio, String descripcion) {
        this.nombre = nombre;
    }
    public void addComida(Comida comida) {
        this.comida.add(comida);
    }
    public void removeComida(Comida comida) {
        this.comida.remove(comida);
    }
    public String getDescripcion() {
        descripcion = "Plato: " + nombre + "\n";
        for (Comida comida : comida) {
            descripcion += comida.getNombre() + comida.getDescripcion() + "\n";
        }
        return descripcion;
    }
    public double getPrecio() {
        precio = 0;
        for (Comida comida : comida) {
            precio += comida.getPrecio();
        }
        return precio;
    }
}
