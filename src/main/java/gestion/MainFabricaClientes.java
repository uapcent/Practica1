package gestion;

import clientes.Cliente;
import Fabricas.FabricaCliente;
import datosCliente.Direccion;
import tarifas.Tarifa;
import tarifas.TarifaBasica;
import gestion.PedirDatos;

import java.util.Calendar;
import java.util.Scanner;

public class MainFabricaClientes {
    public static void main(String[] args) {
        new MainFabricaClientes().launch();
    }

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
        Scanner entrada = new Scanner(System.in);

        Cliente cliente;
        PedirDatos dato = new PedirDatos();
        GestorClientes gestor = new GestorClientes();
        String nombre;
        String apellidos;
        String nif;
        String  poblacion;
        String provincia;
        int codigoPostal;
        String email;
        Calendar fecha;
        float precioTarifa;
        Tarifa tarifa;
        Direccion dir;

        switch (opcion) {
            case PARTICULAR:
                nombre = dato.pideNombre(entrada);
                apellidos = dato.apellidos(entrada);
                nif = dato.nif(entrada);
                email = dato.email(entrada);
                poblacion = dato.poblacion(entrada);
                provincia = dato.provincia(entrada);
                codigoPostal = dato.codPostal(entrada);
                fecha = Calendar.getInstance();
                precioTarifa = dato.tarifa(entrada);
                dir = new Direccion(codigoPostal,provincia,poblacion);
                tarifa = new TarifaBasica(precioTarifa);
                cliente = opcion.getCliente(nombre, apellidos, nif, dir, email, fecha, tarifa);
                gestor.darAltaCliente(cliente);
                break;
            case EMPRESA:
                nombre = dato.pideNombre(entrada);
                nif = dato.nif(entrada);
                email = dato.email(entrada);
                poblacion = dato.poblacion(entrada);
                provincia = dato.provincia(entrada);
                codigoPostal = dato.codPostal(entrada);
                fecha = Calendar.getInstance();
                precioTarifa = dato.tarifa(entrada);
                dir = new Direccion(codigoPostal,provincia,poblacion);
                tarifa = new TarifaBasica(precioTarifa);
                cliente = opcion.getCliente(nombre, nif, dir, email, fecha, tarifa);

                break;
            case SALIR:
                entrada.close();
                break;
        }
    }

    private void menu() {
        System.out.println(FabricaCliente.opciones());
    }
}
