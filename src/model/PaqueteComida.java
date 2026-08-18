package model;

public class PaqueteComida extends PaqueteBase {
    private String nombreRepartidor;
    private String restaurante;
    private int tiempoPreparacion;

    public PaqueteComida(String tipoPedido, int idPedido, String direccionEntrega, String nombreRepartidor, String restaurante, int tiempoPreparacion) {
        super(tipoPedido, idPedido, direccionEntrega, nombreRepartidor);
        this.restaurante = restaurante;
        this.tiempoPreparacion = tiempoPreparacion;
        this.nombreRepartidor = nombreRepartidor;
    }

    @Override
    public void asignarRepartidor(){
        super.asignarRepartidor();
        System.out.println("→ Verificando mochila térmica... OK");
        super.asignarRepartidor(nombreRepartidor);
        System.out.println("→ Restaurante: " + restaurante);
        System.out.println("→ Tiempo Preparacion: " + tiempoPreparacion + "[min]");
    }

}
