package modelo.tarifas;

import modelo.datosCliente.Llamadas;

import java.io.Serializable;

public class Salir extends Tarifa implements Serializable {
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
