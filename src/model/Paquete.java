package model;

import contrato.*;

public abstract class Paquete implements Despachable, Cancelable, Rastreable {
    protected String tipoEntrega;
    protected int idEntrega;
    protected String repartidor;
    protected String direccionEntrega;
    protected double distanciaKm;

    public Paquete(String tipoEntrega, int idEntrega, String repartidor, String direccionEntrega, double distanciaKm) {
        this.tipoEntrega = tipoEntrega;
        this.idEntrega = idEntrega;
        this.repartidor = repartidor;
        this.direccionEntrega = direccionEntrega;
        this.distanciaKm = distanciaKm;
    }

    public String getTipoEntrega() { return tipoEntrega;}
    public abstract double calcularTiempoEntrega();
    public abstract void asignarRepartidor();
    public void asignarRepartidor(String nombre) {
        this.repartidor = nombre;
    }
    public void mostrarResumen(){
        System.out.println("\nPedido tipo " + tipoEntrega + " #" + idEntrega);
        asignarRepartidor();
        System.out.println("→ Direccion: " + direccionEntrega);
        System.out.println("→ Distancia: " + distanciaKm + "[km]");
        System.out.printf("→ Tiempo estimado de entrega: %.0f [min]%n", calcularTiempoEntrega());
    }
    public String guardarResumen(){
        return tipoEntrega + "|" + idEntrega + "|" + repartidor + "|" + direccionEntrega + "|" + distanciaKm;
    }

    @Override
    public void despachar() {
        mostrarResumen();
        System.out.println("Pedido despachado...");
    }
    @Override
    public void cancelar() {
        System.out.println("Cancelando pedido " +  tipoEntrega + " #" + idEntrega);
        System.out.println("Pedido cancelado exitosamente");
    }
    @Override
    public void verHistorial(){
        System.out.print("\nPedido tipo " + tipoEntrega + " #" + idEntrega + " - Entregado por " + repartidor);
    }

    @Override
    public String toString() {
        return tipoEntrega + " #" + idEntrega;
    }
}
