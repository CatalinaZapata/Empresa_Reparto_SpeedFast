package data;

import model.*;

public class GestorPaqueteria {
    public void procesarPedidos(){
        PaqueteBase paquete1 = new PaqueteComida("Comida",1001,"Av. Libertador 123", "Juanita Perez", "Sushi Japones", 45);
        PaqueteBase paquete2 = new PaqueteEncomienda("Encomienda",1002, "Av. España 456", "Camila Soto", 500, 450);
        PaqueteBase paquete3 = new PaqueteExpress("Express", 1003, "Av. Matta 789", "Luis Díaz", 35, 20);

        paquete1.asignarRepartidor();
        paquete2.asignarRepartidor();
        paquete3.asignarRepartidor();
    }
}
