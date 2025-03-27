package edu.estatuas.cotxox.carrera;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import edu.estatuas.cotxox.conductores.Conductor;
import edu.estatuas.cotxox.conductores.PoolConductores;

public class CarreraTest {
    
    private Carrera carrera;

    @Before
    public void setUp() {
        carrera = new Carrera("1234567890123456");
    }

    @Test
    public void testGetTarjetaCredito() {
        assertEquals("1234567890123456", carrera.getTarjetaCredito());
    }

    @Test
    public void testSetGetOrigen() {
        String origen = "Baiona, Bayona, Pontevedra";
        carrera.setOrigen(origen);

        assertEquals(origen, carrera.getOrigen());
    }

    @Test
    public void testSetGetDestino() {
        String destino = "Bayona, Francia";
        carrera.setDestino(destino);

        assertEquals(destino, carrera.getDestino());
    }

    @Test
    public void testSetGetDistancia() {
        double distancia = 828.54;
        carrera.setDistancia(distancia);

        assertEquals(distancia, carrera.getDistancia(), 0.01);
    }

    @Test
    public void testSetGetTiempoEsperado() {
        int tiempoEsperado = 500;
        carrera.setTiempoEsperado(tiempoEsperado);

        assertEquals(tiempoEsperado, carrera.getTiempoEsperado());
    }

    @Test
    public void testSetGetTiempoCarrera() {
        int tiempoCarrera = 487;
        carrera.setTiempoCarrera(tiempoCarrera);

        assertEquals(tiempoCarrera, carrera.getTiempoCarrera());
    }

    @Test
    public void testSetGetCosteTotal() {
        double costeTotal = 1499.99;
        carrera.setCosteTotal(costeTotal);

        assertEquals(costeTotal, carrera.getCosteTotal(), 0.01);
    }

    @Test
    public void testSetGetPropina() {
        int propina = 100;
        carrera.setPropina(propina);

        assertEquals(propina, carrera.getPropina());
    }

   @Test
   public void testCosteEsperado() {
        carrera.setDistancia((double) 200.5);
        carrera.setTiempoEsperado( 28);

        assertEquals(336.57, carrera.getCosteEsperado(), 0.01);
   }

   @Test
   public void testAsignarConductor() {
        List<Conductor> conductores = new ArrayList<>();
        Conductor conductor;
        String[] nombres = { "Samantha" };
        for (String nombre : nombres) {
            conductor = new Conductor(nombre);
            conductores.add(conductor);
        }
        PoolConductores poolConductores = new PoolConductores(conductores);
        carrera.asignarConductor(poolConductores);

        assertEquals("Samantha", carrera.getConductor().getNombre());
        assertTrue(carrera.getConductor().isOcupado());
   }
}
