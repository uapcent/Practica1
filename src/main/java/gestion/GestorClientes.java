package gestion;

import clientes.Cliente;
import datosCliente.Facturas;
import datosCliente.Fecha;
import datosCliente.Llamadas;
import datosCliente.Tarifa;

import java.util.*;

public class GestorClientes {
    private Set<Cliente> listaClientes = new HashSet<Cliente>();

    public boolean darAltaCliente(Cliente cliente){
        try {
            Cliente aux = buscarCliente(cliente.getNif());
            if (aux!=null){
                throw new MiExcepcion(102);
            }
        }catch (MiExcepcion miExcepcion){
            System.out.println(miExcepcion.getMessage());
            return false;
        }
        return listaClientes.add(cliente);
    }

    private Cliente buscarCliente(String nif){
        for(Cliente cliente : listaClientes) {
            if(cliente.getNif().equals(nif)) {
                return cliente;
            }
        }
        return null;
    }

    public boolean borrar(Cliente cliente){
        try {
            Cliente aux = buscarCliente(cliente.getNif());
            if (aux==null){
                throw new MiExcepcion(103);
            }
        }catch (MiExcepcion miExcepcion){
            System.out.println(miExcepcion.getMessage());
            return false;
        }
        listaClientes.remove(cliente);
        return true;
    }

    public boolean cambiarTarifa(String nif, Tarifa tarifa){
        try {
            Cliente aux = buscarCliente(nif);
            if (aux==null){
                throw new MiExcepcion(103);
            }
        }catch (MiExcepcion miExcepcion){
            System.out.println(miExcepcion.getMessage());
            return false;
        }
        for(Cliente cliente : listaClientes) {
            if(cliente.getNif().equals(nif)) {
                cliente.setTarifa(tarifa);
                return true;
            }
        }
        return false;
    }

    public Cliente recuperarDatosClientes(String nif) {
        try {
            Cliente aux = buscarCliente(nif);
            if (aux==null){
                throw new MiExcepcion(103);
            }
        }catch (MiExcepcion miExcepcion){
            System.out.println(miExcepcion.getMessage());
            return null;
        }
        for (Cliente cliente : listaClientes) {
            if (cliente.getNif().equals(nif)) {
                return cliente;
            }
        }
        return null;
    }

    public Set<Cliente> devolverLista(){
        return listaClientes;
    }

    public boolean darAltaLlamada(Llamadas llamada, String nif) {
        try {
            Cliente aux = buscarCliente(nif);
            if (aux==null){
                throw new MiExcepcion(103);
            }
        }catch (MiExcepcion miExcepcion){
            System.out.println(miExcepcion.getMessage());
            return false;
        }

        for (Cliente cliente : listaClientes) {
            if(cliente.getNif().equals(nif)) {
                cliente.getListaLlamadas().add(llamada);
                return true;
            }
        }
        return false;

    }

    public List<Llamadas> llamadasCliente(String nif) {
        try {
            Cliente aux = buscarCliente(nif);
            if (aux==null){
                throw new MiExcepcion(103);
            }
        }catch (MiExcepcion miExcepcion){
            System.out.println(miExcepcion.getMessage());
            return null;
        }

        for(Cliente cliente : listaClientes) {
            if(cliente.getNif().equals(nif)) {
                return cliente.getListaLlamadas();
            }
        }
        return null;
    }

    public Facturas emitirFactura(String nif, Calendar inicio, Calendar fin) {

        try {
            Cliente aux = buscarCliente(nif);
            if (aux==null) {
                throw new MiExcepcion(103);
            }
            if (inicio.compareTo(fin)>=0){
                throw new MiExcepcion(101);
            }
        } catch (MiExcepcion miExcepcion) {
            //miExcepcion.printStackTrace();
            System.out.println(miExcepcion.getMessage());
            return null;
        }


        double resultado = 0;
        for(Cliente cliente : listaClientes) {
            if (cliente.getNif().equals(nif)) {
                for (Llamadas llamada : cliente.getListaLlamadas() ) {
                    if (llamada.getFecha().compareTo(inicio) >= 0 && llamada.getFecha().compareTo(fin)  <= 0 ) {
                        resultado += llamada.getDuracion()*cliente.getTarifa().getPrecio();
                    }
                }
                Facturas nueva = new Facturas(cliente.getListaFacturas().size(),cliente.getTarifa(),Calendar.getInstance(),inicio,fin,resultado);
                cliente.getListaFacturas().add(nueva);
                return nueva;
            }
        }
        return null;
    }

    public Facturas datosFactura(String nif, int codigo) {
        try {
            Cliente aux = buscarCliente(nif);
            if (aux==null){
                throw new MiExcepcion(103);
            }
        }catch (MiExcepcion miExcepcion){
            System.out.println(miExcepcion.getMessage());
            return null;
        }

        for(Cliente cliente : listaClientes) {
            if (cliente.getNif().equals(nif)) {
                for (Facturas factura : cliente.getListaFacturas()) {
                    if(factura.getCodigo() == codigo) {
                        return factura;
                    }

                }
            }
        }
        return null;
    }

    public List<Facturas> listaFacturaCliente(String nif) {
        try {
            Cliente aux = buscarCliente(nif);
            if (aux==null){
                throw new MiExcepcion(103);
            }
        }catch (MiExcepcion miExcepcion){
            System.out.println(miExcepcion.getMessage());
            return null;
        }


        for(Cliente cliente : listaClientes) {
            if (cliente.getNif().equals(nif)) {
                return cliente.getListaFacturas();
            }
        }
        return null;
    }

    //Crea una lista filtrada según las fechas. Clase genérica, sirve para varios métodos
    public < T extends Fecha> Collection  muestra (Collection<T> conjunto, Calendar inicio, Calendar fin)  {

        try {
            if (inicio.compareTo(fin)>=0){
                throw new MiExcepcion(101);
            }
        } catch (MiExcepcion miExcepcion) {
            //miExcepcion.printStackTrace();
            System.out.println(miExcepcion.getMessage());
            return null;
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