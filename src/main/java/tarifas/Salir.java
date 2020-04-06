package tarifas;

import datosCliente.Llamadas;

public class Salir extends Tarifa {
    public Salir(float precio) {
        super(precio);
    }

    @Override
    public String descripcion() {
        return "Adiós";
    }

    @Override
    public float calcularTarifa(Llamadas llamada) {
        return 0;
    }
}
