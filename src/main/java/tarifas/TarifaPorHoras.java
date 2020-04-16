package tarifas;

import datosCliente.Llamadas;

import java.io.Serializable;
import java.util.Calendar;

public class TarifaPorHoras extends TarifaEspecial implements Serializable {
    private int horaInicial;
    private int horaFinal;

    public TarifaPorHoras(Tarifa tarifa, float precioEspecial, int horaInicial, int horaFinal) {
        super(tarifa, precioEspecial);
        this.horaInicial = horaInicial;
        this.horaFinal = horaFinal;
    }

    @Override
    public String descripcion() {
        return "Usas la Tarifa por horas";
    }

    @Override
    public float calcularTarifa(Llamadas llamada) {
        Calendar fecha = llamada.getFecha();
        int hora = fecha.get(Calendar.HOUR);
        if(hora >= this.horaInicial && hora < this.horaFinal) {
            return super.getPrecio()*llamada.getDuracion();
        }
        return 0;
    }

    public int getHoraInicial() {
        return horaInicial;
    }
    public int getHoraFinal() {
        return horaFinal;
    }

}
