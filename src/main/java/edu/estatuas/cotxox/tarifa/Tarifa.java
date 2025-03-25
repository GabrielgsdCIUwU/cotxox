package edu.estatuas.cotxox.tarifa;

import edu.estatuas.cotxox.carrera.Carrera;

public class Tarifa {
    
    final static double COSTE_MILLA = 1.35;
    final static double COSTE_MINUTO = 0.35;
    final static double COSTE_MINIMO = 5.0;
    final static byte PORCENTAJE_COMISION = 20;

    public static double getCosteDistancia(double distancia) {
        return COSTE_MILLA * distancia;
    }

    public static double getCosteTiempo(int minutos) {
        return COSTE_MINUTO * minutos;
    }

    public static double getCosteTotalEsperado(Carrera carrera) {
        double costeDistancia = getCosteDistancia(carrera.getDistancia());
        double costeTiempo = getCosteTiempo(carrera.getTiempoEsperado());
        double costeSinComision = Math.max((costeDistancia + costeTiempo), COSTE_MINIMO);
        
        return costeSinComision * ((100 + PORCENTAJE_COMISION)/ (double) 100);
    }
}
