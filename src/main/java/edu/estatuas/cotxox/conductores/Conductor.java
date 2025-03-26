package edu.estatuas.cotxox.conductores;

import java.util.ArrayList;

public class Conductor {
    
    private String nombre;
    private String modelo;
    private String matricula;
    private double valoracionMedia;
    private boolean ocupado;
    private ArrayList<Byte> valoraciones = new ArrayList<>();

    public Conductor(String nombre) {
        this.nombre = nombre;
    }

    //region Getters and setter
    public String getNombre() {
        return nombre;
    }
    
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public double getValoracion() {
        return valoracionMedia;
    }

    public void setValoracion(byte valoracion) {
        valoraciones.add(valoracion);
        actualizarValoracionMedia();
    }

    private void setValoracionMedia(double valoracion) {
        this.valoracionMedia = valoracion;
    }

    private void actualizarValoracionMedia() {
        int totalPuntuacion = valoraciones.stream()
                                            .mapToInt(Byte::intValue)
                                            .sum();
        int numeroValoraciones = valoraciones.size();

        setValoracionMedia((double) totalPuntuacion / numeroValoraciones);
    }

}
