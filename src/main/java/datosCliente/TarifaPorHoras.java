package datosCliente;

public class TarifaPorHoras extends TarifaEspecial{
    private int horaInicial;
    private int horaFinal;

    public TarifaPorHoras(Tarifa tarifa, float precioEspecial, int horaInicial, int horaFinal) {
        super(tarifa, precioEspecial);
        this.horaInicial = horaInicial;
        this.horaFinal = horaFinal;
    }

    @Override
    public String descripcion() {
        return super.descripcion() + " , ";
    }

    @Override
    public float calcularTarifa(Llamadas llamada) {
        return 0;
    }
}
