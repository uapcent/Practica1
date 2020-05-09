package controlador;

import modelo.GestorModelo;
import modelo.clientes.Cliente;
import modelo.datosCliente.Direccion;
import modelo.datosCliente.Llamadas;
import modelo.excepciones.ExcecpcionClienteYaExiste;
import modelo.excepciones.ExcepcionClienteNoExiste;
import modelo.excepciones.ExcepcionIntervaloFechas;
import modelo.tarifas.Tarifa;
import vista.InterfazVista;
import modelo.Fabricas.*;

import java.util.Calendar;
import java.util.List;
import java.util.Set;

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
        modelo.listaClientesTXT();
    }

    public void listarLlamadasClientesTXT() throws ExcepcionClienteNoExiste {
        String nif = vista.getNIF();
        modelo.listaLlamadasTXT(nif);
    }

    public void listaFacturasClientesTXT() throws ExcepcionClienteNoExiste {
        String nif = vista.getNIF();
        modelo.listaFacturasTXT(nif);
    }

    public void datosClienteTXT() {
        try {
            String nif = vista.getNIF();
            modelo.datosClienteTXT(nif);
        }catch(ExcepcionClienteNoExiste e) {
            e.printStackTrace();
            }
    }

    public void datosFacturaTXT() throws ExcepcionClienteNoExiste {
        String nif = vista.getNIF();
        int codigo = vista.getCodigoFactura();
        modelo.datosFacturaTXT(nif, codigo);
    }

    @Override
    public void nuevaLlamada() {
        try {
            String nif = vista.getNIF();
            String telefono = vista.getTelefono();
            Calendar fechaLlamada = new Calendar.Builder().setDate(vista.getAnyo(), vista.getMes(), vista.getDia()).setTimeOfDay(vista.getHora(), vista.getMinuto(), 0).build();
            int duracion = vista.getDuracionLlamada();
            Llamadas llamada = new Llamadas(telefono, fechaLlamada, duracion);
            modelo.darAltaLlamada(llamada, nif);
        }catch (ExcepcionClienteNoExiste e) {
            e.printStackTrace();
        }
    }

    @Override
    public void emitirFactura() throws ExcepcionClienteNoExiste, ExcepcionIntervaloFechas {
        String nif = vista.getNIF();
        Calendar fechaInicial = new Calendar.Builder().setDate(vista.getAnyo(),vista.getMes(),vista.getDia()).setTimeOfDay(vista.getHora(),vista.getMinuto(), 0).build();
        Calendar fechaFinal = new Calendar.Builder().setDate(vista.getAnyo(),vista.getMes(),vista.getDia()).setTimeOfDay(vista.getHora(),vista.getMinuto(), 0).build();
        modelo.emitirFactura(nif,fechaInicial, fechaFinal);
    }
}
