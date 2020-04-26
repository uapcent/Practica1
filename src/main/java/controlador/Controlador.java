package controlador;

import modelo.GestorModelo;
import modelo.datosCliente.Direccion;
import modelo.excepciones.ExcecpcionClienteYaExiste;
import modelo.excepciones.ExcepcionClienteNoExiste;
import modelo.tarifas.Tarifa;
import vista.InterfazVista;
import modelo.Fabricas.*;

import java.util.Calendar;

public class Controlador implements InterfazControlador {
    private InterfazVista vista;
    private GestorModelo modelo;

    public Controlador() {}

    public void setVista(InterfazVista vista) {
        this.vista = vista;
    }

    public void setModelo(GestorModelo modelo) {
        this.modelo = modelo;
    }


    @Override
    public void nuevoCliente() {
        String nombre = vista.getNombre();
        String apellidos = vista.getApellidos();
        String nif = vista.getNIF();
        String poblacion = vista.getPoblación();
        String provincia = vista.getProvincia();
        int codigoPostal = vista.getCodigoPostal();
        Direccion direccion = new Direccion(codigoPostal,provincia,poblacion);
        String email = vista.getEmail();
        Calendar fecha = Calendar.getInstance();
        float precio = vista.getPrecio();
        Tarifa tarifa;
        FabricaClientes cliente = new FabricaClientes();
        FabricaTarifas tarifaFabrica = new FabricaTarifas();
        if (apellidos.equals("")) {
            try {
                tarifa = tarifaFabrica.crearTarifaBásica(precio);
                modelo.darAltaCliente(cliente.crearEmpresa(nombre, nif, direccion, email, fecha, tarifa));
            } catch (ExcecpcionClienteYaExiste e) {
                e.printStackTrace();
            }
        }else {
            try {
                tarifa = tarifaFabrica.crearTarifaBásica(precio);
                modelo.darAltaCliente(cliente.crearParticular(nombre, apellidos, nif, direccion, email, fecha, tarifa));
            }catch (ExcecpcionClienteYaExiste e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void borrarCliente() {
        try {
            String nif = vista.getNIF();
            modelo.borrar(nif);
        }catch (ExcepcionClienteNoExiste e) {
            e.printStackTrace();
        }

    }

    @Override
    public void listarClientesTXT() {

    }
}
