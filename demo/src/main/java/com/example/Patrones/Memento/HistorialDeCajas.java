package com.example.Patrones.Memento;
import java.util.Map;

import java.util.HashMap;
import java.util.Date;
import com.example.Patrones.Visitor.*;

public class HistorialDeCajas {
    private Map<Date, CajaPasada> historial = new HashMap<>();
    private Visitor visitor = new VisitorImpresion();
    private Caja caja;

    public void addCaja(Caja caja) {
        historial.put(caja.getFactura().getFecha(), visitor.visitarCaja(caja));
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