package datosCliente;

import java.util.Calendar;

public class TarifaPorDia extends TarifaEspecial {
    private String dia;

    public TarifaPorDia(Tarifa tarifa, float precioEspecial, String dia) {
        super(tarifa, precioEspecial);
        this.dia = dia;
    }

    @Override
    public String descripcion() {
        return super.descripcion() + " , ";
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

    @Override
    public float calcularTarifa(Llamadas llamada) {
        Calendar fecha = llamada.getFecha();
        int dia = Calendar.DAY_OF_MONTH;
        int mes = Calendar.MONTH;
        int año = Calendar.YEAR;
        return 0;
    }

}
