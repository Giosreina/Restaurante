package com.example.Patrones.Prototype;

import java.util.HashMap;
import java.util.Map;

public class HorariosDisponibles {
    private Map<String, TurnoPrototype> prototipos = new HashMap<>();

    public HorariosDisponibles() {
        prototipos.put("mañana", new Turno("Mañana", "07:00", "13:00", true, "Camisa blanca"));
        prototipos.put("tarde", new Turno("Tarde", "13:00", "19:00", true, "Camisa negra"));
        prototipos.put("finSemana", new Turno("Fin de semana", "10:00", "22:00", false, "Uniforme especial"));
    }

    public TurnoPrototype obtenerTurno(String tipo) {
        TurnoPrototype prototipo = prototipos.get(tipo);
        return (prototipo != null) ? prototipo.clonar() : null;
    }
}
