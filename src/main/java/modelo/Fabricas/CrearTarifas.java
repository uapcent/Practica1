package modelo.Fabricas;

import modelo.tarifas.Tarifa;

public interface CrearTarifas {

    public Tarifa crearTarifaBásica(float precio);

    public Tarifa crearTarifaPorHoras(Tarifa tarifa, float precio, int horaInicial, int horaFinal);

    public Tarifa crearTarifaPorDías(Tarifa tarifa, float precio, String dia);

}
