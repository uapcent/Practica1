package clientes;

import datosCliente.*;
import tarifas.Tarifa;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

public abstract class Cliente implements Fecha {

    //Constructor
    private String nombre;
    private String nif;
    private Direccion direccion;
    private String email;
    private Calendar fechaAlta;
    private Tarifa tarifa;
    private List<Facturas> listaFacturas = new LinkedList();
    private List<Llamadas> listaLlamadas = new LinkedList();

    public Cliente(String nombre, String nif, Direccion dir, String email, Calendar fecha, Tarifa tarifa){
        this.nombre = nombre;
        this.nif=nif;
        this.direccion=dir;
        this.email=email;
        this.fechaAlta=fecha;
        this.tarifa=tarifa;

    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return null;
    }

    public String getNif() {
        return nif;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public String getEmail() {
        return email;
    }
    //GetFecha
    @Override
    public Calendar getFecha(){
        return fechaAlta;
    }

    public Tarifa getTarifa() {
        return tarifa;
    }

    public List<Facturas> getListaFacturas() {
        return listaFacturas;
    }

    public List<Llamadas> getListaLlamadas() {
        return listaLlamadas;
    }

    public void setTarifa(Tarifa tarifa) {
        this.tarifa = tarifa;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFechaAlta(Calendar fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String toString(){
        return "Nombre: " + getNombre() + "\n" +
                "NIF: " + getNif() + "\n" +
                getDireccion().toString() + "\n" +
                "Correo: " + getEmail() + "\n" +
                "Fecha: " + getFecha().get(Calendar.DAY_OF_MONTH) + "/" + getFecha().get(Calendar.MONTH) + "/" + getFecha().get(Calendar.YEAR) + "\n" +
                getTarifa().toString() + "€";
    }
}
