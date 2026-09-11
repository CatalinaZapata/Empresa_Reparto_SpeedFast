package data;

import model.*;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

public class ZonaDeCarga {
    /**
     Internamente almacena los pedidos pendientes usando:
     o	BlockingQueue<Pedido> o
     o	List<Pedido> protegida con synchronized o Semaphore.
     Implementa los siguientes métodos:
     o	public synchronized void agregarPedido(Pedido p)
     o	public synchronized Pedido retirarPedido()
     Controla correctamente la concurrencia para evitar el retiro doble de un mismo pedido.
     */

    private final PriorityBlockingQueue<Pedido> colaPedidos;
    private final ReentrantLock lock;

    public ZonaDeCarga() {
        colaPedidos = new PriorityBlockingQueue<>();
        lock = new ReentrantLock();
    }

    public void agregarPedido(Pedido pedido) {
        lock.lock();
        try{
            colaPedidos.put(pedido);
            System.out.println(pedido);
        } finally {
            lock.unlock();
        }
    }

    public Pedido retirarPedido(){
        lock.lock();
        try{
            return colaPedidos.poll();
        } finally {
            lock.unlock();
        }
    }

    public int cantidadPedidos() {
        return colaPedidos.size();
    }

    public void finalizarPedido(){
        System.out.println("\n[Zona de carga vacia]");
    }
}
