import java.util.*;

public class GestorClientes {
    private Set<Cliente> listaClientes = new HashSet<Cliente>();

    public boolean darAltaCliente(Cliente cliente){
        return listaClientes.add(cliente);
    }

    public boolean borrar(Cliente cliente){
        listaClientes.remove(cliente);
        return true;
    }

    public boolean cambiarTarifa(String nif, Tarifa tarifa){
        for(Cliente cliente : listaClientes) {
            if(cliente.getNif().equals(nif)) {
                cliente.setTarifa(tarifa);
                return true;
            }
        }
        return false;
    }

    public Cliente recuperarDatosClientes(String nif) {
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

    public boolean darArltaLlamada(Llamadas llamada, String nif) {
        for (Cliente cliente : listaClientes) {
            if(cliente.getNif().equals(nif)) {
                cliente.getListaLlamadas().add(llamada);
                return true;
            }
        }
        return false;

    }

    public List<Llamadas> llamadasCliente(String nif) {
        for(Cliente cliente : listaClientes) {
            if(cliente.getNif().equals(nif)) {
                return cliente.getListaLlamadas();
            }
        }
        return null;
    }

    public Facturas emitirFactura(String nif, Calendar inicio, Calendar fin) {
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

    public Facturas datosFactura(String nif,int codigo) {
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
        for(Cliente cliente : listaClientes) {
            if (cliente.getNif().equals(nif)) {
                return cliente.getListaFacturas();
            }
        }
        return null;
    }
}
