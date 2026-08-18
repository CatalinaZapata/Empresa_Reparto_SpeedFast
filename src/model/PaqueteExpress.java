package model;

public class PaqueteExpress extends PaqueteBase {
    private String nombreRepartidor;
    private int distancia;
    private int tiempoEntregaMax;

    public PaqueteExpress(String tipoPedido, int idPedido, String direccionEntrega, String nombreRepartidor, int distancia, int tiempoEntregaMax) {
        super(tipoPedido, idPedido, direccionEntrega, nombreRepartidor);
        this.distancia = distancia;
        this.tiempoEntregaMax = tiempoEntregaMax;
        this.nombreRepartidor = nombreRepartidor;
    }

    @Override
    public void asignarRepartidor() {
        super.asignarRepartidor();
        System.out.println("→ Repartidor más cercano con disponibilidad inmediata encontrado.");
        super.asignarRepartidor(nombreRepartidor);
        System.out.println("→ Distancia de reparto: " + distancia + "[km]");
        System.out.println("→ Tiempo limite de entrega: " + tiempoEntregaMax + "[min]");
    }
}
