package modelo.Fabricas;

import modelo.tarifas.Tarifa;
import modelo.tarifas.TarifaBasica;
import modelo.tarifas.TarifaPorDia;
import modelo.tarifas.TarifaPorHoras;

public class FabricaTarifas implements CrearTarifas{
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
