import Fabricas.*;
import static org.junit.Assert.*;

import clientes.*;
import clientes.Particular;
import datosCliente.Direccion;
import org.junit.Test;
import tarifas.Tarifa;
import tarifas.TarifaBasica;
import tarifas.TarifaPorDia;
import tarifas.TarifaPorHoras;

import java.util.Calendar;

public class FabricasTest {

    Calendar fecha00 = new Calendar.Builder().setDate(2020,01,9).build();
    Tarifa tarifa00 = new TarifaBasica(0.1f);
    Direccion direccion01 = new Direccion(12592,"Castellón","Xilxes");
    Cliente particular = new Particular("Sergi", "Orenga Navarro","65792347F", direccion01,"correosergi@gmail.es",fecha00,tarifa00);
    Calendar fecha02 = new Calendar.Builder().setDate(2020,02,15).build();
    Tarifa tarifa02 = new TarifaBasica(75.0f);
    Direccion direccion02 = new Direccion(12540,"Castellón","Villarreal");
    Cliente empresa = new Empresa("Porcelanosa Cerámica","698459475245V", direccion02,"porcelanosabussiness@gmail.es",fecha02,tarifa02);


    @Test
    public void fabricaClientesParticular() {
        System.out.println("\nVamos a ver si crea un particular según nuestros datos: ");
        FabricaClientes2 clienteACrear = new FabricaClientes2();
        Cliente creado = clienteACrear.crearParticular("Sergi", "Orenga Navarro","65792347F",direccion01,"correosergi@gmail.es", fecha00,tarifa00);
        assertEquals(particular.getNombre(), creado.getNombre());
        assertEquals(particular.getApellidos(), creado.getApellidos());
        assertEquals(particular.getNif(), creado.getNif());
        assertEquals(particular.getDireccion(), creado.getDireccion());
        assertEquals(particular.getEmail(), creado.getEmail());
        assertEquals(particular.getFecha(), creado.getFecha());
        assertEquals(particular.getTarifa(), creado.getTarifa());
        System.out.println("Se ha creado el cliente: \n" + particular.toString());
    }

    @Test
    public void fabricaClientesEmpresa() {
        System.out.println("\nVamos a ver si crea un cliente según nuestros datos: ");
        FabricaClientes2 clienteACrear = new FabricaClientes2();
        Cliente creado = clienteACrear.crearEmpresa("Porcelanosa Cerámica","698459475245V", direccion02,"porcelanosabussiness@gmail.es",fecha02,tarifa02);
        assertEquals(empresa.getNombre(), creado.getNombre());
        assertEquals(empresa.getNif(), creado.getNif());
        assertEquals(empresa.getDireccion(), creado.getDireccion());
        assertEquals(empresa.getEmail(), creado.getEmail());
        assertEquals(empresa.getFecha(), creado.getFecha());
        assertEquals(empresa.getTarifa(), creado.getTarifa());
        System.out.println("Se ha creado el cliente: \n" + empresa.toString());
    }

    @Test
    public void fabricaTarifaBasica() {
        Tarifa tarifa = new TarifaBasica(0.15f);
        FabricaTarifas2 tarifaACrear = new FabricaTarifas2();
        Tarifa tarifaFabrica = tarifaACrear.crearTarifaBásica(0.15f);
        assertEquals(tarifa.getPrecio(), tarifaFabrica.getPrecio(),0);
        System.out.println("Crea la misma tarifa con el mismo precio: " + tarifaFabrica.getPrecio());
    }
    @Test
    public void fabricaTarifaDias() {
        Tarifa tarifa = new TarifaBasica(0.15f);
        tarifa = new TarifaPorDia(tarifa, 0.10f, "MARTES");
        FabricaTarifas2 tarifaACrear = new FabricaTarifas2();
        Tarifa tarifaFabrica = tarifaACrear.crearTarifaBásica(0.15f);
        tarifaFabrica = tarifaACrear.crearTarifaPorDías(tarifaFabrica, 0.10f,"MARTES");
        assertEquals(tarifa.getPrecio(), tarifaFabrica.getPrecio(),0);
        assertEquals(tarifa.getDia(), tarifaFabrica.getDia());
        System.out.println("Crea la misma tarifa con el mismo precio: " + tarifaFabrica.getPrecio());
        System.out.println("Crea la misma tarifa con el mismo precio: " + tarifaFabrica.getDia());
    }

    @Test
    public void fabricaTarifaPorHoras() {
        Tarifa tarifa = new TarifaBasica(0.15f);
        tarifa = new TarifaPorHoras(tarifa, 0.10f, 10,12);
        FabricaTarifas2 tarifaACrear = new FabricaTarifas2();
        Tarifa tarifaFabrica = tarifaACrear.crearTarifaBásica(0.15f);
        tarifaFabrica = tarifaACrear.crearTarifaPorHoras(tarifaFabrica, 0.10f,10,12);
        assertEquals(tarifa.getPrecio(), tarifaFabrica.getPrecio(),0);
        assertEquals(tarifa.getHoraInicial(), tarifaFabrica.getHoraInicial());
        assertEquals(tarifa.getHoraFinal(), tarifaFabrica.getHoraFinal());
        System.out.println("Crea la misma tarifa con el mismo precio: " + tarifaFabrica.getPrecio());
        System.out.println("Crea la misma tarifa con la misma hora inicial " + tarifaFabrica.getHoraInicial() + " y hora final " + tarifaFabrica.getHoraFinal());
    }

}
