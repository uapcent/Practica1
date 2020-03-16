package clientes;

import datosCliente.Direccion;
import datosCliente.Facturas;
import datosCliente.Llamadas;
import datosCliente.Tarifa;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

public class Particular extends Cliente {

    private String apellidos;
    List<Facturas> facturas = new LinkedList();
    List<Llamadas> llamadas = new LinkedList<>();

    public Particular(String nombre, String apellidos, String nif, Direccion dir, String email, Calendar fecha, Tarifa tarifa){
        super(nombre, nif, dir, email, fecha, tarifa);
        this.apellidos = apellidos;

    }

    public String getApellidos() {
        return apellidos;
    }

    public String toString(){
        return "Nombre: " + getNombre() + "\n" +
                "Apellidos: "+ getApellidos() + "\n" +
                "NIF: " + getNif() + "\n" +
                getDireccion().toString() + "\n" +
                "Correo: " + getEmail() + "\n" +
                "Fecha: " + getFecha().get(Calendar.DAY_OF_MONTH) + "/" + getFecha().get(Calendar.MONTH) + "/" + getFecha().get(Calendar.YEAR) + "\n" +
                getTarifa().toString() + "€";
    }

}
