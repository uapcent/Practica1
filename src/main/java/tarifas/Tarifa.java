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

    public String getDia() {
        return null;
    }

    public int getHoraInicial() {
        return 0;
    }

    public int getHoraFinal() {
        return 0;
    }

    public abstract String descripcion();
    public abstract float calcularTarifa(Llamadas llamada);
}
