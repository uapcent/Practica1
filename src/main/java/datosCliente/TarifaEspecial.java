package datosCliente;

public abstract class TarifaEspecial extends Tarifa {
    private Tarifa tarifa;

    public TarifaEspecial(Tarifa tarifa, float precioEspecial) {
        super(precioEspecial);
        this.tarifa = tarifa;
    }

    @Override
    public float getPrecio() {
        if (tarifa.getPrecio() < super.getPrecio())
            return tarifa.getPrecio();
        else
            return super.getPrecio();
    }

    @Override
    public String descripcion() {
        return tarifa.descripcion();
    }



}
