package model;

public class PaqueteEncomienda extends PaqueteBase {
    public PaqueteEncomienda(String tipoEntrega, int idEntrega, String repartidor, String direccionEntrega, double distanciaKm) {
        super(tipoEntrega, idEntrega, repartidor, direccionEntrega, distanciaKm);
    }

    @Override
    public double calcularTiempoEntrega() {
        double tiempoEntrega;
        tiempoEntrega = Math.round(20 + (1.5 * distanciaKm));
        return tiempoEntrega;
    }

    @Override
    public void asignarRepartidor() {
        System.out.println("Asignando repartidor con equipo adecuado...");
        System.out.println("→ Repartidor asignado: " + repartidor);
    }

    @Override
    public void mostrarResumen() {
        super.mostrarResumen();
    }

    @Override
    public String guardarResumen(){
        return super.guardarResumen();
    }
}