import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.LinkedList;

public class GestorTest  extends GestorClientes{

    Calendar fecha00 = new Calendar.Builder().setDate(2020,01,9).build();
    Calendar fecha01 = new Calendar.Builder().setDate(2019,11,27).build();
    Calendar fecha02 = new Calendar.Builder().setDate(2020,02,15).build();
    Calendar fecha03 = new Calendar.Builder().setDate(2019,12,13).build();

    Tarifa tarifa00 = new Tarifa(30);
    Tarifa tarifa01 = new Tarifa(50);
    Tarifa tarifa02 = new Tarifa(75);
    Tarifa tarifa03 = new Tarifa(100);

    Direccion direccion00 = new Direccion(12600,"Castellón","La Vall d'Uixó");
    Direccion direccion01 = new Direccion(12592,"Castellón","Xilxes");
    Direccion direccion02 = new Direccion(12540,"Castellón","Villarreal");
    Direccion direccion03 = new Direccion(12530,"Castellón","Burriana");


    Cliente sergi = new Particular("Sergi", "Orenga Navarro","65792347F", direccion01,"correosergi@gmail.es",fecha00,tarifa00,new LinkedList<Facturas>(), new LinkedList<Llamadas>());
    Cliente pau = new Particular("Pau", "Centelles Ortells","87651237B", direccion01,"correopau@gmail.es",fecha01,tarifa01,new LinkedList<Facturas>(), new LinkedList<Llamadas>());
    Cliente porcelanosa = new Empresa("Porcelanosa Cerámica","698459475245V", direccion02,"porcelanosabussiness@gmail.es",fecha02,tarifa02,new LinkedList<Facturas>(), new LinkedList<Llamadas>());
    Cliente pamesa = new Empresa("Pamesa Cerámica","90847636418P", direccion03,"pamesabussiness@gmail.es",fecha03,tarifa03,new LinkedList<Facturas>(), new LinkedList<Llamadas>());



    @Test
    public void darAltaClienteTest() {
        assertEquals(true, darAltaCliente(sergi));
        assertEquals(true, darAltaCliente(pau));
        assertEquals(true, darAltaCliente(porcelanosa));
        assertEquals(true, darAltaCliente(pamesa));
        assertEquals(4, devolverLista().size());
        System.out.println("TEST addCliente");
        System.out.println("Devuelve: " + devolverLista().toString());
    }

    @Test
    public void cambiarTarifaClienteTest() {
        darAltaCliente(sergi);
        darAltaCliente(pau);
        darAltaCliente(pamesa);
        darAltaCliente(porcelanosa);
        Tarifa tarifa = sergi.getTarifa();
        assertEquals(true, cambiarTarifa(sergi.getNif(), new Tarifa(50)));
        System.out.println("TEST CAMBIO TARIFA ");
        System.out.println("Le hemos cambiado la Tarifa a " + sergi.getNombre() + " con DNI:" + sergi.getNif() + " y ahora su tarifa es de " + sergi.getTarifa() + " y antes su tarifa era " + tarifa);
        assertEquals(false, cambiarTarifa("78578465D", new Tarifa(50)));

    }

    @Test
    public void borrarClienteTest() {
        assertEquals(true, borrar(sergi));
        assertEquals(true, borrar(pau));
        assertEquals(true, borrar(porcelanosa));
        assertEquals(true, borrar(pamesa));
        assertEquals(0, devolverLista().size());
        System.out.println("TEST BORRAR");
        System.out.println("Se esperaba [] y devuelve: " + devolverLista().toString());
    }

    @Test
    public void recuperarDatosClienteTest() {
        darAltaCliente(sergi);
        assertEquals(sergi, recuperarDatosClientes(sergi.getNif()));
        System.out.println("TEST RECUPERAR DATOS");
        System.out.println("La lista contiene: " + devolverLista().size() + " y sus datos pertenecen a " + sergi.getNif());

    }

    @Test
    public void devolverListaClientesTest() {
        darAltaCliente(sergi);
        darAltaCliente(pau);
        darAltaCliente(porcelanosa);
        darAltaCliente(pamesa);
        assertEquals(4, devolverLista().size());
        System.out.println("TEST DEVOLVER LISTA");
        System.out.println("La lista tiene: " + devolverLista().size() + " elementos y son: " + devolverLista().toString());
    }

    @Test
    public void darAltaLlamadaClienteTest() {
        darAltaCliente(sergi);
        Calendar fechaLlamada = new Calendar.Builder().setDate(2020,02,10).setTimeOfDay(11,40,37).build();
        Llamadas llamada = new Llamadas("698456732", fechaLlamada, 30);
        assertEquals(true, darArltaLlamada(llamada, sergi.getNif()));
        System.out.println("TEST AÑADIR LLAMADA");
        System.out.println("Se ha añadido la llamada a la lista de llamadas del cliente " + sergi.getNif() + " y su lista ahora contiene " + sergi.getListaLlamadas().size() + " llamadas.");
    }

    @Test
    public void listaLLamadasClienteTest() {
        darAltaCliente(sergi);
        Calendar fechaLlamada = new Calendar.Builder().setDate(2020,02,10).setTimeOfDay(11,40,37).build();
        Llamadas llamada = new Llamadas("698456732", fechaLlamada, 30);
        darArltaLlamada(llamada,sergi.getNif());
        assertEquals(1, llamadasCliente(sergi.getNif()).size());
        System.out.println("TEST DEVOLVER  LISTA LLAMADAS CLIENTE");
        System.out.println("Se ha añadido la llamada a la lista de llamadas del cliente " + sergi.getNif() + " y su lista ahora contiene " + sergi.getListaLlamadas().size() + " llamadas " + llamadasCliente(sergi.getNif()).toString());
    }

    @Test
    public void emitirFacturaTest() {

    }

    @Test
    public void datosFacturaTest() {

    }

    @Test
    public void listaFacturasClienteTest() {

    }



}
