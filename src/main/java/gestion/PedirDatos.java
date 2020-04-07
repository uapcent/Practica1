package gestion;

import java.util.Scanner;

public class PedirDatos {


    public String pideNombre(Scanner entrada) {
        System.out.println("Introduce el nombre: ");
        return entrada.next();
    }

    public String apellidos(Scanner entrada) {
        System.out.println("Introduce el apellido del cliente: ");
        return entrada.next();
    }

    public String nif(Scanner entrada) {
        System.out.println("Introduce el nif: ");
        return entrada.next();
    }

    public String email(Scanner entrada) {
        System.out.println("Introduce el correo: ");
        return entrada.next();
    }

    public String poblacion(Scanner entrada) {
        System.out.println("Introduce el nombre de la población a la que pertence: ");
        return entrada.next();
    }


    public String provincia(Scanner entrada) {
        System.out.println("Introduce el nombre de la provincia a la que pertence: ");
        return entrada.next();
    }

    public int codPostal(Scanner entrada) {
        System.out.println("Introduce el Código Postal de la población: ");
        return entrada.nextInt();
    }

    public float tarifa(Scanner entrada) {
        System.out.println("Introduce el precio de la tarifa del cliente: ");
        return entrada.nextFloat();
    }
}
