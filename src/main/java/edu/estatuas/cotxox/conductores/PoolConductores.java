package edu.estatuas.cotxox.conductores;

import java.util.List;
import java.util.Random;

public class PoolConductores {
    private List<Conductor> conductores;
    private Random generadorRandom;

    public PoolConductores(List<Conductor> conductores) {
        this.conductores = conductores;
        this.generadorRandom = new Random();
    }

    public List<Conductor> getPoolConductores() {
        return conductores;
    }

    public Conductor asignarConductor() {
        List<Conductor> conductoresDisponibles = getPoolConductores().stream()
                .filter(c -> !c.isOcupado())
                .toList();
        int index = generadorRandom.nextInt(conductoresDisponibles.size());
        return getPoolConductores().get(index);
    }
}
