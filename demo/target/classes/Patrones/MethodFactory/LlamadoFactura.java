package Patrones.MethodFactory;
import Logica.Factura;
import Logica.Pedido;

public class LlamadoFactura extends Fabricas {

    @Override
    public Factura crearFactura(int id, String cliente, String distribuidor, Pedido compras) {
        return new Factura(id, cliente, distribuidor, compras);
    }
    
}
