package datosCliente;

import java.util.Calendar;

public class Facturas implements Fecha {
    private int codigo;
    private Tarifa tarifa;
    private Calendar fechaEmision;
    private Calendar fechaFacturacionInicio;
    private Calendar fechaFacturacionFin;
    private double importe;


    public Facturas() {
        this.codigo = -1;
        this.tarifa = null;
        this.fechaEmision = null;
        this.fechaFacturacionInicio = null;
        this.fechaFacturacionFin = null;
        this.importe = -1;
    }




    public Facturas(int codigo, Tarifa tarifa, Calendar fechaEmision, Calendar fechaFacturacionInicio, Calendar fechaFacturacionFin, double importe) {
        this.codigo = codigo;
        this.tarifa = tarifa;
        this.fechaEmision = fechaEmision;
        this.fechaFacturacionInicio = fechaFacturacionInicio;
        this.fechaFacturacionFin = fechaFacturacionFin;
        this.importe = importe;
    }

    @Override
    public Calendar getFecha(){
        return fechaEmision;
    }

    public int getCodigo() {
        return codigo;
    }

    public Tarifa getTarifa() {
        return tarifa;
    }

    public double getImporte() {
        return importe;
    }

    public Calendar getFechaFacturacionInicio() {
        return fechaFacturacionInicio;
    }

    public Calendar getFechaFacturacionFin() {
        return fechaFacturacionFin;
    }

    public void setTarifa(Tarifa tarifa) {
        this.tarifa = tarifa;
    }

    public void setFechaEmision(Calendar fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public void setFechaFacturacionInicio(Calendar fechaFacturacionInicio) {
        this.fechaFacturacionInicio = fechaFacturacionInicio;
    }

    public void setFechaFacturacionFin(Calendar fechaFacturacionFin) {
        this.fechaFacturacionFin = fechaFacturacionFin;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

}