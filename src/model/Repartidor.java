package model;

import data.ZonaDeCarga;

public class Repartidor implements Runnable{
        /**
     La clase Repartidor debe contar con los siguientes atributos:
     •	nombre (String)
     •	zonaDeCarga (referencia a la instancia compartida)
     Al definir la lógica a ejecutar en el hilo (run()), considera lo siguiente:
     •	Retira un pedido.
     •	Cambia el estado a EN_REPARTO y muestra un mensaje.
     •	Simula la entrega con Thread.sleep().
     •	Cambia el estado a ENTREGADO y muestra un mensaje final.
     */
    private String nombreRepartidor;
    private ZonaDeCarga carga;

    public Repartidor(String nombreRepartidor, ZonaDeCarga carga) {
        this.nombreRepartidor = nombreRepartidor;
        this.carga = carga;
    }

    @Override
     public void run() {
        while (carga.cantidadPedidos() > 0){
            Pedido pedido = carga.retirarPedido();
            if (pedido != null){
                System.out.println("[Repartidor - " + nombreRepartidor + "] Retirando pedido #" + pedido.getIdPedido());
                pedido.setEstado(Estado.EN_REPARTO);
                System.out.println("[Repartidor - " + nombreRepartidor + "] Estado: " + pedido.getEstado());
                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Logistica interrumpida...");
                }
                System.out.println("[Repartidor - " + nombreRepartidor + "] Entregando pedido #" + pedido.getIdPedido());
                pedido.setEstado(Estado.ENTREGADO);
                System.out.println("[Repartidor - " + nombreRepartidor + "] Estado: " + pedido.getEstado());
            }
        }
     }
}
