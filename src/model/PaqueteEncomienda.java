package model;

public class PaqueteEncomienda extends PaqueteBase {
    protected int peso;

    public PaqueteEncomienda(int idEntrega, String tipoEntrega, String direccionEntrega, double distanciaKm, int peso) {
        super(idEntrega, tipoEntrega, direccionEntrega, distanciaKm);
        this.peso = peso;
    }

    public int getPeso() {
        return peso;
    }

    @Override
    public double calcularTiempoEntrega() {
        double tiempoEntrega;
        tiempoEntrega = Math.round(20 + (1.5 * distanciaKm));
        return tiempoEntrega;
    }

    @Override
    public void mostrarResumen() {
        super.mostrarResumen();
        System.out.println("→ Peso: " + peso + " [gr]");
    }
}