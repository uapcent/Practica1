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
        Scanner input;  //Importante
        input = new Scanner(System.in);
        boolean salir = false;
        GestorClientes gestionClientes = new GestorClientes();

        while (!salir) {
            System.out.println("Introduce un número para elegir opción: ");
            System.out.println("1. Cliente\n2. Factura\n3.Llamada\n4. Salir");
            int opcion = input.nextInt();
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
        input.close();


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
        Scanner input  = new Scanner(System.in);
        System.out.println("Introduce un número para elegir opción: ");
        System.out.println("1. Añadir cliente\n2. Borrar cliente\n3. Obtener cliente\n4. Obtener lista de clientes\n5. Cambiar la tarifa de un cliente\n6. Obtener una lista de cliente por fecha\n7. Salir");
        int opcion = input.nextInt();
        switch (opcion){
            case 1: return 1;
            case 2: return 2;
            case 3: return 3;
            case 4: return 4;
            case 5: return 5;
            case 6: return 6;
            default:
                input.close();
                return -1;
        }
    }

    private static int menuLlamada(){
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce un número para elegir opción: ");
        System.out.println("1. Dar de alta una llamada\n2. Listar todas las llamadas de un cliente\n3. Salir");
        int opcion = input.nextInt();
        switch (opcion){
            case 1: return 1;
            case 2: return 2;
            default:
                input.close();
                return -1;
        }
    }

    private static int menuFactura() {
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce un número para elegir opción: ");
        System.out.println("1. Emitir factura para un cliente\n2. Recuperar datos de una factura\n3. Recuperar facturas de un cliente\n4. Salir");
        int opcion = input.nextInt();
        switch (opcion){
            case 1: return 1;
            case 2: return 2;
            case 3: return 3;
            default:
                input.close();
                return -1;
        }
    }

    private static void añadeCliente(GestorClientes gestionClientes){
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce los datos del cliente: \nNombre: ");
        String nombre  = input.next();

        System.out.println("Apellidos: (O escribe - si es una empresa)");
        String apellidos = input.next();

        System.out.println("Nif: ");
        String nif = input.next();

        System.out.println("Código Postal: ");
        int codpos = input.nextInt();

        System.out.println("Provincia: ");
        String prov = input.next();

        System.out.println("Población: ");
        String pob = input.next();

        System.out.println("Correo electónico: ");
        String email = input.next();

        Calendar fecha = Calendar.getInstance();
        System.out.println("Tarifa: ");

        Direccion dir = new Direccion(codpos, prov, pob);
        double precio = input.nextDouble();
        Tarifa tarifa = new Tarifa(precio);

        //TODO cliente no deberia recibir una lista de llamadas, sino que deberia crear una vacía
        boolean añadido;
        if (apellidos.equals("-")){
            Cliente cli = new Empresa(nombre, nif, dir, email, fecha, tarifa);
            añadido = gestionClientes.darAltaCliente(cli);
        }else {
            Cliente cli = new Particular(nombre, apellidos, nif, dir, email, fecha, tarifa);
            añadido = gestionClientes.darAltaCliente(cli);
        }
        if(añadido) {
            System.out.println("El cliente ha sido añadido correctamente.");
        }
        input.close();
    }

    private static void borraCliente(GestorClientes gestionClientes){
        Scanner input = new Scanner(System.in);
        System.out.println("Introduja el DNI del cliente que desea borrar: ");
        String nif = input.next();
        boolean borrado = gestionClientes.borrar(nif);
        if (borrado) {
            System.out.println("El cliente ha sido borrado correctamente.");
        }
        input.close();
    }

    private static void obtenerCliente(GestorClientes gestionClientes){
        Scanner input = new Scanner(System.in);
        System.out.println("Introduja el DNI del cliente del que desea saber los datos: ");
        String nif = input.next();
        System.out.println("Los datos del cliente son los siguientes: ");
        gestionClientes.recuperarDatosClientes(nif).toString();
        input.close();
    }

    private static void listaClientes(GestorClientes gestionClientes){
        System.out.println("El listado de los clientes almacenado es el siguiente: ");
        gestionClientes.devolverLista();
    }

    private static void cambiarTarifaCliente(GestorClientes gestionClientes){
        Scanner input = new Scanner(System.in);
        System.out.println("Introduja el DNI del cliente del que quiera cambiar su Tarifa: ");
        String nif = input.next();
        System.out.println("Introduja la nueva Tarifa que se le va a asignar al cliente: ");
        double precioTarifa = input.nextDouble();
        Tarifa tarifa = new Tarifa(precioTarifa);
        boolean añadido = gestionClientes.cambiarTarifa(nif, tarifa);
        if (añadido) {
            System.out.println("La factura ha sido cambiada correctamente.");
        }
        input.close();
    }

    private static void listaClientesFechas(GestorClientes gestionClientes){
        Scanner input = new Scanner(System.in);
        int dia;
        int mes;
        int año;
        System.out.println("Se quiere obtener la lista de clientes entre dos fechas.");
        System.out.println("Introduzca la fecha inicial con el siguiente formato (01/01/2020): ");
        String fechaIni = input.next();
        dia = Integer.parseInt(fechaIni.substring(0,2));
        mes = Integer.parseInt(fechaIni.substring(3,5));
        año = Integer.parseInt(fechaIni.substring(6,fechaIni.length()));
        Calendar fechaInicial = new Calendar.Builder().setDate(año,mes,dia).build();
        System.out.println("Introduzca la fecha final con el siguiente formato (01/01/2020): ");
        String fechaFin = input.next();
        dia = Integer.parseInt(fechaIni.substring(0,2));
        mes = Integer.parseInt(fechaIni.substring(3,5));
        año = Integer.parseInt(fechaIni.substring(6,fechaIni.length()));
        Calendar fechaFinal = new Calendar.Builder().setDate(año,mes,dia).build();
        System.out.println("Su lista es la siguiente: ");
        gestionClientes.muestra(gestionClientes.devolverLista(),fechaInicial,fechaFinal);
        input.close();
    }

    private static void darAltaLlamada(GestorClientes gestionClientes) {
        Scanner input = new Scanner(System.in);
        int dia;
        int mes;
        int año;
        System.out.println("Introduja el nif del cliente, el número de telefono, la fecha y la duración para añadir una llamada.");
        String nif = input.next();
        System.out.println("Numero de telefono: ");
        String numero = input.next();
        System.out.println("Introduzca la fecha de la llamada con el siguiente formato (01/01/2020): ");
        String fecha = input.next();
        dia = Integer.parseInt(fecha.substring(0,2));
        mes = Integer.parseInt(fecha.substring(3,5));
        año = Integer.parseInt(fecha.substring(6,fecha.length()));
        Calendar fechaLlamada = new Calendar.Builder().setDate(año,mes,dia).build();
        System.out.println("Duración de la llamada (en minutos): ");
        int duracion = input.nextInt();
        Llamadas llamada = new Llamadas(numero,fechaLlamada,duracion);
        boolean añadido = gestionClientes.darAltaLlamada(llamada, nif);
        if(añadido) {
            System.out.println("La llamada se ha añadido correctamente a la lista del cliente.");
        }
        input.close();
    }

    private static void llamadasCliente(GestorClientes gestionClientes) {
        Scanner input = new Scanner(System.in);
        System.out.println("Introduja el NIF del cliente del que quiera saber todas sus llamadas: ");
        String  nif = input.next();
        gestionClientes.llamadasCliente(nif);
        input.close();
    }

    private static void emitirFactura(GestorClientes gestionClientes) {
        Scanner input = new Scanner(System.in);
        int dia;
        int mes;
        int año;
        System.out.println("Introduce el NIF del cliente al que desea emitir la factura: ");
        String nif = input.next();
        System.out.println("Introduzca la fecha inicial de la factura con el siguiente formato (01/01/2020): ");
        String fechaIni = input.next();
        dia = Integer.parseInt(fechaIni.substring(0,2));
        mes = Integer.parseInt(fechaIni.substring(3,5));
        año = Integer.parseInt(fechaIni.substring(6,fechaIni.length()));
        Calendar fechaInicial = new Calendar.Builder().setDate(año,mes,dia).build();
        System.out.println("Introduzca la fecha final de la factura con el siguiente formato (01/01/2020): ");
        String fechaFin = input.next();
        dia = Integer.parseInt(fechaIni.substring(0,2));
        mes = Integer.parseInt(fechaIni.substring(3,5));
        año = Integer.parseInt(fechaIni.substring(6,fechaIni.length()));
        Calendar fechaFinal = new Calendar.Builder().setDate(año,mes,dia).build();
        System.out.println("La factura que ha añadido es la siguiente:");
        gestionClientes.emitirFactura(nif,fechaInicial,fechaFinal);
        input.close();
    }

    private static void datosFactura(GestorClientes gestionClientes) {
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce el NIF del cliente al que desea conocer una de sus facturas: ");
        String nif = input.next();
        System.out.println("Introduce el codigo de la factura que desea conocer de el cliente:  ");
        int codigo = input.nextInt();
        System.out.println("Los datos de la factura son los siguientes:");
        gestionClientes.datosFactura(nif,codigo);
        input.close();

    }

    private static void listaFacturaCliente(GestorClientes gestionClientes) {
        Scanner input = new Scanner(System.in);
        System.out.println("Introduja el NIF del cliente del que quiera saber todas sus facturas: ");
        String  nif = input.next();
        gestionClientes.listaFacturaCliente(nif);
        input.close();
    }
}


