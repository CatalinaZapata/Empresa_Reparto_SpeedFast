package app;

import data.GestorPaqueteria;
import model.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GestorPaqueteria gp = new GestorPaqueteria();
        gp.cargarBuffer();
        //gp.añadirInformacion();

        Scanner sc = new Scanner(System.in);
        boolean continuar = true;
        while (continuar) {
            System.out.println("\n---ESCOJA UNA OPCION DEL MENU---");
            System.out.println("1.Mostrar despacho ingresado");
            System.out.println("2.Cancelar ultimo despacho");
            System.out.println("3.Mostrar hitorial completo");
            System.out.println("4.Filtrar por tipo de paqueteria");
            System.out.println("5.Salir del sistema");

            String entrada = sc.nextLine();

            if(entrada.isBlank()){
                System.out.println("Ingrese una opcion valida");
            } else if (!entrada.matches("\\d+")){
                System.out.println("Ingrese solo numeros");
            } else {
                int opcion = Integer.parseInt(entrada);
                switch (opcion) {
                    case 1:
                        gp.imprimirDespachable(sc);
                        break;

                    case 2:
                        gp.imprimirCancelable();
                        break;

                    case 3:
                        gp.imrpimirRastreable();
                        break;

                    case 4:
                        gp.imprimirFiltro();
                        break;

                    case 5:
                        System.out.println("Saliendo del programa...");
                        continuar = false;
                        break;

                    default:
                        System.out.println("Ingrese una opcion valida.");
                }
            }
        }
    }
}