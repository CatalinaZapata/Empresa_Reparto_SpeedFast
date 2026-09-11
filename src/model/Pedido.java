package model;

public class Pedido implements Comparable<Pedido>{
    protected int idPedido;
    protected String direccionEntrega;
    protected Estado estado;

    public Pedido(int idPedido, String direccionEntrega, Estado estado) {
        this.idPedido = idPedido;
        this.direccionEntrega = direccionEntrega;
        this.estado = estado;
    }

    public int getIdPedido() { return idPedido;}
    public void setIdPedido(int idPedido) { this.idPedido = idPedido;}
    public String getDireccionEntrega() { return direccionEntrega;}
    public void setDireccionEntrega(String direccionEntrega) { this.direccionEntrega = direccionEntrega;}
    public Estado getEstado() { return estado;}
    public void setEstado(Estado estado) { this.estado = estado;}

    public void setEstado(String nuevoEstado){
        this.estado = Estado.valueOf(nuevoEstado);
    }

    @Override
    public String toString() {
        return "Pedido #" + idPedido + " agregado. Destino: " + direccionEntrega;
    }

    @Override
    public int compareTo(Pedido pedido) {
        return Integer.compare(this.idPedido, pedido.idPedido);
    }
}
