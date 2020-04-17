package Fabricas;

import tarifas.Tarifa;
import tarifas.TarifaBasica;
import tarifas.TarifaPorDia;
import tarifas.TarifaPorHoras;

public class FabricaTarifas2 implements CrearTarifas{
    @Override
    public Tarifa crearTarifaBásica(float precio) {
        return new TarifaBasica(precio);
    }

    @Override
    public Tarifa crearTarifaPorHoras(Tarifa tarifa, float precio, int horaInicial, int horaFinal) {
        return new TarifaPorHoras(tarifa, precio, horaInicial, horaFinal);
    }

    @Override
    public Tarifa crearTarifaPorDías(Tarifa tarifa, float precio, String dia) {
        return new TarifaPorDia(tarifa, precio, dia);
    }
}
