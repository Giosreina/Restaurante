package com.example.Patrones.Visitor;

public class Inspector implements VisitorRestaurante {
    private String mensaje;
    @Override
    public String visitar(Ingrediente ingrediente) {
        if (ingrediente.estaCaducado()) {
            mensaje = "Ingrediente caducado: " + ingrediente.getNombre() + " ❌";
        } else {
            mensaje = "Ingrediente en buen estado: " + ingrediente.getNombre() + " ✅";
        }
        return mensaje;
    }

    @Override
    public String visitar(Equipo equipo) {
        if (equipo.getHorasUso() > 1000) {
            mensaje = "Equipo " + equipo.getTipo() + " requiere mantenimiento 🔧";
        } else {
            mensaje = "Equipo " + equipo.getTipo() + " en buen estado ✅";
        }
        return mensaje;
    }
}

