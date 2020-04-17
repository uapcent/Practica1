package Fabricas;

import clientes.Cliente;
import clientes.Empresa;
import clientes.Particular;
import datosCliente.Direccion;
import tarifas.Tarifa;

import java.util.Calendar;

public class FabricaClientes implements CrearClientes {
    @Override
    public Cliente crearEmpresa(String nombre, String nif, Direccion dir, String email, Calendar fecha, Tarifa tarifa) {
        return new Empresa(nombre,nif,dir,email,fecha,tarifa);
    }

    @Override
    public Cliente crearParticular(String nombre, String apellidos, String nif, Direccion dir, String email, Calendar fecha, Tarifa tarifa) {
        return new Particular(nombre,apellidos,nif,dir,email,fecha,tarifa);
    }
}
