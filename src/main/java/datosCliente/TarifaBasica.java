package datosCliente;

public class TarifaBasica extends Tarifa {

    public TarifaBasica(float precio) {
        super(precio);
    }

    @Override
    public  String descripcion() {
        return "Esta es la tarifa básica.";
    }

    @Override
    public float calcularTarifa(Llamadas llamada) {
        return super.getPrecio()*llamada.getDuracion();
    }
}
