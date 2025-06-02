package Patrones.MethodFactory;

import java.util.List;
import Logica.Factura;
import Logica.Plato;

public abstract class Fabricas {
    public abstract Factura crearFactura(int id, String cliente, String distribuidor, List<Plato> compras, String estado);
}