package modelo;

import modelo.clientes.Cliente;
import modelo.datosCliente.Facturas;
import modelo.datosCliente.Fecha;
import modelo.datosCliente.Llamadas;
import modelo.excepciones.ExcecpcionClienteYaExiste;
import modelo.excepciones.ExcepcionClienteNoExiste;
import modelo.excepciones.ExcepcionIntervaloFechas;
import modelo.tarifas.Tarifa;
import modelo.tarifas.TarifaPorDia;
import vista.InterfazVista;

import java.io.*;
import java.util.*;

public class GestorClientes implements Serializable, GestorModelo {
    private LinkedList<Cliente> listaClientes;
    private InterfazVista vista;
    private String descriptor;


    public GestorClientes(){
        this.listaClientes = new LinkedList<>();
    }

    public  void setVista(InterfazVista vista) {
        this.vista = vista;
    }

    public boolean darAltaCliente(Cliente cliente) throws ExcecpcionClienteYaExiste {
        Cliente aux = buscarCliente(cliente.getNif());
        if(aux != null) {
            descriptor = "El cliente ya existe en nuestra base de datos.";
            vista.getDescripcion();
            throw new ExcecpcionClienteYaExiste();
        }
        this.listaClientes.add(cliente);
        descriptor = "El cliente ha sido añadido\n\n";
        vista.getDescripcion();
        return true;
    }

    public Cliente buscarCliente(String nif) {
            for (Cliente cliente : listaClientes) {
                if (cliente.getNif().equals(nif)) {
                    return cliente;
                }
            }
            return null;
    }

    public boolean borrar(String nif) throws ExcepcionClienteNoExiste {
        Cliente cliente = buscarCliente(nif);
        if(cliente == null ) {
            descriptor = "El cliente no existe en nuestra base de datos. Prueba con otro NIF.";
            vista.getDescripcion();
           throw new ExcepcionClienteNoExiste();
        }
        descriptor = "El cliente ha sido borrado.\n\n";
        vista.getDescripcion();
        return listaClientes.remove(cliente);
    }

    public boolean cambiarTarifa(String nif, Tarifa tarifa) throws ExcepcionClienteNoExiste{
        Cliente cliente = buscarCliente(nif);
        if(cliente == null ) {
            descriptor = "El cliente no existe en nuestra base de datos. Prueba con otro NIF.";
            vista.getDescripcion();
            throw new ExcepcionClienteNoExiste();
        }
        cliente.setTarifa(tarifa);
        descriptor = "Tarifa añadida.\n\n";
        vista.getDescripcion();
        return true;
    }

    public Cliente recuperarDatosClientes(String nif) throws ExcepcionClienteNoExiste {
        Cliente cliente = buscarCliente(nif);
        if(cliente == null ) {
            descriptor = "El cliente no existe en nuestra base de datos. Prueba con otro NIF.";
            vista.getDescripcion();
            throw new ExcepcionClienteNoExiste();
        }
        return cliente;
    }

    public void datosClienteTXT(String nif) throws ExcepcionClienteNoExiste {
        descriptor = MostrarDatos.mostrarDatosCliente(recuperarDatosClientes(nif))+"\n\n";
        vista.getDescripcion();
    }

    public List<Cliente> devolverLista(){
        if (listaClientes.size() == 0) {
            descriptor = "La lista está vacía.";
            vista.getDescripcion();
        }
        return listaClientes;
    }

    public void listaClientesTXT(){
        descriptor = MostrarDatos.datosLista(devolverLista());
        vista.getDescripcion();
    }

    public boolean darAltaLlamada(Llamadas llamada, String nif) throws ExcepcionClienteNoExiste{
        Cliente cliente = buscarCliente(nif);
        if(cliente == null ) {
            descriptor = "El cliente no existe en nuestra base de datos. Prueba con otro NIF.";
            vista.getDescripcion();
            throw new ExcepcionClienteNoExiste();
        }
        cliente.getListaLlamadas().add(llamada);
        descriptor = "La llamada ha sido añadida correctamente.";
        vista.getDescripcion();
        return true;
    }

    public List<Llamadas> llamadasCliente(String nif) throws ExcepcionClienteNoExiste {
        Cliente cliente = buscarCliente(nif);
        if(cliente == null ) {
            descriptor = "El cliente no existe en nuestra base de datos. Prueba con otro NIF.";
            vista.getDescripcion();
            throw new ExcepcionClienteNoExiste();
        }
        return cliente.getListaLlamadas();
    }

    public void listaLlamadasTXT(String nif) throws ExcepcionClienteNoExiste {
        descriptor = MostrarDatos.llamadasCliente(llamadasCliente(nif));
        vista.getDescripcion();
    }

    public Facturas emitirFactura(String nif, Calendar inicio, Calendar fin) throws ExcepcionClienteNoExiste, ExcepcionIntervaloFechas {
        Cliente cliente = buscarCliente(nif);
        if(cliente == null) {
            descriptor = "El cliente no existe en nuestra base de datos. Prueba con otro NIF.";
            vista.getDescripcion();
            throw new ExcepcionClienteNoExiste();
        }
        if(inicio.compareTo(fin)>0 || fin.compareTo(inicio) < 0) {
            descriptor = "El intervalo de fechas es incorrecto. Prueba con otro intervalo.";
            vista.getDescripcion();
            throw new ExcepcionIntervaloFechas();
        }
        double resultado = CalcularPrecioFactura(cliente, inicio, fin);
        Facturas nueva = new Facturas(cliente.getListaFacturas().size(),cliente.getTarifa(),Calendar.getInstance(),inicio,fin,resultado);
        cliente.getListaFacturas().add(nueva);
        descriptor = "La factura se ha añadido correctamente.";
        vista.getDescripcion();
        return nueva;
    }

    private double CalcularPrecioFactura(Cliente cliente, Calendar inicio, Calendar fin) throws ExcepcionClienteNoExiste{
        Cliente aux = buscarCliente(cliente.getNif());
        if(aux == null) {
            throw new ExcepcionClienteNoExiste();
        }
        double resultado = 0;
        for (Llamadas llamada : cliente.getListaLlamadas() ) {
            if (llamada.getFecha().compareTo(inicio) >= 0 && llamada.getFecha().compareTo(fin)  <= 0 ) {
                resultado += llamada.getDuracion()*cliente.getTarifa().getPrecio();
            }
        }
        return resultado;
    }

    public Facturas datosFactura(String nif, int codigo) throws ExcepcionClienteNoExiste{
        Cliente cliente = buscarCliente(nif);
        if(cliente == null ) {
            descriptor = "El cliente no existe en nuestra base de datos. Prueba con otro NIF.";
            vista.getDescripcion();
            throw new ExcepcionClienteNoExiste();
        }
        for (Facturas factura : cliente.getListaFacturas()) {
            if (factura.getCodigo() == codigo) {
                return factura;
            }
        }
        return null;
    }

    public void datosFacturaTXT(String nif, int codigo) throws ExcepcionClienteNoExiste {
        descriptor = MostrarDatos.mostrarDatosFactura(datosFactura(nif, codigo));
        vista.getDescripcion();
    }

    public List<Facturas> listaFacturaCliente(String nif)  throws ExcepcionClienteNoExiste{
        Cliente cliente = buscarCliente(nif);
        if(cliente == null ) {
            descriptor = "El cliente no existe en nuestra base de datos. Prueba con otro NIF.";
            vista.getDescripcion();
            throw new ExcepcionClienteNoExiste();
        }
        return cliente.getListaFacturas();
    }

    public void listaFacturasTXT(String nif) throws ExcepcionClienteNoExiste {
        descriptor = MostrarDatos.facturasCliente(listaFacturaCliente(nif));
        vista.getDescripcion();
    }


    //Crea una lista filtrada según las fechas. Clase genérica, sirve para varios métodos
    public < T extends Fecha> Collection  muestra (Collection<T> conjunto, Calendar inicio, Calendar fin) throws ExcepcionIntervaloFechas {
        if(inicio.compareTo(fin) > 0) {
            throw new ExcepcionIntervaloFechas(inicio,fin);
        }
        List<T> listaFiltrado = new LinkedList<>();
        for ( T elemento : conjunto ){
            if (elemento.getFecha().compareTo(inicio) >= 0 && elemento.getFecha().compareTo(fin)  <= 0){
                listaFiltrado.add(elemento);
            }
        }
        return listaFiltrado;
    }

    public String getDescriptor() {
        return descriptor;
    }

}