package modelo;

import modelo.clientes.Cliente;
import modelo.datosCliente.Facturas;
import modelo.datosCliente.Fecha;
import modelo.datosCliente.Llamadas;
import modelo.excepciones.ExcecpcionClienteYaExiste;
import modelo.excepciones.ExcepcionClienteNoExiste;
import modelo.excepciones.ExcepcionIntervaloFechas;
import modelo.tarifas.Tarifa;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface GestorModelo {

    public boolean darAltaCliente(Cliente cliente) throws ExcecpcionClienteYaExiste;

    public Cliente buscarCliente(String nif);

    public boolean borrar(String nif) throws ExcepcionClienteNoExiste;

    public boolean cambiarTarifa(String nif, Tarifa tarifa) throws ExcepcionClienteNoExiste;

    public Cliente recuperarDatosClientes(String nif) throws ExcepcionClienteNoExiste;

    public Set<Cliente> devolverLista();

    public void listaClientesTXT();

    public boolean darAltaLlamada(Llamadas llamada, String nif) throws ExcepcionClienteNoExiste;

    public List<Llamadas> llamadasCliente(String nif) throws ExcepcionClienteNoExiste;

    public void listaLlamadasTXT(String nif) throws ExcepcionClienteNoExiste;

    public Facturas emitirFactura(String nif, Calendar inicio, Calendar fin) throws ExcepcionClienteNoExiste, ExcepcionIntervaloFechas;

    public Facturas datosFactura(String nif, int codigo) throws ExcepcionClienteNoExiste;

    public List<Facturas> listaFacturaCliente(String nif) throws ExcepcionClienteNoExiste;

    public void listaFacturasTXT(String nif) throws ExcepcionClienteNoExiste;

    public void datosClienteTXT(String nif) throws ExcepcionClienteNoExiste;

    public void datosFacturaTXT(String nif, int codigo);

    public < T extends Fecha> Collection muestra (Collection<T> conjunto, Calendar inicio, Calendar fin) throws ExcepcionIntervaloFechas;
}
