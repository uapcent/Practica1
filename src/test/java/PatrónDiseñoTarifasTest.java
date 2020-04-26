
import org.junit.Test;
import modelo.tarifas.*;
import java.util.Calendar;
import modelo.datosCliente.Llamadas;
import static org.junit.Assert.*;

public class PatrónDiseñoTarifasTest {

    Calendar fechaLlamada = new Calendar.Builder().setDate(2020,02,10).setTimeOfDay(11,40,37).build();
    Llamadas llamadas = new Llamadas("654766553", fechaLlamada, 30);
    Tarifa tarifa = new TarifaBasica(0.15f);

    @Test
    public void precioTarifaCorrecto() {
        System.out.println("Calculamos el precio de las modelo.tarifas");
        assertEquals(4.5, tarifa.calcularTarifa(llamadas),0);
        System.out.println("Se esperaba 4.5 y el resultado es: " + tarifa.calcularTarifa(llamadas));
        tarifa = new TarifaPorDia(tarifa,0.10f, "LUNES");
        assertEquals(3.0, tarifa.calcularTarifa(llamadas),0);
        System.out.println("Se esperaba 3.0 y devuelve: " + tarifa.calcularTarifa(llamadas));
        tarifa = new TarifaPorHoras(tarifa, 0.05f, 10, 13);
        assertEquals(1.5, tarifa.calcularTarifa(llamadas), 0);
        System.out.println("Se esperaba 1.5 y devuelve: " + tarifa.calcularTarifa(llamadas));
    }
    @Test
    public void precioMasBajoTarifa() {
        System.out.println("\nElegir el precio más barato");
        System.out.println("El precio de la tarifa es: " + tarifa.calcularTarifa(llamadas));
        tarifa = new TarifaPorDia(tarifa,0.10f, "LUNES");
        System.out.println("El precio de la tarifa diaria es: " + tarifa.calcularTarifa(llamadas));
        tarifa = new TarifaPorHoras(tarifa, 0.05f, 10, 13);
        System.out.println("El precio de la tarifa por horas es: " + tarifa.calcularTarifa(llamadas));
        assertEquals(0.05f, tarifa.getPrecio(),0);
        System.out.println("Se espera que la tarifa por horas se la mas barata con 0.05 cnts/min: " + tarifa.getPrecio());
        System.out.println("Y si añadimos otra Tarifa más barata: ");
        tarifa = new TarifaBasica(0.01f);
        assertEquals(0.01f, tarifa.getPrecio(),0);
        System.out.println("Se espera que la nueva tarifa básica sea la mas barata con 0.01 cnts/min: " + tarifa.getPrecio());
    }
}
