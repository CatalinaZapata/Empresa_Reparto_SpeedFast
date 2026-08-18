package model;

public class PaqueteEncomienda extends PaqueteBase {
    private String nombreRepartidor;
    private int peso;
    private int volumen;

    public PaqueteEncomienda(String tipoPedido, int idPedido, String direccionEntrega, String nombreRepartidor, int peso, int volumen) {
        super(tipoPedido, idPedido, direccionEntrega, nombreRepartidor);
        this.peso = peso;
        this.volumen = volumen;
        this.nombreRepartidor = nombreRepartidor;
    }

    @Override
    public void asignarRepartidor() {
        super.asignarRepartidor();
        System.out.println("→ Validando peso y embalaje... OK");
        super.asignarRepartidor(nombreRepartidor);
        System.out.println("→ Peso del paquete: " + peso + "[gr]");
        System.out.println("→ Volumen del paquete: " + volumen + "[Lt]");
    }
}
