package edu.estatuas.cotxox;

import java.util.ArrayList;
import java.util.List;

import edu.estatuas.cotxox.carrera.Carrera;
import edu.estatuas.cotxox.conductores.Conductor;
import edu.estatuas.cotxox.conductores.PoolConductores;

public class Cotxox {
    public static void main(String[] args) {
        
        String tarjetaCredito = "4916119711304546";
        String origen = "Aeroport Son Sant Joan";
        String destino = "Magaluf";
        double distancia = 7.75;
        int tiempoEspradoMinutos = 10;

        Carrera carrera = new Carrera(tarjetaCredito);
        carrera.setOrigen(origen);
        carrera.setDestino(destino);
        carrera.setDistancia(distancia);
        carrera.setTiempoEsperado(tiempoEspradoMinutos);

        //region Set pickup
        System.out.println("\n#####" + "\t Set Pickup: \t" + "#####\n");

		System.out.println("Visa: " + carrera.getTarjetaCredito());
		System.out.println("From: " + carrera.getOrigen());
		System.out.println("To: " + carrera.getDestino());
		System.out.println("Distance: " + carrera.getDistancia());


        //region Your cost
        System.out.println("\n#####" + "\t See your Cost: \t" + "#####\n");

		System.out.println("Visa: " + carrera.getTarjetaCredito());
		System.out.println("From: " + carrera.getOrigen());
		System.out.println("To: " + carrera.getDestino());
		System.out.println("Distance: " + carrera.getDistancia());
		System.out.println("Total: " + carrera.getCosteEsperado() + " Euros");

        //region Driver
        System.out.println("\n#####" + "\t Get a ride: Driver: \t" + "#####\n");

        List<Conductor> poolConductores = new ArrayList<>();
        Conductor conductor;

        String[] nombres = {"Samantha", "Fox", "Mola"};
        for (String nombre : nombres) {
            conductor = new Conductor(nombre);
            poolConductores.add(conductor);
        }

        String[] matricula = {"4ABC123", "5DHJ444", "7JKK555"};
        String[] modelos = {"Chevy Malibu", "Toyota Prius", "Mercedes A"};

        int index = 0;
        for (Conductor conductora : poolConductores) {
            conductora.setMatricula(matricula[index]);
            conductora.setModelo(modelos[index]);
            conductora.setValoracion((byte) 4);
            index++;
        }

        PoolConductores conductores = new PoolConductores(poolConductores);

        carrera.asignarConductor(conductores);

        System.out.println("Driver: " + carrera.getConductor().getNombre());
        System.out.println("Type: " + carrera.getConductor().getModelo());
        System.out.println("Matricula " + carrera.getConductor().getMatricula());
        System.out.println("Stars: " + carrera.getConductor().getValoracion());
        System.out.println("From: " + carrera.getOrigen());
        System.out.println("To: " + carrera.getDestino());

        boolean ocupado = carrera.getConductor().isOcupado();
        if (ocupado) {
            System.out.println("Esta conductora no esta disponible :c");
        } else {
            System.out.println("Disponible para ti");
        }

        //region Pay and tip
        System.out.println("\n####" + "\t Pay and Tip: \t" + "####\n");

        carrera.realizarPago(carrera.getCosteEsperado());
        carrera.recibirPropina(1);
        carrera.liberarConductor();

        System.out.println("Driver: " + carrera.getConductor().getNombre());
        System.out.println("TIP:" + carrera.getPropina());
        System.out.println("Visa: " + carrera.getTarjetaCredito());
        System.out.println("Total: " + carrera.getCosteTotal());
        System.out.println("Ocupado?: " +carrera.getConductor().isOcupado());


        //region Rate your driver
        System.out.println("\n####" + "\t Rate your Driver: \t" + "####\n");
        
        carrera.getConductor().setValoracion((byte) 5);

        System.out.println("Driver: " + carrera.getConductor().getNombre());
        System.out.println("Stars: " + carrera.getConductor().getValoracion());
    }
}
