package Logica;

public class Comida {
    private String nombre;
    private double precio;
    private String tipoComida;
    private String descripcion;

    public Comida(String nombre, double precio, String tipoComida, String descripcion) {
        this.nombre = nombre;
        this.precio = precio;
        this.tipoComida = tipoComida;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
    public String getTipoComida() {
        return tipoComida;
    }
    public String getDescripcion() {
        return descripcion;
    }
}
