package model;

public class PaqueteBase {//Clase padre
    private String tipoPedido;
    private int idPedido;
    private String direccionEntrega;
    private String nombreRepartidor;

    public PaqueteBase(String tipoPedido, int idPedido, String direccionEntrega, String nombreRepartidor) {
        this.tipoPedido = tipoPedido;
        this.idPedido = idPedido;
        this.direccionEntrega = direccionEntrega;
        this.nombreRepartidor = nombreRepartidor;
    }

    public String getTipoPedido() { return tipoPedido;}
    public int getIdPedido() { return idPedido;}
    public String getDireccionEntrega() { return direccionEntrega;}
    public String getNombreRepartidor() { return nombreRepartidor;}

    public void asignarRepartidor(){
        System.out.println("\n[Pedido tipo " + tipoPedido + "]");
        System.out.println("Asignando repartidor...");
        System.out.println("→ Id del pedido: " + idPedido);
        System.out.println("→ Dirección de entrega: " + direccionEntrega);
    }

    public void asignarRepartidor(String nombreRepartidor){
        System.out.println("→ Pedido asignado a " + nombreRepartidor);
    }
}
