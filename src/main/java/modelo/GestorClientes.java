package modelo;

import modelo.clientes.Cliente;
import modelo.datosCliente.Facturas;
import modelo.datosCliente.Fecha;
import modelo.datosCliente.Llamadas;
import modelo.excepciones.ExcecpcionClienteYaExiste;
import modelo.excepciones.ExcepcionClienteNoExiste;
import modelo.excepciones.ExcepcionIntervaloFechas;
import modelo.tarifas.Tarifa;

import java.io.*;
import java.util.*;

public class GestorClientes implements Serializable, GestorModelo {
    private Set<Cliente> listaClientes = new HashSet<Cliente>();

    public boolean darAltaCliente(Cliente cliente) throws ExcecpcionClienteYaExiste {
        Cliente aux = buscarCliente(cliente.getNif());
        if(aux != null) {
            throw new ExcecpcionClienteYaExiste();
        }
        listaClientes.add(cliente);
        return true;
    }

    public Cliente buscarCliente(String nif){
        for(Cliente cliente : listaClientes) {
            if(cliente.getNif().equals(nif)) {
                return cliente;
            }
        }
        return null;
    }

    public boolean borrar(String nif) throws ExcepcionClienteNoExiste {
        Cliente cliente = buscarCliente(nif);
        if(cliente == null ) {
           throw new ExcepcionClienteNoExiste();
        }
        return listaClientes.remove(cliente);
    }

    public boolean cambiarTarifa(String nif, Tarifa tarifa) throws ExcepcionClienteNoExiste{
        Cliente cliente = buscarCliente(nif);
        if(cliente == null ) {
            throw new ExcepcionClienteNoExiste();
        }
        cliente.setTarifa(tarifa);
        return true;
    }

    public Cliente recuperarDatosClientes(String nif) throws ExcepcionClienteNoExiste {
        Cliente cliente = buscarCliente(nif);
        if(cliente == null ) {
            throw new ExcepcionClienteNoExiste();
        }
        return cliente;
    }

    public Set<Cliente> devolverLista(){
        return listaClientes;
    }

    public boolean darAltaLlamada(Llamadas llamada, String nif) throws ExcepcionClienteNoExiste{
        Cliente cliente = buscarCliente(nif);
        if(cliente == null ) {
            throw new ExcepcionClienteNoExiste();
        }
        cliente.getListaLlamadas().add(llamada);
        return true;
    }

    public List<Llamadas> llamadasCliente(String nif) throws ExcepcionClienteNoExiste {
        Cliente cliente = buscarCliente(nif);
        if(cliente == null ) {
            throw new ExcepcionClienteNoExiste();
        }
        return cliente.getListaLlamadas();
    }

    public Facturas emitirFactura(String nif, Calendar inicio, Calendar fin) throws ExcepcionClienteNoExiste, ExcepcionIntervaloFechas {
        Cliente cliente = buscarCliente(nif);
        if(cliente == null) {
            throw new ExcepcionClienteNoExiste();
        }
        if(inicio.compareTo(fin)>0 || fin.compareTo(inicio) < 0) {
            throw new ExcepcionIntervaloFechas();
        }
        double resultado = CalcularPrecioFactura(cliente, inicio, fin);
        Facturas nueva = new Facturas(cliente.getListaFacturas().size(),cliente.getTarifa(),Calendar.getInstance(),inicio,fin,resultado);
        cliente.getListaFacturas().add(nueva);
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
            throw new ExcepcionClienteNoExiste();
        }
        for (Facturas factura : cliente.getListaFacturas()) {
            if (factura.getCodigo() == codigo) {
                return factura;
            }
        }
        return null;
    }

    public List<Facturas> listaFacturaCliente(String nif)  throws ExcepcionClienteNoExiste{
        Cliente cliente = buscarCliente(nif);
        if(cliente == null ) {
            throw new ExcepcionClienteNoExiste();
        }
        return cliente.getListaFacturas();
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
}