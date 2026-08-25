package app;

import data.GestorPaqueteria;
import model.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GestorPaqueteria gp = new GestorPaqueteria();
        gp.cargarArchivo();

        boolean continuar = true;
        while (continuar) {
            System.out.println("\n---ESCOJA UNA OPCION DEL MENU---");
            System.out.println("1.Mostrar historial completo");
            System.out.println("2.Filtrar por tipo de paqueteria");
            System.out.println("3.Salir del sistema");

            Scanner sc = new Scanner(System.in);
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    gp.mostrarHistorial();
                    break;

                case 2:
                    gp.filtrarTipo();
                    break;

                case 3:
                    System.out.println("Saliendo del programa...");
                    continuar = false;
                    break;

                default:
                    System.out.println("Ingrese una opcion valida.");
            }
        }
    }
}