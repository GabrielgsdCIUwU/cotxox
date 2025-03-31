package edu.estatuas.cotxox.conductores;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class PoolConductoresTest {

    private PoolConductores poolConductores;

    private List<Conductor> getListConductores() {
        List<Conductor> conductores = new ArrayList<>();
        Conductor conductor;
        String[] nombres = { "Samantha", "Fox", "Mola" };
        for (String nombre : nombres) {
            conductor = new Conductor(nombre);
            conductores.add(conductor);
        }

        return conductores;
    }

    @Before
    public void setUp() {
        poolConductores = new PoolConductores(getListConductores());
    }

    @Test
    public void testGetConductores() {
        List<Conductor> conductores = poolConductores.getPoolConductores();

        assertEquals(getListConductores().size(), conductores.size());
    }

    @Test
    public void testAsignarConductor() {
        Conductor conductorAsignado = poolConductores.asignarConductor();

        assertTrue(poolConductores.getPoolConductores().contains(conductorAsignado));
    }
}
