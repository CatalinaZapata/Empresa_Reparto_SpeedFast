package model;

public abstract class PaqueteBase {
    protected int idEntrega;
    protected String tipoEntrega;
    protected String direccionEntrega;
    protected double distanciaKm;

    public PaqueteBase(int idEntrega, String tipoEntrega, String direccionEntrega, double distanciaKm) {
        this.idEntrega = idEntrega;
        this.tipoEntrega = tipoEntrega;
        this.direccionEntrega = direccionEntrega;
        this.distanciaKm = distanciaKm;
    }

    public String getTipoEntrega() { return tipoEntrega;}

    public abstract double calcularTiempoEntrega();//implementado de forma distinta en cada subclase.

    public void mostrarResumen(){
        System.out.println("\nPedido tipo " + tipoEntrega + " #" + idEntrega);
        System.out.println("→ Direccion: " + direccionEntrega);
        System.out.println("→ Distancia: " + distanciaKm + "[km]");
        System.out.printf("→ Tiempo estimado de entrega: %.0f minutos%n", calcularTiempoEntrega(), " [min]");
    }
}
