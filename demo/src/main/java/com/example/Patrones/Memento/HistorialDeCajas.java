package com.example.Patrones.Memento;

import java.util.Map;

import java.util.HashMap;
import java.util.Date;

public class HistorialDeCajas {

    private Map<Date, CajaPasada> historial = new HashMap<>();
    private Caja cajaActual;

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
        cajaActual.restoreCaja(cajaPasada);
        return cajaActual;
    }

    public Map<Date, CajaPasada> getHistorial() {
        return historial;
    }

}
