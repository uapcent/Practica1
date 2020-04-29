package modelo;

import modelo.clientes.Cliente;
import modelo.datosCliente.Facturas;
import modelo.datosCliente.Llamadas;
import modelo.excepciones.ExcepcionClienteNoExiste;

import java.util.List;
import java.util.Set;

public class MostrarDatos {
    public static String datosLista(Set<Cliente> lista){
        StringBuilder sb = new StringBuilder();
        for (Cliente cliente : lista){
            sb.append(cliente.toString() + "\n");
        }
        return sb.toString();
    }

    public static String llamadasCliente(List<Llamadas> lista){
        StringBuilder sb = new StringBuilder();
        for (Llamadas llamada: lista){
            sb.append(llamada.toString() + "\n");
        }
        return sb.toString();
    }

    public static String facturasCliente(List<Facturas> lista){
        StringBuilder sb = new StringBuilder();
        for (Facturas factura: lista){
            sb.append(factura.toString() + "\n");
        }
        return sb.toString();
    }
}
