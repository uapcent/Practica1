import modelo.Fabricas.*;
import static org.junit.Assert.*;

import modelo.clientes.*;
import modelo.clientes.Particular;
import modelo.datosCliente.Direccion;
import org.junit.Test;
import modelo.tarifas.Tarifa;
import modelo.tarifas.TarifaBasica;
import modelo.tarifas.TarifaPorDia;
import modelo.tarifas.TarifaPorHoras;

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
        FabricaClientes clienteACrear = new FabricaClientes();
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
        FabricaClientes clienteACrear = new FabricaClientes();
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
    public void fabricaTarifasBasica() {
        Tarifa tarifa = new TarifaBasica(0.15f);
        FabricaTarifas tarifaACrear = new FabricaTarifas();
        Tarifa tarifaFabrica = tarifaACrear.crearTarifaBásica(0.15f);
        assertEquals(true, tarifa.equals(tarifaFabrica));
        System.out.println("Las tarifas basicas son iguales");
    }

    @Test
    public void fabricaTarifaDias() {
        Tarifa tarifa = new TarifaBasica(0.15f);
        tarifa = new TarifaPorDia(tarifa, 0.10f, "MARTES");
        FabricaTarifas tarifaACrear = new FabricaTarifas();
        Tarifa tarifaFabrica = tarifaACrear.crearTarifaBásica(0.15f);
        tarifaFabrica = tarifaACrear.crearTarifaPorDías(tarifaFabrica, 0.10f,"MARTES");
        assertEquals(true, tarifa.equals(tarifaFabrica));
        System.out.println("Las tarifas diarias son iguales");
    }


    @Test
    public void fabricaTarifaPorHoras() {
        Tarifa tarifa = new TarifaBasica(0.15f);
        tarifa = new TarifaPorHoras(tarifa, 0.10f, 10, 12);
        FabricaTarifas tarifaACrear = new FabricaTarifas();
        Tarifa tarifaFabrica = tarifaACrear.crearTarifaBásica(0.15f);
        tarifaFabrica = tarifaACrear.crearTarifaPorHoras(tarifaFabrica, 0.10f, 10, 12);
        assertEquals(true, tarifa.equals(tarifaFabrica));
        System.out.println("Las tarifas por horas son iguales");
    }
}
