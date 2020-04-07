package tarifas;

import datosCliente.Llamadas;

import java.util.Calendar;

public class prueba {
    public static void main(String[] args) {
        Calendar fechaLlamada = new Calendar.Builder().setDate(2020,02,10).setTimeOfDay(11,40,37).build();
        Llamadas llamadas = new Llamadas("654766553", fechaLlamada, 30);
        Tarifa tarifa = new TarifaBasica(0.15f);
        tarifa.calcularTarifa(llamadas);
        System.out.println(tarifa.calcularTarifa(llamadas));
        System.out.println(tarifa.getPrecio());

        System.out.println();

        tarifa = new TarifaPorDia(tarifa, 0.1f, "LUNES");
        System.out.println(tarifa.calcularTarifa(llamadas));
        System.out.println(diaSemana(2,10,2020));
        System.out.println(tarifa.getPrecio());

        tarifa = new TarifaPorHoras(tarifa, 0.05f, 10, 13);
        System.out.println(tarifa.calcularTarifa(llamadas));
        System.out.println(tarifa.getPrecio());

        tarifa = new TarifaPorDia(tarifa, 0.04f, "LUNES");
        System.out.println(tarifa.calcularTarifa(llamadas));
        System.out.println(diaSemana(2,10,2020));
        System.out.println(tarifa.getPrecio());
    }

    public static String diaSemana(int mes, int dias, int año) {
        String dia="";
        int numD;
        Calendar c = Calendar.getInstance();
        c.set(año,mes-1,dias);
        numD=c.get(Calendar.DAY_OF_WEEK);
        if(numD == Calendar.SUNDAY)
            dia="DOMINGO";
        else if(numD == Calendar.MONDAY)
            dia="LUNES";
        else if(numD == Calendar.TUESDAY)
            dia="MARTES";
        else if(numD == Calendar.WEDNESDAY)
            dia="MIERCOLES";
        else if(numD == Calendar.THURSDAY)
            dia="JUEVES";
        else if(numD == Calendar.FRIDAY)
            dia="VIERNES";
        else if(numD == Calendar.SATURDAY)
            dia="SABADO";
        return dia;
    }
}
