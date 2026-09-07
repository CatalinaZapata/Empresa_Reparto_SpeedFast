package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Repartidor implements Runnable {
    private String repartidor;
    private List<Paquete> paquetesAsignados;

    public Repartidor (String repartidor) {
        this.repartidor = repartidor;
        this.paquetesAsignados = new ArrayList<>();
    }

    public void asignarPaquetes(Paquete paquete) {
        paquetesAsignados.add(paquete);
    }

    @Override
    public void run() {
        for (Paquete paquete : paquetesAsignados) {
            System.out.printf("[Repartidor: %s] Entregando Pedido%s%n", repartidor, paquete.toString());
            try {
                Random random = new Random();
                int tiempo = random.nextInt(3000) + 1000;
                Thread.sleep(tiempo);
            } catch (InterruptedException e){
                Thread.currentThread().interrupt();
                System.out.printf("La entrega de %s fue interrumpida ", repartidor);
                return;
            }
            System.out.printf("[Repartidor: %s] Finalizo entrega Pedido%s%n", repartidor, paquete.toString());
        }
        System.out.printf("Repartidor %s terminó todas sus entregas%n", repartidor);
    }
}
