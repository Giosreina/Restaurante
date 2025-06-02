package Patrones.Singleton;
import Logica.Factura;
import Patrones.MethodFactory.*;
import Logica.Plato;
import java.util.List;

public class Cajero {
    private static Cajero instancia;
    private String nombre;
    private String cedula;
    private String id;
    private double dinero;
    private Fabricas fabrica = new LlamadoFactura();

    private Cajero(String nombre, String cedula, String id, double dinero) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.id = id;
    }
    public static Cajero getInstancia(String nombre, String cedula, String id, double dinero) {
        if (instancia == null) {
            instancia = new Cajero(nombre, cedula, id, dinero);
        }
        return instancia;
    }
    public Factura generarFactura(int id, String cliente, String distribuidor, List<Plato> compras, String estado) {
        if (dinero <= 0) {
            throw new IllegalArgumentException("No hay suficiente dinero para generar la factura.");
        }else if (compras.isEmpty()) {
            throw new IllegalArgumentException("No hay compras para generar la factura.");
        }
        dinero -= fabrica.crearFactura(id, cliente, distribuidor, compras, estado).getPrecio();
        return fabrica.crearFactura(id, cliente, distribuidor, compras, estado);
    }    
    public String getNombre() {
        return nombre;
    }
    public String getCedula() {
        return cedula;
    }
    public String getId() {
        return id;
    }
    public double getDinero() {
        return dinero;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setDinero(double dinero) {
        this.dinero = dinero;
    }
}
