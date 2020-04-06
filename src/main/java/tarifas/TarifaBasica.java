package tarifas;

import datosCliente.Llamadas;

public class TarifaBasica extends Tarifa {

    public TarifaBasica(float precio) {
        super(precio);
    }

    @Override
    public  String descripcion() {
        return "Usas la tarifa básica.";
    }

    @Override
    public float calcularTarifa(Llamadas llamada) {
        return super.getPrecio()*llamada.getDuracion();
    }
}
