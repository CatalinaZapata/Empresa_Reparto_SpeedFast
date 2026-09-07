package data;

import contrato.*;
import model.*;
import java.io.*;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GestorPaqueteria {
    ArrayList<Paquete> listaPaquetes = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void cargarBuffer(){
        try(Scanner lector = new Scanner(new File("src/resources/Paquete.txt"))){
            String linea = "";
            while(lector.hasNextLine()){
                linea = lector.nextLine();
                String[] datos = linea.split("\\|");
                switch (datos[0]){
                    case "Comida":
                        listaPaquetes.add(new PaqueteComida(datos[0],Integer.parseInt(datos[1]),datos[2],datos[3],Double.parseDouble(datos[4])));
                        break;
                    case "Encomienda":
                        listaPaquetes.add(new PaqueteEncomienda(datos[0],Integer.parseInt(datos[1]),datos[2],datos[3],Double.parseDouble(datos[4])));
                        break;
                    case "Express":
                        listaPaquetes.add(new PaqueteExpress(datos[0],Integer.parseInt(datos[1]),datos[2],datos[3],Double.parseDouble(datos[4])));
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("Error al cargar archivo");
        }
    }
    public String filtrarTipo(){
        String tipo = null;

        while (tipo == null){
            System.out.println("\n---ESCOJA UNA OPCION DE PAQUETERIA---");
            System.out.println("1.Comida");
            System.out.println("2.Encomienda");
            System.out.println("3.Express");

            String entrada = sc.nextLine();

            if (entrada.isEmpty()) {
                System.out.println("Debes ingresar una opcion valida.");
            } else {
                try {
                    int eleccion = Integer.parseInt(entrada);
                    if (eleccion == 1) {
                        tipo = "Comida";
                    } else if (eleccion == 2) {
                        tipo = "Encomienda";
                    } else if (eleccion == 3) {
                        tipo = "Express";
                    } else {
                        System.out.println("Debes ingresar una opcion valida.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Debes ingresar una opcion valida.");
                }
            }
        }
        return tipo;
    }
    public ArrayList<Paquete> getListaPaquetes() {
        return listaPaquetes;
    }

    //DESACOPLAMIENTO
    public void ingresarDespacho (Paquete paqueteBase){
        paqueteBase.despachar();
        try (FileWriter escribe = new FileWriter("src/resources/Paquete.txt", true);
             PrintWriter salida = new PrintWriter(escribe)) {
             salida.println(paqueteBase.guardarResumen());
        } catch (Exception e) {
            System.out.println("Error al cargar archivo");
        }
    }
    public void cancelarUltimoDespacho (Cancelable paqueteBase){
        if (!listaPaquetes.isEmpty()) {
            Paquete paquete = listaPaquetes.get(listaPaquetes.size() - 1);
            paquete.cancelar();
            listaPaquetes.remove(listaPaquetes.size() - 1);
            try {
                ArrayList<String> lineas = new ArrayList<>();
                Scanner lector = new Scanner(new File("src/resources/Paquete.txt"));
                while (lector.hasNextLine()) { lineas.add(lector.nextLine());}
                lector.close();
                if (!lineas.isEmpty()) { lineas.remove(lineas.size() - 1);}
                FileWriter escritor = new FileWriter("src/resources/Paquete.txt");
                for (String linea : lineas) {
                    escritor.write(linea + "\n");
                }
                escritor.close();
            } catch (Exception e) {
                System.out.println("Error al actualizar archivo");
            }
        }
    }
    public void realizarRastreamiento(Rastreable paqueteBase){ paqueteBase.verHistorial();}

    //METODOS DE IMPRESION
    public void imprimirDespachable(Scanner sc) {
        Paquete paqueteBase = null;
        System.out.print("REGISTRAR PAQUETE PARA DESPACHO");
        String tipo = filtrarTipo();

        System.out.println("Ingrese el ID del paquete de 4 digitos: ");
        String idTexto = sc.nextLine();
        while (!idTexto.matches("\\d{4}")) {
            System.out.println("El ID debe contener exactamente 4 digitos.");
            System.out.println("Ingrese nuevamente el ID:");
            idTexto = sc.nextLine();
        }
        int id = Integer.parseInt(idTexto);

        System.out.println("Ingrese el nombre del repartidor: ");
        String nombre = sc.nextLine();
        while (nombre.trim().isEmpty()) {
            System.out.println("El nombre no puede estar vacio.");
            System.out.println("Ingrese el nombre del repartidor:");
            //nombre = sc.nextLine();
        }
        paqueteBase.asignarRepartidor(nombre);

        System.out.println("Ingrese la direccion de entrega: ");
        String direccion = sc.nextLine();
        while (direccion.trim().isEmpty()) {
            System.out.println("La direccion no puede estar vacia.");
            System.out.println("Ingrese la direccion de entrega:");
            direccion = sc.nextLine();
        }

        System.out.println("Ingrese distancia en km: ");
        double distancia = 0;
        while (true) {
            try {
                String entrada = sc.nextLine();
                entrada = entrada.replace(",", ".");
                distancia = Double.parseDouble(entrada);
                if (distancia < 0) {
                    System.out.println("La distancia no puede ser negativa.");
                    System.out.println("Ingrese distancia en Km:");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar una distancia numerica.");
                System.out.println("Ingrese distancia en Km:");
            }
        }

        switch (tipo) {
            case "Comida":
                paqueteBase = new PaqueteComida("Comida", id, nombre, direccion, distancia);
                break;
            case "Encomienda":
                paqueteBase = new PaqueteEncomienda("Encomienda", id, nombre, direccion, distancia);
                break;
            case "Express":
                paqueteBase = new PaqueteExpress("Express", id, nombre, direccion, distancia);
                break;
            default:
                System.out.println("Tipo de paquete no valido");
                return;
        }

        listaPaquetes.add(paqueteBase);
        ingresarDespacho(paqueteBase);
        System.out.println("Paquete registrado correctamente");
    }
    public void imprimirCancelable(){
        System.out.println("CANCELAR EL ULTIMO PEDIDO");
        cancelarUltimoDespacho(listaPaquetes.get(listaPaquetes.size() - 1));
        System.out.print("------------------------------------------");
        System.out.println("");
    }
    public void imprimirRastreable(){
        System.out.print("VER HISTORIAL");
        for (Paquete paqueteBase: listaPaquetes) {
            realizarRastreamiento(paqueteBase);
        }
        System.out.println("");
        System.out.print("------------------------------------------");
        System.out.println("");
    }
    public void imprimirFiltro(){
        String tipo = filtrarTipo().toUpperCase();
        System.out.println("\n---FILTRADO: PAQUETERIA DE " + tipo + "---");
        boolean encontrado = false;
        for (Paquete p : listaPaquetes){
            if(p.getTipoEntrega().equalsIgnoreCase(tipo)){
                p.mostrarResumen();
                System.out.print("------------------------------------------");
                encontrado = true;
            }
        }
        if(!encontrado){
            System.out.println("No hay elementos");
        }
        System.out.println("");
    }
    public void imprimirAsignarRepartidor(){

        Repartidor repartidor1 = new Repartidor("Carlos");
        Repartidor repartidor2 = new Repartidor("Ana");
        Repartidor repartidor3 = new Repartidor("Pedro");

        // Asignar paquetes al repartidor 1
        repartidor1.asignarPaquetes(getListaPaquetes().get(0));
        repartidor1.asignarPaquetes(getListaPaquetes().get(1));
        repartidor1.asignarPaquetes(getListaPaquetes().get(2));

        // Asignar paquetes al repartidor 2
        repartidor2.asignarPaquetes(getListaPaquetes().get(3));
        repartidor2.asignarPaquetes(getListaPaquetes().get(4));
        repartidor2.asignarPaquetes(getListaPaquetes().get(5));

        // Asignar paquetes al repartidor 3
        repartidor3.asignarPaquetes(getListaPaquetes().get(6));
        repartidor3.asignarPaquetes(getListaPaquetes().get(7));
        repartidor3.asignarPaquetes(getListaPaquetes().get(8));

        // Crear el grupo de hilos
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Ejecutar los repartidores
        executor.submit(repartidor1);
        executor.submit(repartidor2);
        executor.submit(repartidor3);

        // No aceptar nuevas tareas
        executor.shutdown();

        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("\nTodos los repartidores terminaron sus entregas.");
    }
}