package edu.estatuas.cotxox.tarifa;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.estatuas.cotxox.carrera.Carrera;

public class TarifaTest {

    @Test
    public void costeDistancia() {
        
        assertEquals(13.5, Tarifa.getCosteDistancia(10), 0.01);
        assertEquals(10.125, Tarifa.getCosteDistancia(7.5), 0.01);
    }

    @Test
    public void costeTiempo() {
        assertEquals(3.5, Tarifa.getCosteTiempo(10), 0.01);
        assertEquals(0.7, Tarifa.getCosteTiempo(2), 0.01);
    }

    @Test
    public void costeTotalTodoNulo() {
        Carrera carrera = new Carrera("4916119711304546");
        carrera.setDistancia(0);
        carrera.setTiempoEsperado(0);
        assertEquals(6.0, Tarifa.getCosteTotalEsperado(carrera), 0.01);
    }

    @Test
    public void costeTotal() {
        Carrera carrera = new Carrera("4916119711304546");
        carrera.setDistancia(10);
        carrera.setTiempoEsperado(5);

        assertEquals(18.3, Tarifa.getCosteTotalEsperado(carrera), 0.01);
    }
}
