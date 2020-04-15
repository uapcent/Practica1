import clientes.Cliente;
import datosCliente.*;
import clientes.Empresa;
import clientes.Particular;
import excepciones.ExcecpcionClienteYaExiste;
import excepciones.ExcepcionClienteNoExiste;
import excepciones.ExcepcionIntervaloFechas;
import gestion.GestorClientes;
import org.junit.jupiter.api.Test;
import tarifas.Tarifa;
import tarifas.TarifaBasica;

import static org.junit.Assert.*;
import java.util.Calendar;

public class GestorTest  extends GestorClientes {

    Calendar fecha00 = new Calendar.Builder().setDate(2020,01,9).build();
    Calendar fecha01 = new Calendar.Builder().setDate(2019,11,27).build();
    Calendar fecha02 = new Calendar.Builder().setDate(2020,02,15).build();
    Calendar fecha03 = new Calendar.Builder().setDate(2019,12,13).build();

    Tarifa tarifa00 = new TarifaBasica(0.1f);
    Tarifa tarifa01 = new TarifaBasica(50.0f);
    Tarifa tarifa02 = new TarifaBasica(75.0f);
    Tarifa tarifa03 = new TarifaBasica(100.0f);

    Direccion direccion00 = new Direccion(12600,"Castellón","La Vall d'Uixó");
    Direccion direccion01 = new Direccion(12592,"Castellón","Xilxes");
    Direccion direccion02 = new Direccion(12540,"Castellón","Villarreal");
    Direccion direccion03 = new Direccion(12530,"Castellón","Burriana");


    Cliente sergi = new Particular("Sergi", "Orenga Navarro","65792347F", direccion01,"correosergi@gmail.es",fecha00,tarifa00);
    Cliente pau = new Particular("Pau", "Centelles Ortells","87651237B", direccion01,"correopau@gmail.es",fecha01,tarifa01);
    Cliente porcelanosa = new Empresa("Porcelanosa Cerámica","698459475245V", direccion02,"porcelanosabussiness@gmail.es",fecha02,tarifa02);
    Cliente pamesa = new Empresa("Pamesa Cerámica","90847636418P", direccion03,"pamesabussiness@gmail.es",fecha03,tarifa03);



    @Test
    public void darAltaClienteTest() throws ExcecpcionClienteYaExiste {
        assertEquals(true, darAltaCliente(sergi));
        assertEquals(true, darAltaCliente(pau));
        assertEquals(true, darAltaCliente(porcelanosa));
        assertEquals(true, darAltaCliente(pamesa));
        assertEquals(4, devolverLista().size());
        System.out.println("TEST AÑADIR CLIENTE");
        System.out.println("Devuelve: " + devolverLista().toString());
    }

    @Test
    public void cambiarTarifaClienteTest() throws ExcecpcionClienteYaExiste, ExcepcionClienteNoExiste {
        darAltaCliente(sergi);
        darAltaCliente(pau);
        darAltaCliente(pamesa);
        darAltaCliente(porcelanosa);
        Tarifa tarifa = sergi.getTarifa();
        assertEquals(true, cambiarTarifa(sergi.getNif(), new TarifaBasica(50)));
        System.out.println("TEST CAMBIO TARIFA ");
        System.out.println("Le hemos cambiado la tarifas.Tarifa a " + sergi.getNombre() + " con DNI:" + sergi.getNif() + " y ahora su tarifa es de " + sergi.getTarifa() + " y antes su tarifa era " + tarifa);
    }

    @Test
    public void borrarClienteTest() throws ExcecpcionClienteYaExiste, ExcepcionClienteNoExiste{
        darAltaCliente(sergi);
        darAltaCliente(pau);
        darAltaCliente(pamesa);
        darAltaCliente(porcelanosa);
        System.out.println(devolverLista().size());
        assertEquals(true, borrar("65792347F"));
        assertEquals(true, borrar("87651237B"));
        assertEquals(true, borrar("698459475245V"));
        assertEquals(true, borrar("90847636418P"));
        assertEquals(0, devolverLista().size());
        System.out.println("TEST BORRAR CLIENTE");
        System.out.println("Se esperaba [] y devuelve: " + devolverLista().toString());
    }

    @Test
    public void recuperarDatosClienteTest() throws ExcecpcionClienteYaExiste, ExcepcionClienteNoExiste{
        darAltaCliente(sergi);
        assertEquals(sergi, recuperarDatosClientes(sergi.getNif()));
        System.out.println("TEST RECUPERAR DATOS CLIENTE");
        System.out.println("La lista contiene: " + devolverLista().size() + " y sus datos pertenecen a " + sergi.getNif());

    }

    @Test
    public void devolverListaClientesTest()throws ExcecpcionClienteYaExiste {
        darAltaCliente(sergi);
        darAltaCliente(pau);
        darAltaCliente(porcelanosa);
        darAltaCliente(pamesa);
        assertEquals(4, devolverLista().size());
        System.out.println("TEST DEVOLVER LISTA");
        System.out.println("La lista tiene: " + devolverLista().size() + " elementos y son: " + devolverLista().toString());
    }

    @Test
    public void darAltaLlamadaClienteTest() throws ExcecpcionClienteYaExiste, ExcepcionClienteNoExiste{
        darAltaCliente(sergi);
        Calendar fechaLlamada = new Calendar.Builder().setDate(2020,02,10).setTimeOfDay(11,40,37).build();
        Llamadas llamada = new Llamadas("698456732", fechaLlamada, 30);
        assertEquals(true, darAltaLlamada(llamada, sergi.getNif()));
        System.out.println("TEST AÑADIR LLAMADA");
        System.out.println("Se ha añadido la llamada a la lista de llamadas del cliente " + sergi.getNif() + " y su lista ahora contiene " + sergi.getListaLlamadas().size() + " llamadas.");
        System.out.println("La llamada ha sido: " + llamada.getFecha().getTime());
    }

    @Test
    public void listaLLamadasClienteTest() throws ExcecpcionClienteYaExiste, ExcepcionClienteNoExiste{
        darAltaCliente(sergi);
        Calendar fechaLlamada = new Calendar.Builder().setDate(2020,02,10).setTimeOfDay(11,40,37).build();
        Llamadas llamada = new Llamadas("698456732", fechaLlamada, 30);
        darAltaLlamada(llamada,sergi.getNif());
        assertEquals(1, llamadasCliente(sergi.getNif()).size());
        System.out.println("TEST DEVOLVER  LISTA LLAMADAS CLIENTE");
        System.out.println("Se ha añadido la llamada a la lista de llamadas del cliente " + sergi.getNif() + " y su lista ahora contiene " + sergi.getListaLlamadas().size() + " llamadas " + llamadasCliente(sergi.getNif()).toString());
    }

    @Test
    public void emitirFacturaTest() throws ExcecpcionClienteYaExiste, ExcepcionClienteNoExiste, ExcepcionIntervaloFechas {
        darAltaCliente(sergi);
        Calendar fechaLlamada0 = new Calendar.Builder().setDate(2020,02,7).setTimeOfDay(11,40,37).build();
        Calendar fechaLlamada1 =  new Calendar.Builder().setDate(2020,01,15).setTimeOfDay(17,32,25).build();
        Llamadas llamada0 = new Llamadas("745532552",fechaLlamada0,15);
        Llamadas llamada1 = new Llamadas("745532552",fechaLlamada1,32);
        darAltaLlamada(llamada0, sergi.getNif());
        darAltaLlamada(llamada1,sergi.getNif());
        Calendar inicio = new Calendar.Builder().setDate(2020,01,2).build();
        Calendar fin =    new Calendar.Builder().setDate(2020,02,9).build();
        emitirFactura(sergi.getNif(),inicio,fin);
        assertEquals(1, sergi.getListaFacturas().size());
        System.out.println("TEST EMITIR FACTURA");
        System.out.println("La factura del cliente se ha almacenado en: " + sergi.getListaFacturas().toString());
        for (Facturas factura : sergi.getListaFacturas()) {
            System.out.println("El codigo de la factura es: " + factura.getCodigo() + " y el importe es de: " + factura.getImporte() + " euros.");
        }

    }

    @Test
    public void datosFacturaTest() throws ExcecpcionClienteYaExiste, ExcepcionClienteNoExiste, ExcepcionIntervaloFechas{
        darAltaCliente(sergi);
        Calendar fechaLlamada0 = new Calendar.Builder().setDate(2020,02,7).setTimeOfDay(11,40,37).build();
        Calendar fechaLlamada1 =  new Calendar.Builder().setDate(2020,01,15).setTimeOfDay(17,32,25).build();
        Llamadas llamada0 = new Llamadas("745532552",fechaLlamada0,15);
        Llamadas llamada1 = new Llamadas("745532552",fechaLlamada1,32);
        darAltaLlamada(llamada0, sergi.getNif());
        darAltaLlamada(llamada1,sergi.getNif());
        Calendar inicio = new Calendar.Builder().setDate(2020,01,2).build();
        Calendar fin =    new Calendar.Builder().setDate(2020,02,9).build();
        emitirFactura(sergi.getNif(), inicio,fin);
        Facturas resultado = datosFactura(sergi.getNif(), 0);
        assertEquals(true, sergi.getListaFacturas().contains(resultado));
        System.out.println("TEST DATOS FACTURA");
        System.out.println("Los datos de la factura son: " + resultado.getCodigo() + " el importe " + resultado.getImporte());
    }

    @Test
    public void listaFacturasClienteTest() throws ExcecpcionClienteYaExiste, ExcepcionClienteNoExiste, ExcepcionIntervaloFechas{
        darAltaCliente(sergi);
        Calendar fechaLlamada0 = new Calendar.Builder().setDate(2020,02,7).setTimeOfDay(11,40,37).build();
        Calendar fechaLlamada1 =  new Calendar.Builder().setDate(2020,01,15).setTimeOfDay(17,32,25).build();
        Llamadas llamada0 = new Llamadas("745532552",fechaLlamada0,15);
        Llamadas llamada1 = new Llamadas("745532552",fechaLlamada1,32);
        darAltaLlamada(llamada0, sergi.getNif());
        darAltaLlamada(llamada1,sergi.getNif());
        Calendar inicio = new Calendar.Builder().setDate(2020,01,2).build();
        Calendar fin =    new Calendar.Builder().setDate(2020,02,9).build();
        emitirFactura(sergi.getNif(), inicio,fin);
        assertEquals(1, sergi.getListaFacturas().size());
        System.out.println("TEST DEVOLVER LISTA FACTURAS CLIENTE");
        System.out.println("El clientes.Cliente solicitado tiene estas facturas: " + sergi.getListaFacturas().toString());
    }

    @Test
    public void listaFechasClienteTest() throws ExcecpcionClienteYaExiste,ExcepcionIntervaloFechas{
        darAltaCliente(sergi);
        darAltaCliente(pau);
        darAltaCliente(pamesa);
        darAltaCliente(porcelanosa);
        Calendar inicio = new Calendar.Builder().setDate(2020,01,1).build();
        Calendar fin =    new Calendar.Builder().setDate(2020,02,25).build();

        assertEquals(2, muestra(devolverLista(), inicio, fin).size());
        System.out.println("TEST DEVOLVER LISTA CLIENTE INTERVALO");
        System.out.println("Los clientes en este intervalo son: " + muestra(devolverLista(), inicio, fin).toString());
    }
}



