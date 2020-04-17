package gestion;

import Fabricas.*;
import clientes.Cliente;
import clientes.Empresa;
import clientes.Particular;
import datosCliente.*;
import excepciones.ExcecpcionClienteYaExiste;
import excepciones.ExcepcionClienteNoExiste;
import excepciones.ExcepcionIntervaloFechas;
import tarifas.Tarifa;
import tarifas.TarifaBasica;

import java.io.*;
import java.util.*;

public class Main implements Serializable{

    public static void main(String[] args) {
        Scanner input;  //Importante
        input = new Scanner(System.in);
        boolean salir = false;
        GestorClientes gestionClientes = new GestorClientes();

        //Leer del fichero
        try {
            FileInputStream fis = null;
            fis = new FileInputStream("agenda.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            gestionClientes = (GestorClientes) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        while (!salir) {
            System.out.println("Introduce un número para elegir opción: ");
            System.out.println("1. Cliente\n2. Factura\n3. Llamada\n4. Salir");
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
                    salir = true;

                default:
                    break;
            }
        }
        input.close();
        //Escribir al fichero
        try {
            FileOutputStream fos = null;
            fos = new FileOutputStream("agenda.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(gestionClientes);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
                return -1;
        }
    }

    private static void añadeCliente(GestorClientes gestorClientes) {
       Scanner input = new Scanner(System.in);
       System.out.println("Elige el cliente que quieres crear: \n");
       System.out.println("1. Particular.\n2. Empresa\n3. Salir");
       FabricaClientes2 cliente = new FabricaClientes2();
       FabricaTarifas2 tarifaAPedir = new FabricaTarifas2();
       Main datos = new Main();
       PedirDatos dato = new PedirDatos();
       int opcion = input.nextInt();
       switch(opcion) {
           case 1:
               try {
                   String nombre = dato.pideNombre(input);
                   String apellidos = dato.apellidos(input);
                   String nif = dato.nif(input);
                   String email = dato.email(input);
                   String poblacion = dato.poblacion(input);
                   String provincia = dato.provincia(input);
                   int codigoPostal = dato.codPostal(input);
                   Calendar fecha = Calendar.getInstance();
                   float precioTarifa = dato.tarifa(input);
                   Direccion dir = new Direccion(codigoPostal, provincia, poblacion);
                   Tarifa tarifa = tarifaAPedir.crearTarifaBásica(precioTarifa);
                   tarifa = datos.crearTarifas(input,tarifa);
                   gestorClientes.darAltaCliente(cliente.crearParticular(nombre, apellidos, nif, dir, email, fecha, tarifa));
               }catch (ExcecpcionClienteYaExiste e) {
                   e.printStackTrace();
               }
           case 2:
               try {
                   String nombre = dato.pideNombre(input);
                   String nif = dato.nif(input);
                   String email = dato.email(input);
                   String poblacion = dato.poblacion(input);
                   String provincia = dato.provincia(input);
                   int codigoPostal = dato.codPostal(input);
                   Calendar fecha = Calendar.getInstance();
                   float precioTarifa = dato.tarifa(input);
                   Direccion dir = new Direccion(codigoPostal, provincia, poblacion);
                   Tarifa tarifa = tarifaAPedir.crearTarifaBásica(precioTarifa);
                   tarifa = datos.crearTarifas(input,tarifa);
                   gestorClientes.darAltaCliente(cliente.crearEmpresa(nombre, nif, dir, email, fecha, tarifa));
               }catch (ExcecpcionClienteYaExiste e) {
                   e.printStackTrace();
               }
           case 3:
               break;
       }

    }

    private static void borraCliente(GestorClientes gestionClientes){
        Scanner input = new Scanner(System.in);
        try {
            System.out.println("Introduja el DNI del cliente que desea borrar: ");
            String nif = input.next();
            boolean borrado = gestionClientes.borrar(nif);
            if (borrado) {
                System.out.println("El cliente ha sido borrado correctamente.");
            }
        }catch (ExcepcionClienteNoExiste e){
            e.printStackTrace();
        }

    }

    private static void obtenerCliente(GestorClientes gestionClientes) {
        Scanner input = new Scanner(System.in);
        try {
            System.out.println("Introduja el DNI del cliente del que desea saber los datos: ");
            String nif = input.next();
            System.out.println("Los datos del cliente son los siguientes: ");
            Cliente cliente = gestionClientes.recuperarDatosClientes(nif);
            System.out.println(cliente.toString());
        } catch (ExcepcionClienteNoExiste e) {
            e.printStackTrace();
        }
    }

    private static void listaClientes(GestorClientes gestionClientes){
        System.out.println("El listado de los clientes almacenado es el siguiente: ");
        Set<Cliente> lista =  gestionClientes.devolverLista();
        System.out.println(lista.size());
        for (Cliente cliente : lista) {
            System.out.println(cliente.toString());
            System.out.println("\n");
        }
    }

    private static void cambiarTarifaCliente(GestorClientes gestionClientes){
        Scanner input = new Scanner(System.in);
        Main crearTarifa = new Main();
        try {
            System.out.println("Introduja el DNI del cliente del que quiera cambiar su Tarifa: ");
            String nif = input.next();
            Cliente cliente = gestionClientes.buscarCliente(nif);
            Tarifa tarifa = cliente.getTarifa();
            tarifa = crearTarifa.crearTarifas(input, tarifa);
            boolean añadido = gestionClientes.cambiarTarifa(nif, tarifa);
            if (añadido) {
                System.out.println("La factura ha sido cambiada correctamente.");
            }
        }catch (ExcepcionClienteNoExiste e) {
            e.printStackTrace();
        }
    }

    private static void listaClientesFechas(GestorClientes gestionClientes){
        Scanner input = new Scanner(System.in);
        int dia;
        int mes;
        int año;
        try {
            System.out.println("Se quiere obtener la lista de clientes entre dos fechas.");
            System.out.println("Introduzca la fecha inicial con el siguiente formato (01/01/2020): ");
            String fechaIni = input.next();
            dia = Integer.parseInt(fechaIni.substring(0, 2));
            mes = Integer.parseInt(fechaIni.substring(3, 5));
            año = Integer.parseInt(fechaIni.substring(6, fechaIni.length()));
            Calendar fechaInicial = new Calendar.Builder().setDate(año, mes, dia).build();
            System.out.println("Introduzca la fecha final con el siguiente formato (01/01/2020): ");
            String fechaFin = input.next();
            dia = Integer.parseInt(fechaIni.substring(0, 2));
            mes = Integer.parseInt(fechaIni.substring(3, 5));
            año = Integer.parseInt(fechaIni.substring(6, fechaIni.length()));
            Calendar fechaFinal = new Calendar.Builder().setDate(año, mes, dia).build();
            System.out.println("Su lista es la siguiente: ");
            Collection<Cliente> lista = gestionClientes.muestra(gestionClientes.devolverLista(), fechaInicial, fechaFinal);
            for (Cliente cliente : lista) {
                System.out.println(cliente.toString());
                System.out.println("\n");
            }
        }catch (ExcepcionIntervaloFechas e) {
            e.printStackTrace();
        }
    }

    private static void darAltaLlamada(GestorClientes gestionClientes) {
        Scanner input = new Scanner(System.in);
        int dia;
        int mes;
        int año;
        try {
            System.out.println("Introduja el nif del cliente, el número de telefono, la fecha y la duración para añadir una llamada.");
            String nif = input.next();
            System.out.println("Numero de telefono: ");
            String numero = input.next();
            System.out.println("Introduzca la fecha de la llamada con el siguiente formato (01/01/2020): ");
            String fecha = input.next();
            dia = Integer.parseInt(fecha.substring(0, 2));
            mes = Integer.parseInt(fecha.substring(3, 5));
            año = Integer.parseInt(fecha.substring(6, fecha.length()));
            Calendar fechaLlamada = new Calendar.Builder().setDate(año, mes, dia).build();
            System.out.println("Duración de la llamada (en minutos): ");
            int duracion = input.nextInt();
            Llamadas llamada = new Llamadas(numero, fechaLlamada, duracion);
            boolean añadido = gestionClientes.darAltaLlamada(llamada, nif);
            if (añadido) {
                System.out.println("La llamada se ha añadido correctamente a la lista del cliente.");
            }
        }catch (ExcepcionClienteNoExiste e) {
            e.printStackTrace();
        }
    }

    private static void llamadasCliente(GestorClientes gestionClientes) {
        Scanner input = new Scanner(System.in);
        try {
            System.out.println("Introduja el NIF del cliente del que quiera saber todas sus llamadas: ");
            String nif = input.next();
            List<Llamadas> lista = gestionClientes.llamadasCliente(nif);
            for (Llamadas llamada : lista) {
                System.out.println(llamada.toString());
                System.out.println("\n");
            }
        }catch (ExcepcionClienteNoExiste e) {
            e.printStackTrace();
        }
    }

    private static void emitirFactura(GestorClientes gestionClientes) {
        Scanner input = new Scanner(System.in);
        int dia;
        int mes;
        int año;
        try {
            System.out.println("Introduce el NIF del cliente al que desea emitir la factura: ");
            String nif = input.next();
            System.out.println("Introduzca la fecha inicial de la factura con el siguiente formato (01/01/2020): ");
            String fechaIni = input.next();
            dia = Integer.parseInt(fechaIni.substring(0, 2));
            mes = Integer.parseInt(fechaIni.substring(3, 5));
            año = Integer.parseInt(fechaIni.substring(6, fechaIni.length()));
            Calendar fechaInicial = new Calendar.Builder().setDate(año, mes, dia).build();
            System.out.println("Introduzca la fecha final de la factura con el siguiente formato (01/01/2020): ");
            String fechaFin = input.next();
            dia = Integer.parseInt(fechaIni.substring(0, 2));
            mes = Integer.parseInt(fechaIni.substring(3, 5));
            año = Integer.parseInt(fechaIni.substring(6, fechaIni.length()));
            Calendar fechaFinal = new Calendar.Builder().setDate(año, mes, dia).build();
            System.out.println("La factura que ha emitido es la siguiente:");
            Facturas factura = gestionClientes.emitirFactura(nif, fechaInicial, fechaFinal);
            System.out.println(factura.toString());
        }catch (ExcepcionClienteNoExiste e) {
            e.printStackTrace();
        }catch (ExcepcionIntervaloFechas e) {
            e.printStackTrace();
        }
    }

    private static void datosFactura(GestorClientes gestionClientes) {
        Scanner input = new Scanner(System.in);
        try {
            System.out.println("Introduce el NIF del cliente al que desea conocer una de sus facturas: ");
            String nif = input.next();
            System.out.println("Introduce el codigo de la factura que desea conocer de el cliente:  ");
            int codigo = input.nextInt();
            System.out.println("Los datos de la factura son los siguientes:");
            Facturas factura = gestionClientes.datosFactura(nif, codigo);
            System.out.println(factura);
        }catch (ExcepcionClienteNoExiste e) {
            e.printStackTrace();
        }
    }

    private static void listaFacturaCliente(GestorClientes gestionClientes) {
        Scanner input = new Scanner(System.in);
        try {
            System.out.println("Introduja el NIF del cliente del que quiera saber todas sus facturas: ");
            String nif = input.next();
            List<Facturas> facturas = gestionClientes.listaFacturaCliente(nif);
            for (Facturas factura : facturas) {
                System.out.println(factura.toString());
                System.out.println("\n");
            }
        }catch (ExcepcionClienteNoExiste e) {
            e.printStackTrace();
        }
    }

    private Tarifa crearTarifas(Scanner entrada, Tarifa tarifa) {
        System.out.println("Elige la tarifa que quieras utilizar:");
        System.out.println("1. Tarifa Por Día\n2. Tarifa Por Horas\n3. Salir");
        int opcion = entrada.nextInt();
        float precio;
        FabricaTarifas2 tarifaACrear = new FabricaTarifas2();
        switch (opcion) {
            case 1:
                System.out.println("Elige el precio de tu tarifa por día: ");
                precio = entrada.nextFloat();
                System.out.println("Elige el día: ");
                String día = entrada.next();
                tarifa = tarifaACrear.crearTarifaPorDías(tarifa,precio,día);
                break;
            case 2:
                System.out.println("Elige el precio de tu tarifa por día: ");
                precio = entrada.nextFloat();
                System.out.println("Elige el día: ");
                int horaInicial = entrada.nextInt();
                int horaFinal = entrada.nextInt();
                tarifa = tarifaACrear.crearTarifaPorHoras(tarifa,precio,horaInicial,horaFinal);
                break;
            case 3:
                break;
        }
        return tarifa;
    }


    private static final long serialVersionUID = 2164987154748724908L;

}


