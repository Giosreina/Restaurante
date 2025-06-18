package Patrones.MethodFactory;
import Logica.Factura;
import Logica.Pedido;

public abstract class Fabricas {
    public abstract Factura crearFactura(int id, String cliente, String distribuidor, Pedido compras);
}