package app;

import data.ZonaDeCarga;
import model.Estado;
import model.Pedido;
import model.Repartidor;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        /**
         *Para la clase Main, considera lo siguiente:
         * •	Instancia una ZonaDeCarga.
         * •	Agrega al menos 5 pedidos al sistema.
         * •	Crea e inicia 3 hilos de tipo Repartidor.
         * •	Usa ExecutorService o directamente objetos Thread.
         * •	Espera la finalización del proceso y muestra un mensaje:
         * "Todos los pedidos han sido entregados correctamente".
         */
        ZonaDeCarga z = new ZonaDeCarga();

        Pedido pedido1 = new Pedido (1,"Av. Providencia #456", Estado.PENDIENTE);
        Pedido pedido2 = new Pedido(2, "Av. Providencia #789", Estado.PENDIENTE);
        Pedido pedido3 = new Pedido(3, "Av. Ñuñoa #123", Estado.PENDIENTE);
        Pedido pedido4 = new Pedido(4, "Av. Recoleta #321", Estado.PENDIENTE);
        Pedido pedido5 = new Pedido(5, "Av. Las Condes #654", Estado.PENDIENTE);

        z.agregarPedido(pedido1);
        z.agregarPedido(pedido2);
        z.agregarPedido(pedido3);
        z.agregarPedido(pedido4);
        z.agregarPedido(pedido5);

        System.out.println();

        Thread repartidor1 = new Thread(new Repartidor("Ana", z));
        Thread repartidor2 = new Thread(new Repartidor("Juan", z));
        Thread repartidor3 = new Thread(new Repartidor("Pedro", z));

        repartidor1.start();
        repartidor2.start();
        repartidor3.start();

        repartidor1.join();
        repartidor2.join();
        repartidor3.join();

        z.finalizarPedido();
    }
}