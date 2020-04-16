package gestion;

import clientes.Cliente;
import Fabricas.FabricaCliente;
import datosCliente.Direccion;
import excepciones.ExcecpcionClienteYaExiste;
import tarifas.Tarifa;
import tarifas.TarifaBasica;
import gestion.PedirDatos;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Scanner;

public class MainFabricaClientes implements Serializable {

    public void launch(GestorClientes gestorClientes) {
        FabricaCliente opcion;
        do {
            menu();
            opcion = pideOpcion();
            filtraOpcion(opcion, gestorClientes);
        } while (opcion != FabricaCliente.SALIR);
    }

    private FabricaCliente pideOpcion() {
        Scanner scanner = new Scanner(System.in);
        return FabricaCliente.enteroATipo(scanner.nextInt());
    }

    public void filtraOpcion(FabricaCliente opcion, GestorClientes gestorClientes) {
        Scanner entrada = new Scanner(System.in);

        Cliente cliente;
        PedirDatos dato = new PedirDatos();
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
                try {
                    nombre = dato.pideNombre(entrada);
                    apellidos = dato.apellidos(entrada);
                    nif = dato.nif(entrada);
                    email = dato.email(entrada);
                    poblacion = dato.poblacion(entrada);
                    provincia = dato.provincia(entrada);
                    codigoPostal = dato.codPostal(entrada);
                    fecha = Calendar.getInstance();
                    precioTarifa = dato.tarifa(entrada);
                    dir = new Direccion(codigoPostal, provincia, poblacion);
                    tarifa = new TarifaBasica(precioTarifa);
                    cliente = opcion.getCliente(nombre, apellidos, nif, dir, email, fecha, tarifa);
                    gestorClientes.darAltaCliente(cliente);
                    System.out.println("El cliente se ha añadido correctamente.");
                    break;
                }catch (ExcecpcionClienteYaExiste e) {
                    e.printStackTrace();
                }
            case EMPRESA:
                try {
                    nombre = dato.pideNombre(entrada);
                    nif = dato.nif(entrada);
                    email = dato.email(entrada);
                    poblacion = dato.poblacion(entrada);
                    provincia = dato.provincia(entrada);
                    codigoPostal = dato.codPostal(entrada);
                    fecha = Calendar.getInstance();
                    precioTarifa = dato.tarifa(entrada);
                    dir = new Direccion(codigoPostal, provincia, poblacion);
                    tarifa = new TarifaBasica(precioTarifa);
                    cliente = opcion.getCliente(nombre, nif, dir, email, fecha, tarifa);
                    gestorClientes.darAltaCliente(cliente);
                    System.out.println("El cliente se ha añadido correctamente");
                    break;
                }catch (ExcecpcionClienteYaExiste e) {
                    e.printStackTrace();
                }
            case SALIR:
                break;
        }
    }

    private void menu() {
        System.out.println(FabricaCliente.opciones());
    }
}
