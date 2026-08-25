package model;

public class PaqueteExpress extends PaqueteBase {
    protected String contactoReceptor;

    public PaqueteExpress(int idEntrega, String tipoEntrega, String direccionEntrega, double distanciaKm, String contactoReceptor) {
        super(idEntrega, tipoEntrega, direccionEntrega, distanciaKm);
        this.contactoReceptor = contactoReceptor;
    }

    public String getContactoReceptor() { return contactoReceptor;}

    @Override
    public double calcularTiempoEntrega() {
        double tiempoEntrega;
        if (distanciaKm <= 5) tiempoEntrega = 10;
        else {tiempoEntrega = 15;}
        return tiempoEntrega;
    }

    @Override
    public void mostrarResumen(){
        super.mostrarResumen();
        System.out.println("→ Contacto receptor: " + contactoReceptor);
    }
}