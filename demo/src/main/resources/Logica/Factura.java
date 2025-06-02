package Logica;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Factura {
    private int id;
    private String cliente;
    private String distribuidor;
    private List<Plato> compras = new ArrayList<>();
    private double precio;
    private Date FECHA = new Date();
    private String estado;

    public Factura(int id, String cliente, String distribuidor, List<Plato> compras, String estado) {
        this.id = id;
        this.cliente = cliente;
        this.distribuidor = distribuidor;
        this.compras = compras;
        this.estado = estado;
    }
    public void addCompra(Plato plato) {
        this.compras.add(plato);
    }
    public void removeCompra(Plato plato) {
        this.compras.remove(plato);
    }
    public double getPrecio() {
        for (Plato plato : compras) {
            precio += plato.getPrecio();
        }
        return precio;
    }
}
