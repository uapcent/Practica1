package gestion;

import clientes.Cliente;
import Fabricas.FabricaCliente;
import datosCliente.Direccion;
import tarifas.Tarifa;
import tarifas.TarifaBasica;

import java.util.Calendar;
import java.util.Scanner;

public class MainFabricaClientes {
    public static void main(String[] args) {new MainFabricaClientes().launch(); }

    private void launch() {
        FabricaCliente opcion;
        do {
            menu();
            opcion = pideOpcion();
            filtraOpcion(opcion);
        } while (opcion != FabricaCliente.SALIR);
    }

    private FabricaCliente pideOpcion() {
        Scanner scanner = new Scanner(System.in);
        return FabricaCliente.enteroATipo(scanner.nextInt());
    }

    private void filtraOpcion(FabricaCliente opcion) {
        Cliente cliente;

        String nombre, apellidos, nif, email;
        Calendar fecha;
        Tarifa tarifa;
        Direccion dir;

        /**Scanner input = new Scanner(System.in);
        System.out.println("Introduce los datos del cliente: \nNombre: ");
        String nombre = input.next();

        String apellidos = "";
        if (opcion == FabricaCliente.PARTICULAR) {
            System.out.println("Apellidos: (O escribe - si es una empresa)");
            apellidos = input.next();
        }

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
        float precio = input.nextInt();

        Direccion dir = new Direccion(codpos, prov, pob);
        Tarifa tarifa = new TarifaBasica(precio);
        **/

        switch (opcion) {
            preguntas(nombre, nif, email, fecha, tarifa, dir);
            case PARTICULAR:
                cliente = opcion.getCliente(nombre, apellidos, nif, dir, email, fecha, tarifa);
                System.out.println(cliente);
                break;

            case EMPRESA:
                cliente = opcion.getCliente(nombre, nif, dir, email, fecha, tarifa);
                System.out.println(cliente);
                break;

            case SALIR:
                break;
        }
        //input.close();
    }

    private void preguntas(String nombre, String nif, String email, Calendar fecha, Tarifa tarifa, Direccion dir){
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce los datos del cliente: \nNombre: ");
        nombre = input.next();

        System.out.println("Nif: ");
        nif = input.next();

        System.out.println("Código Postal: ");
        int codpos = input.nextInt();

        System.out.println("Provincia: ");
        String prov = input.next();

        System.out.println("Población: ");
        String pob = input.next();

        System.out.println("Correo electónico: ");
        email = input.next();

        fecha = Calendar.getInstance();
        System.out.println("Tarifa: ");
        float precio = input.nextInt();

        tarifa = new TarifaBasica(precio);
        dir = new Direccion(codpos, prov, pob);

    }

    private void menu() {
        System.out.println(FabricaCliente.opciones());
    }
}
