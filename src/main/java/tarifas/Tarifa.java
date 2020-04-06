package tarifas;

import datosCliente.Llamadas;

public abstract class Tarifa {
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

    public abstract String descripcion();
    public abstract float calcularTarifa(Llamadas llamada);



}
