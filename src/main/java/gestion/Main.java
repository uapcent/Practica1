package gestion;

import clientes.Cliente;
import clientes.Empresa;
import clientes.Particular;
import com.sun.xml.internal.bind.v2.TODO;
import datosCliente.Direccion;
import datosCliente.Facturas;
import datosCliente.Llamadas;
import datosCliente.Tarifa;

import java.io.*;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class Main implements Serializable {


    public static void main(String[] args) {
        Scanner imput;  //Importante
        imput = new Scanner(System.in);
        boolean salir = false;
        GestorClientes gestionClientes = new GestorClientes();


        while (!salir) {

            System.out.println("Introduce un número para elegir opción: ");
            System.out.println("1. Cliente\n2. Factura\n3.Llamada\n4. Salir");
            int opcion = imput.nextInt();
            switch (opcion){
                case 1:
                    switch (menuCliente()){
                        case 1:
                            añadeCliente(gestionClientes);
                            break;
                        case 2:
                            borraCliente(gestionClientes);
                            break;
                        case 3:
                            obtenerCliente(gestionClientes);
                            break;
                        case 4:
                            listaClientes(gestionClientes);
                            break;
                        case 5:
                            cambiarTarifaCliente(gestionClientes);
                            break;
                        case 6:
                            listaClientesFechas(gestionClientes);
                        default:
                            break;
                    }
                    break;

                case 2:
                    switch (menuLlamada()){
                        case 1:
                            darAltaLlamada(gestionClientes);
                            break;
                        case 2:
                            llamadasCliente(gestionClientes);
                            break;
                        default:
                            break;
                    }
                    break;

                case 3:
                    switch (menuFactura()){
                        case 1:
                            emitirFactura(gestionClientes);
                            break;
                        case 2:
                            datosFactura(gestionClientes);
                            break;
                        case 3:
                            listaFacturaCliente(gestionClientes);
                        default:
                            break;
                    }
                    break;

                case 4:
                    salir = false;
                default:
                    break;
            }
        }


        //Crear un objeto de gestion clientes para llamar a los métodos, variables y tal
        //1: cliente
        //2: factura
        //3: llamada
        //4: salir
        GestorClientes aux = new GestorClientes();

        //TODO Hacer menu

        //Hay que meterlo en un try catch del menu

    }






    private static int menuCliente() {
        Scanner imput  = new Scanner(System.in);
        System.out.println("Introduce un número para elegir opción: ");
        System.out.println("1. Añadir liente\n2. Borrar cliente\n3. Obtener cliente\n4. Obtener lista de clientes\n5. Cambiar la tarifa de un cliente\n6. Obtener una lista de cliente por fecha\n7. Salir");
        int opcion = imput.nextInt();
        switch (opcion){
            case 1: return 1;
            case 2: return 2;
            case 3: return 3;
            case 4: return 4;
            case 5: return 5;
            case 6: return 6;
            default: return -1;
        }
    }

    private static int menuLlamada(){
        Scanner imput = new Scanner(System.in);
        System.out.println("Introduce un número para elegir opción: ");
        System.out.println("1. Dar de alta una llamada\n2. Listar todas las llamadas de un cliente\n3. Salir");
        int opcion = imput.nextInt();
        switch (opcion){
            case 1: return 1;
            case 2: return 2;
            default: return -1;
        }
    }

    private static int menuFactura() {
        Scanner imput = new Scanner(System.in);
        System.out.println("Introduce un número para elegir opción: ");
        System.out.println("1. Emitir factura para un cliente\n2. Recuperar datos de una factura\n3. Recuperar facturas de un cliente\n4. Salir");
        int opcion = imput.nextInt();
        switch (opcion){
            case 1: return 1;
            case 2: return 2;
            case 3: return 3;
            default: return -1;
        }
    }

    private static void añadeCliente(GestorClientes gestionClientes){
        Scanner imput = new Scanner(System.in);
        System.out.println("Introduce los datos del cliente: \nNombre: ");
        String nombre  = imput.next();

        System.out.println("Apellidos: (O escribe - si es una empresa)");
        String apellidos = imput.next();

        System.out.println("Nif: ");
        String nif = imput.next();

        System.out.println("Código Postal: ");
        int codpos = imput.nextInt();

        System.out.println("Provincia: ");
        String prov = imput.next();

        System.out.println("Población: ");
        String pob = imput.next();

        System.out.println("Correo electónico: ");
        String email = imput.next();

        Calendar fecha = Calendar.getInstance();
        System.out.println("Tarifa: ");

        Direccion dir = new Direccion(codpos, prov, pob);
        double precio = imput.nextInt();
        Tarifa tarifa = new Tarifa(precio);


        //TODO cliente no deberia recibir una lista de llamadas, sino que deberia crear una vacía

        if (apellidos.equals("-")){
            Cliente cli = new Empresa(nombre, nif, dir, email, fecha, tarifa);
        }else {
            Cliente cli = new Particular(nombre, apellidos, nif, dir, email, fecha, tarifa);
        }
    }

    private static void borraCliente(GestorClientes gestionClientes){}

    private static void obtenerCliente(GestorClientes gestionClientes){}

    private static void listaClientes(GestorClientes gestionClientes){}

    private static void cambiarTarifaCliente(GestorClientes gestionClientes){}

    private static void listaClientesFechas(GestorClientes gestionClientes){}

    private static void darAltaLlamada(GestorClientes gestionClientes) { }

    private static void llamadasCliente(GestorClientes gestionClientes) { }

    private static void emitirFactura(GestorClientes gestionClientes) { }

    private static void datosFactura(GestorClientes gestionClientes) { }

    private static void listaFacturaCliente(GestorClientes gestionClientes) {
    }
}


