package model;

public class PaqueteComida extends PaqueteBase {
    protected String restaurante;

    public PaqueteComida(int idEntrega, String tipoEntrega, String direccionEntrega, double distanciaKm, String restaurante) {
        super(idEntrega, tipoEntrega, direccionEntrega, distanciaKm);
        this.restaurante = restaurante;
    }

    public String getRestaurante() { return restaurante;}

    @Override
    public double calcularTiempoEntrega() {
        double tiempoEntrega;
        tiempoEntrega = Math.round(15 + (2 * distanciaKm));
        return tiempoEntrega;
    }

    @Override
    public void mostrarResumen(){
        super.mostrarResumen();
        System.out.println("→ Restaurante: " + restaurante);
    }
}