package edu.estatuas.cotxox.carrera;

import edu.estatuas.cotxox.conductores.Conductor;
import edu.estatuas.cotxox.conductores.PoolConductores;
import edu.estatuas.cotxox.tarifa.Tarifa;

public class Carrera {
    
    private String tarjetaCredito;
    private String origen;
    private String destino;
    private double distancia;
    private int tiempoEsperado;
    private int tiempoCarrera;
    private double costeTotal;
    private int propina = 0;
    private Conductor conductor;

    public Carrera(String tarjetaCredito) {
        this.tarjetaCredito = tarjetaCredito;
    }

    //region Getters and setter
    public String getTarjetaCredito() {
        return tarjetaCredito;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getOrigen() {
        return origen;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getDestino() {
        return destino;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setTiempoEsperado(int tiempoEsperado) {
        this.tiempoEsperado = tiempoEsperado;
    }

    public int getTiempoEsperado() {
        return tiempoEsperado;
    }

    public void setTiempoCarrera(int tiempoCarrera) {
        this.tiempoCarrera = tiempoCarrera;
    }

    public int getTiempoCarrera() {
        return tiempoCarrera;
    }

    public void setCosteTotal(double costeTotal) {
        this.costeTotal = costeTotal;
    }

    public double getCosteTotal() {
        return costeTotal;
    }

    public void realizarPago(double pago) {
        this.costeTotal = pago;
    }

    public void recibirPropina(int propina) {
        this.propina += propina;
    }

    public int getPropina() {
        return propina;
    }

    public double getCosteEsperado() {
        return Tarifa.getCosteTotalEsperado(this);
    }

    //region Conductor methods 
    public void asignarConductor(PoolConductores conductores) {
        this.conductor =  conductores.asignarConductor();
        conductor.setOcupado(true);
    }

    public Conductor getConductor() {
        return conductor;
    }

    public void liberarConductor() {
        conductor.setOcupado(false);
    }

}
