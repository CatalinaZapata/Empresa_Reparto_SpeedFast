package model;

public class PaqueteExpress extends PaqueteBase {
    public PaqueteExpress(String tipoEntrega, int idEntrega, String repartidor, String direccionEntrega, double distanciaKm) {
        super(tipoEntrega, idEntrega, repartidor, direccionEntrega, distanciaKm);
    }

    @Override
    public double calcularTiempoEntrega() {
        double tiempoEntrega;
        if (distanciaKm <= 5) tiempoEntrega = 10;
        else {tiempoEntrega = 15;}
        return tiempoEntrega;
    }

    @Override
    public void asignarRepartidor() {
        System.out.println("Asignando repartidor mas cercano...");
        System.out.println("→ Repartidor asignado: " + repartidor);
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