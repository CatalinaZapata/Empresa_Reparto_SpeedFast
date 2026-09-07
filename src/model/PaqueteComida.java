package model;

public class PaqueteComida extends Paquete {
    public PaqueteComida(String tipoEntrega, int idEntrega, String repartidor, String direccionEntrega, double distanciaKm) {
        super(tipoEntrega, idEntrega, repartidor, direccionEntrega, distanciaKm);
    }

    @Override
    public double calcularTiempoEntrega() {
        double tiempoEntrega;
        tiempoEntrega = Math.round(15 + (2 * distanciaKm));
        return tiempoEntrega;
    }

    @Override
    public void asignarRepartidor() {
        System.out.println("Asignando repartidor asociado al restaurante...");
        System.out.println("→ Repartidor asignado: " + repartidor);
    }

    @Override
    public void asignarRepartidor(String nombre) {
        System.out.println("Asignando repartidor asociado al restaurante...");
        System.out.println("→ Repartidor asignado: " + nombre);
    }

    @Override
    public void mostrarResumen(){
        super.mostrarResumen();
    }

    @Override
    public String guardarResumen(){
        return super.guardarResumen();
    }
}