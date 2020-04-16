package clientes;

import java.io.Serializable;
import java.util.Calendar;

import datosCliente.Direccion;
import tarifas.Tarifa;

public class Empresa extends Cliente implements Serializable {

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
