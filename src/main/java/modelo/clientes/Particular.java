package modelo.clientes;

import modelo.datosCliente.Direccion;
import modelo.tarifas.Tarifa;

import java.io.Serializable;
import java.util.Calendar;

public class Particular extends Cliente implements Serializable {
    private String apellidos;

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
                "Código postal: "+ getDireccion().getCodPostal() + "\n" +
                "Población: "+ getDireccion().getPoblacion() + "\n" +
                "Provincia: "+ getDireccion().getProvincia() + "\n" +
                "Correo: " + getEmail() + "\n" +
                "Fecha: " + getFecha().get(Calendar.DAY_OF_MONTH) + "/" + getFecha().get(Calendar.MONTH) + "/" + getFecha().get(Calendar.YEAR) + "\n" +
                getTarifa().descripcion();
    }

}
