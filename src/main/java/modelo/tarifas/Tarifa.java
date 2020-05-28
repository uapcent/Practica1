package modelo.tarifas;

import modelo.datosCliente.Llamadas;

import java.io.Serializable;

public abstract class Tarifa implements Serializable {
    private float precio;

    public Tarifa(float precio) {
        this.precio = precio;
    }

    public float getPrecio() {
        return precio;
    }

    public void  setPrecio(float precio) {
        this.precio = precio;
    }

    public boolean equals(Tarifa otraTarifa) {
        if (this.precio == otraTarifa.precio)
            return true;
        return false;
    }

    public abstract String descripcion();
    public abstract float calcularTarifa(Llamadas llamada);
}
