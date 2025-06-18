package Patrones.Memento;
import java.util.Map;
import java.util.HashMap;
import java.util.Date;

public class HistorialDeCajas {
    private Map<Date, CajaPasada> historial = new HashMap<>();
    private Caja caja;

    public void addCaja(Caja caja) {
        historial.put(caja.getFactura().getFecha(), caja.saveCaja());
    }

    public CajaPasada getCaja(CajaPasada cajaPasada) {
        return historial.get(cajaPasada.getCaja().getFactura().getFecha());
    }

    public void removeCaja(CajaPasada cajaPasada) {
        historial.remove(cajaPasada.getCaja().getFactura().getFecha());
    }

    public Caja restoreCaja(CajaPasada cajaPasada) {
        caja.restoreCaja(cajaPasada);
        return caja;
    }
}