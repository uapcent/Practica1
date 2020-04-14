import Fabricas.*;
import static org.junit.Assert.*;

import clientes.*;
import clientes.Particular;
import datosCliente.Direccion;
import org.junit.Test;
import tarifas.Tarifa;
import tarifas.TarifaBasica;

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
        System.out.println("Vamos a ver si crea un cliente según nuestros datos: ");
        Cliente creado = FabricaCliente.PARTICULAR.getCliente("Sergi", "Orenga Navarro","65792347F",direccion01,"correosergi@gmail.es", fecha00,tarifa00);
        assertEquals(particular.getNombre(), creado.getNombre());
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
        Cliente creado = FabricaCliente.EMPRESA.getCliente("Porcelanosa Cerámica","698459475245V", direccion02,"porcelanosabussiness@gmail.es",fecha02,tarifa02);
        assertEquals(empresa.getNombre(), creado.getNombre());
        assertEquals(empresa.getNif(), creado.getNif());
        assertEquals(empresa.getDireccion(), creado.getDireccion());
        assertEquals(empresa.getEmail(), creado.getEmail());
        assertEquals(empresa.getFecha(), creado.getFecha());
        assertEquals(empresa.getTarifa(), creado.getTarifa());
        System.out.println("Se ha creado el cliente: \n" + empresa.toString());
    }
}
