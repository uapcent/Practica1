package Fabricas;

import clientes.Cliente;
import datosCliente.Direccion;
import tarifas.Tarifa;

import java.util.Calendar;

public interface CrearClientes {

    public Cliente crearEmpresa(String nombre, String nif, Direccion dir, String email, Calendar fecha, Tarifa tarifa);
    public Cliente crearParticular(String nombre, String apellidos, String nif, Direccion dir, String email, Calendar fecha, Tarifa tarifa);
}
