package Patrones.MethodFactory;
import Logica.Factura;
import Logica.Plato;
import java.util.List;

public class LlamadoFactura extends Fabricas {

    @Override
    public Factura crearFactura(int id, String cliente, String distribuidor, List<Plato> compras, String estado) {
        return new Factura(id, cliente, distribuidor, compras, estado);
    }
    
}
