package edu.estatuas.cotxox.conductores;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ConductorTest {
    private Conductor conductor;

    @Before
    public void setUp() {
        conductor = new Conductor("Juan");
    }

    @Test
    public void testNombre() {
        assertEquals("Juan", conductor.getNombre());
    }

    @Test
    public void testModelo() {
        conductor.setModelo("Chevy Malibu");
        assertEquals("Chevy Malibu", conductor.getModelo());
    }

    @Test
    public void testMatricula() {
        conductor.setMatricula("4ABC123");
        assertEquals("4ABC123", conductor.getMatricula());
    }

    @Test
    public void testValoracion() {
        conductor.setValoracion((byte) 0);
        assertEquals((byte) 0, conductor.getValoracion(), 0.01);
    }

    @Test
    public void testValoracionMedia() {
        conductor.setValoracion((byte) 0);
        conductor.setValoracion((byte) 5);
        conductor.setValoracion((byte) 10);

        assertEquals(5, conductor.getValoracion(), 0.01);
    }

    @Test
    public void testValoracionMediaRandom() {
        conductor.setValoracion((byte) 3);
        conductor.setValoracion((byte) 9);
        conductor.setValoracion((byte) 2);

        assertEquals(4.66, conductor.getValoracion(), 0.01);
    }
}
