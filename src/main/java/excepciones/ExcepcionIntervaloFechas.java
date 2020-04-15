package excepciones;

import java.util.Calendar;

public class ExcepcionIntervaloFechas extends Exception{

    public ExcepcionIntervaloFechas() {
        super("La fecha inicial o final no se encuentra en el intervalo que corresponde.");

    }

    public ExcepcionIntervaloFechas(Calendar fechaInicial) {
        super("La fecha inicial no puede ser menor a esta fecha: " + fechaInicial.getTime());

    }

    public ExcepcionIntervaloFechas(Calendar fechaInicial, Calendar fechaFinal) {
        super("La fecha inicial: " + fechaInicial.getTime() + " no puede ser mayor que la fecha final: " + fechaFinal.getTime());
    }
}
