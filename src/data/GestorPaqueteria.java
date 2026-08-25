package data;

import model.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class GestorPaqueteria {
    ArrayList<PaqueteBase> listaPaquetes = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public void cargarArchivo(){
        try(Scanner lector = new Scanner(new File("src/resources/Paquete.txt"))){
            String linea;
            while(lector.hasNextLine() && (linea = lector.nextLine()) != null){
                String[] datos = linea.split("\\|");
                PaqueteBase paquete = null;

                //polimorfismo
                if (datos[1].equals("Comida")){
                    paquete = new PaqueteComida(Integer.parseInt(datos[0]),datos[1],datos[2],Double.parseDouble(datos[3]),datos[4]);
                } else if (datos[1].equals("Encomienda")) {
                    paquete = new PaqueteEncomienda(Integer.parseInt(datos[0]),datos[1],datos[2],Double.parseDouble(datos[3]),Integer.parseInt(datos[4]));
                } else if (datos[1].equals("Express")) {
                    paquete = new PaqueteExpress(Integer.parseInt(datos[0]),datos[1],datos[2],Double.parseDouble(datos[3]),datos[4]);
                }
                if (paquete != null){
                    listaPaquetes.add(paquete);
                }
            }
        } catch (Exception e) {
            System.out.println("Error al cargar archivo");
        }
    }

    public void mostrarHistorial(){
        System.out.println("---EMPRESA DE REPARTO SPEEDFAST---");
        for (PaqueteBase paquete : listaPaquetes){
            paquete.mostrarResumen();
        }
    }

    public void filtrarTipo(){
        String filtrado = null;
        System.out.println("\n---ESCOJA UNA OPCION DE PAQUETERIA---");
        System.out.println("1.Comida");
        System.out.println("2.Encomienda");
        System.out.println("3.Express");
        int eleccion = sc.nextInt();

        if (eleccion == 1) {
            filtrado = "COMIDA";
        } else if (eleccion == 2) {
            filtrado = "ENCOMIENDA";
        } else if (eleccion == 3) {
            filtrado = "EXPRESS";
        } else {
            System.out.println("Debes ingresar una opcion valida.");
        }

        System.out.print("\n---FILTRADO: PAQUETERIA DE " + filtrado + "---");
        for (PaqueteBase p : listaPaquetes){
            if(p.getTipoEntrega().equalsIgnoreCase(filtrado)){
                p.mostrarResumen();
                System.out.print("------------------------------------------");
            }
        }
        System.out.println("");
    }
}