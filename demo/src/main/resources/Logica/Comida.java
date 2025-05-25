package Logica;

public class Comida {
    private String nombre;
    private double precio;
    private String tipoComida;
    private String descripcion;
    private String[] ingredientes;

    Comida(String nombre, double precio, String tipoComida, String descripcion, String[] ingredientes) {
        this.nombre = nombre;
        this.precio = precio;
        this.tipoComida = tipoComida;
        this.descripcion = descripcion;
        this.ingredientes = ingredientes;
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
    public String[] getIngredientes() {
        return ingredientes;
    }

}
