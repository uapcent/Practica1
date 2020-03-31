package clientes;

import java.util.Calendar;

import datosCliente.Direccion;
import datosCliente.Facturas;
import datosCliente.Llamadas;
import datosCliente.Tarifa;

import java.util.LinkedList;
import java.util.List;

public class Empresa extends Cliente{

    public Empresa(String nombre, String nif, Direccion dir, String email, Calendar fecha, Tarifa tarifa){
        super(nombre, nif, dir, email, fecha, tarifa);

    }

    @Override
    public String toString(){
        return "Nombre: " + getNombre() + "\n" +
                "NIF: " + getNif() + "\n" +
                getDireccion().toString() + "\n" +
                "Correo: " + getEmail() + "\n" +
                "Fecha: " + getFecha().get(Calendar.DAY_OF_MONTH) + "/" + getFecha().get(Calendar.MONTH) + "/" + getFecha().get(Calendar.YEAR) + "\n" +
                getTarifa().toString() + "€";
     }
}
