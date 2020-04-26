package modelo.Fabricas;

import modelo.clientes.Cliente;
import modelo.datosCliente.Direccion;
import modelo.tarifas.Tarifa;

import java.util.Calendar;

public interface CrearClientes {

    public Cliente crearEmpresa(String nombre, String nif, Direccion dir, String email, Calendar fecha, Tarifa tarifa);
    public Cliente crearParticular(String nombre, String apellidos, String nif, Direccion dir, String email, Calendar fecha, Tarifa tarifa);
}
